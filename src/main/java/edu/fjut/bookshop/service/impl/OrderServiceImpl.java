package edu.fjut.bookshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.dao.BookMapper;
import edu.fjut.bookshop.dao.OrderMapper;
import edu.fjut.bookshop.dao.UserMapper;
import edu.fjut.bookshop.domain.Order;
import edu.fjut.bookshop.domain.OrderExample;
import edu.fjut.bookshop.service.OrderService;
import edu.fjut.bookshop.vo.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dabendan on 2018/3/25.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageInfo getCurOrderHistory(String username, Integer pageNum, Integer pageSize) {

        String userName=userMapper.selectUserNameByUserId(username);

        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUsernameEqualTo(username);
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        PageInfo pageInfo = new PageInfo(orderList);

        List<OrderHistory> orderHistoryList=new ArrayList<>();
        for (Order orderItem:orderList){
            OrderHistory orderHistory = this.assembleOrderHistory(orderItem, userName);
            orderHistoryList.add(orderHistory);
        }
        pageInfo.setList(orderHistoryList);
        return pageInfo;
    }

    @Override
    public void update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order getOrderInfo(String orderid) {
        return orderMapper.selectByPrimaryKey(orderid);
    }


    private OrderHistory assembleOrderHistory(Order order, String userName){
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderid(order.getOrderid());
        orderHistory.setUsername(userName);
        String bookname = order.getBookname();
        orderHistory.setBookname(bookname);
        orderHistory.setBuyTime(order.getBuydata());
        return orderHistory;
    }

}
