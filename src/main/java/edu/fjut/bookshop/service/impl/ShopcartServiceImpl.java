package edu.fjut.bookshop.service.impl;


import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.dao.BookMapper;
import edu.fjut.bookshop.dao.ShopcartMapper;
import edu.fjut.bookshop.domain.Shopcart;
import edu.fjut.bookshop.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by dabendan on 2018/4/5.
 */
@Service
public class ShopcartServiceImpl implements ShopcartService {

    @Autowired
    private ShopcartMapper shopcartMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void deleteShopcart(Integer scid) {

        Integer result=shopcartMapper.deleteByPrimaryKey(scid);
    }

    @Override
    public Shopcart getShopcartByScid(Integer scid) {
        return shopcartMapper.selectByPrimaryKey(scid);
    }

    @Override
    public Shopcart getNewShopcartByBooknum(Shopcart shopcart, Integer newBooknum) {

        String bookname=shopcart.getBookname();
        BigDecimal price=bookMapper.selectPriceByBookName(bookname);
        BigDecimal totalPrice=price.multiply(new BigDecimal(newBooknum));
        shopcart.setTotalprice(totalPrice);

        return shopcart;
    }

    @Override
    public ServerResponse saveByUsernameAndBookname(String username,String bookname) {

        int k=0;
        Shopcart shopcart=new Shopcart();
        Integer result=shopcartMapper.checkByBooknameAndUsename(bookname,username);
        BigDecimal bookPrice=bookMapper.selectPriceByBookName(bookname);

        if(result>0){
            shopcart =shopcartMapper.selectByBooknameAndUsename(bookname,username);
            shopcart.setBooknum(shopcart.getBooknum()+1);
            shopcart.setTotalprice(shopcart.getTotalprice().add(bookPrice));
            k=shopcartMapper.updateByPrimaryKeySelective(shopcart);

        }else {

            shopcart.setBookname(bookname);
            shopcart.setUsername(username);
            shopcart.setBooknum(1);
            shopcart.setBookprice(bookPrice);
            shopcart.setTotalprice(bookPrice);
            k = shopcartMapper.insert(shopcart);

        }

        if(k>0){
            return ServerResponse.createBySuccessMsg("加入购物车成功");
        }

        return ServerResponse.createByErrorMsg("服 务 器 忙,请 稍 后 再 试!");
    }
}
