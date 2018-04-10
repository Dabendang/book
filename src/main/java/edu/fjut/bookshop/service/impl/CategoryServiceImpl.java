package edu.fjut.bookshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.dao.BookMapper;
import edu.fjut.bookshop.dao.CateGoryMapper;
import edu.fjut.bookshop.dao.StockMapper;
import edu.fjut.bookshop.domain.CateGory;
import edu.fjut.bookshop.domain.CateGoryExample;
import edu.fjut.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dabendan on 2018/3/24.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CateGoryMapper cateGoryMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public PageInfo getCategorys(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        CateGoryExample cateGoryExample = new CateGoryExample();
        cateGoryExample.setDistinct(Boolean.TRUE);
        List<CateGory> cateGories = cateGoryMapper.selectByExample(cateGoryExample);
        PageInfo pageInfo = new PageInfo(cateGories, BookShopConst.navigatePages);

        return pageInfo;
    }

    @Override
    public ServerResponse update(CateGory cateGory) {

        int result = cateGoryMapper.updateByPrimaryKeySelective(cateGory);
        if(result>0){
            return ServerResponse.createBySuccessMsg("修 改 成 功!");
        }

        return ServerResponse.createByErrorMsg("修 改 失 败!");
    }

    @Override
    public ServerResponse save(CateGory cateGory) {
        cateGory.setInventory(0L);
        cateGory.setSalesvolume(0L);
        int result = cateGoryMapper.insert(cateGory);

        Integer resultCount=stockMapper.updateTotalCategoryINC();

        if(result>0 && resultCount>0){
            return ServerResponse.createBySuccessMsg("保 存 成 功!");
        }
        return ServerResponse.createByErrorMsg("保 存 失 败!");
    }

    @Override
    public ServerResponse delete(Integer categoryid) {
        if(categoryid==null){
            return ServerResponse.createByErrorMsg("参 数 错 误");
        }

        Integer count=bookMapper.checkCategoryId(categoryid);

        if(count>0){
            return ServerResponse.createByErrorMsg("不 能 删 除 有 对 应 图 书 的 分 类!");
        }

        Integer resultCount=stockMapper.updateTotalCategoryDec();

        int i = cateGoryMapper.deleteByPrimaryKey(categoryid);

        if(i>0 && resultCount>0){
            return ServerResponse.createBySuccessMsg("删 除 成 功!");
        }
        return ServerResponse.createByErrorMsg("删 除 失 败!");
    }

    @Override
    public List<CateGory> getCategorysWithOutPage() {
        CateGoryExample cateGoryExample = new CateGoryExample();
        cateGoryExample.setDistinct(Boolean.TRUE);
        List<CateGory> cateGories = cateGoryMapper.selectByExample(cateGoryExample);

        return cateGories;
    }
}

