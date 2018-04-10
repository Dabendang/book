package edu.fjut.bookshop.service;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.domain.Order;


/**
 * Created by dabendan on 2018/3/24.
 */
public interface OrderService {

    PageInfo getCurOrderHistory(String userid, Integer pageNum, Integer pageSize);

    void update(Order order);

    Order getOrderInfo(String orderid);

}
