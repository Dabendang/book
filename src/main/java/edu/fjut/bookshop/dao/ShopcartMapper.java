package edu.fjut.bookshop.dao;

import edu.fjut.bookshop.domain.Shopcart;
import edu.fjut.bookshop.domain.ShopcartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopcartMapper {
    int deleteByPrimaryKey(Integer scid);

    int insert(Shopcart record);

    int insertSelective(Shopcart record);

    List<Shopcart> selectByExample(ShopcartExample example);

    Shopcart selectByPrimaryKey(Integer scid);

    int updateByExampleSelective(@Param("record") Shopcart record, @Param("example") ShopcartExample example);

    int updateByExample(@Param("record") Shopcart record, @Param("example") ShopcartExample example);

    int updateByPrimaryKeySelective(Shopcart record);

    int updateByPrimaryKey(Shopcart record);

    List<Shopcart> selectEqualsToUsername(@Param("username")String username);

    Shopcart selectByBooknameAndUsename(@Param("bookname")String bookname,@Param("username")String username);

    Integer checkByBooknameAndUsename(@Param("bookname")String bookname,@Param("username")String username);
}