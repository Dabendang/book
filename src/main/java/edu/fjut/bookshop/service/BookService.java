package edu.fjut.bookshop.service;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.domain.Book;

/**
 * Created by dabendan on 2018/3/24.
 */
public interface BookService {
    PageInfo list(Integer pageNum, Integer pageSize, String bookName, String categoryid);

    ServerResponse save(Book book);

    ServerResponse delete(String bookIsbn);

    Book getBookInfo(String bookIsbn);

    ServerResponse update(Book book);

    PageInfo listForUser(Integer pageNum, Integer pageSize, String author, String bookName, String categoryid);
}
