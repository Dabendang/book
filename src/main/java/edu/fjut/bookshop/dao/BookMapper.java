package edu.fjut.bookshop.dao;

import edu.fjut.bookshop.domain.Book;
import edu.fjut.bookshop.domain.BookExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    int deleteByPrimaryKey(String bookisbn);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(String bookisbn);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    BigDecimal selectPriceByBookIsbn(String bookisbn);

    BigDecimal selectPriceByBookName(String bookname);

    Integer selectStockNumByBookIsbn(String bookisbn);

    Integer selectCategoryIdByBookIsbn(String bookisbn);

    List<Book> selectByBookNameAndCategoryId(@Param("bookName") String bookName, @Param("categoryid") String categoryid);

    Integer checkCategoryId(Integer categoryid);

    List<Book> selectByAuthorBookNameAndCategoryId(@Param("author") String author,@Param("bookName") String bookName, @Param("categoryid") String categoryid);

    Integer updateStockNumDecByBookIsbn(String bookisbn);

    String selectBookNameByBookIsbn(String bookisbn);

    Integer updateStockNumINCByBookIsbn(String bookisbn);
}