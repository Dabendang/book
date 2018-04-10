package edu.fjut.bookshop.service;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.domain.CateGory;

import java.util.List;

/**
 * Created by qyw on 2017/6/21.
 */
public interface CategoryService {
    PageInfo getCategorys(Integer pageNum, Integer pageSize);

    ServerResponse update(CateGory cateGory);

    ServerResponse save(CateGory cateGory);

    ServerResponse delete(Integer categoryid);

    List<CateGory> getCategorysWithOutPage();
}
