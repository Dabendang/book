package edu.fjut.bookshop.dao;

import edu.fjut.bookshop.domain.Order;
import edu.fjut.bookshop.domain.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    String selectBookNameById (String orderid);

    String selectUserNameByID(String orderid);

    List<Order> selectLikeOrderidAndStatus(@Param("orderid")String orderid,@Param(value = "status") String status);

    List<Order> selectEqualsToUsername(@Param("username")String username);
}