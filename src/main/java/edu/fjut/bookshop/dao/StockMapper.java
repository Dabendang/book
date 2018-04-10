package edu.fjut.bookshop.dao;

import edu.fjut.bookshop.domain.Stock;
import edu.fjut.bookshop.domain.StockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockMapper {
    int deleteByPrimaryKey(Integer stockid);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(Integer stockid);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);

    Integer  updateStockNumDec();

    Integer  updateStockNumINC();

    Integer  updateTotalCategoryINC();

    Integer  updateTotalCategoryDec();
}