package edu.fjut.bookshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.dao.BookMapper;
import edu.fjut.bookshop.dao.CateGoryMapper;
import edu.fjut.bookshop.dao.StockMapper;
import edu.fjut.bookshop.domain.*;
import edu.fjut.bookshop.service.BookService;
import edu.fjut.bookshop.utils.IDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dabendan on 2018/3/24.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CateGoryMapper cateGoryMapper;

    @Autowired
    private StockMapper stockMapper;


    @Override
    public PageInfo list(Integer pageNum, Integer pageSize, String bookName, String categoryid) {


        PageHelper.startPage(pageNum,pageSize);
        if(StringUtils.isNotBlank(bookName)) {
            bookName = new StringBuilder("%").append(bookName).append("%").toString();
        }
        List<Book> bookList = bookMapper.selectByBookNameAndCategoryId(bookName,categoryid);
        //封装了详细的分页信息,
        PageInfo pageInfo = new PageInfo(bookList, BookShopConst.navigatePages);
        return pageInfo;
    }

    @Override
    public ServerResponse save(Book book) {
        Integer categoryid = book.getCategoryid();
        CateGory cateGory = cateGoryMapper.selectByPrimaryKey(categoryid);

        Long oldStock = cateGory.getInventory();

        Integer addStocknum = book.getStocknum();
        cateGory.setInventory(oldStock+addStocknum);
        int i=cateGoryMapper.updateByPrimaryKeySelective(cateGory);

        Stock stock = stockMapper.selectByPrimaryKey(1);
        stock.setStocknum(stock.getStocknum()+addStocknum);
        int j=stockMapper.updateByPrimaryKeySelective(stock);

        //生成随机13位数主键
        book.setBookisbn(IDUtil.getFixLenthString(BookShopConst.DEFAULT_BOOKISBN_LENGTH));

        int k = bookMapper.insert(book);

        if(i>0 && j>0 && k>0){
            return ServerResponse.createBySuccessMsg("保存成功");
        }

        return ServerResponse.createByErrorMsg("服 务 器 忙,请 稍 后 再 试!");

    }
    @Override
    public ServerResponse delete(String bookIsbn) {
        if(bookIsbn==null){
            return ServerResponse.createByErrorMsg("参 数 错 误 ");
        }

        Integer delNum=bookMapper.selectStockNumByBookIsbn(bookIsbn);
        //更新分类库存
        Integer categoryid = bookMapper.selectCategoryIdByBookIsbn(bookIsbn);
        CateGory cateGory = cateGoryMapper.selectByPrimaryKey(categoryid);
        Long oldStock = cateGory.getInventory();
        cateGory.setInventory(oldStock-delNum);
        int i=cateGoryMapper.updateByPrimaryKeySelective(cateGory);


        //更新总库存
        Stock stock = stockMapper.selectByPrimaryKey(1);
        stock.setStocknum(stock.getStocknum()-delNum);
        int j=stockMapper.updateByPrimaryKeySelective(stock);

        int resultCount = bookMapper.deleteByPrimaryKey(bookIsbn);
        if(resultCount>0 && i>0 && j>0){
            return ServerResponse.createBySuccessMsg("删 除 成 功!");
        }
        return ServerResponse.createByErrorMsg("服 务 器 异 常,请 稍 后 再 试!");
    }

    @Override
    public Book getBookInfo(String bookisbn) {

        return bookMapper.selectByPrimaryKey(bookisbn);
    }

    @Override
    public ServerResponse update(Book book) {

        int result = bookMapper.updateByPrimaryKeySelective(book);
        if(result>0){
            return ServerResponse.createBySuccessMsg("修 改 成 功!");
        }
        return ServerResponse.createByErrorMsg(" 服 务 器 忙,请 稍 后 再 试! ");
    }

    @Override
    public PageInfo listForUser(Integer pageNum, Integer pageSize, String author, String bookName, String categoryid) {

        PageHelper.startPage(pageNum,pageSize);
        if(StringUtils.isNotBlank(author)) {
            author = new StringBuilder("%").append(author).append("%").toString();
        }

        if(StringUtils.isNotBlank(bookName)) {
            bookName = new StringBuilder("%").append(bookName).append("%").toString();
        }
        List<Book> bookList = bookMapper.selectByAuthorBookNameAndCategoryId(author,bookName,categoryid);
        //封装了详细的分页信息,
        PageInfo pageInfo = new PageInfo(bookList, BookShopConst.navigatePages);
        return pageInfo;

    }
}
