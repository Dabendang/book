package edu.fjut.bookshop.service;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.dao.ShopcartMapper;
import edu.fjut.bookshop.domain.Shopcart;

import java.util.List;

/**
 * Created by dabendan on 2018/4/5.
 */
public interface ShopcartService {

    void deleteShopcart(Integer scid);

    Shopcart getShopcartByScid(Integer scid)

    Shopcart getNewShopcartByBooknum(Shopcart shopcart,Integer newBooknum);

    ServerResponse saveByUsernameAndBookname(String username,String bookname);

}
