package edu.fjut.bookshop.web.controller.portal;

import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.domain.Book;
import edu.fjut.bookshop.domain.Shopcart;
import edu.fjut.bookshop.domain.User;
import edu.fjut.bookshop.service.BookService;
import edu.fjut.bookshop.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by dabendan on 2018/4/8.
 */
@Controller
@RequestMapping("/user/book/")
public class UserBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ShopcartService shopcartService;

    //go添加页面
    @GetMapping(value = "showBookInfo")
    public String showBookInfo(Map<String,Object> map,@RequestParam(value = "bookisbn")String bookisbn){

        Book book=bookService.getBookInfo(bookisbn);
        map.put("Book",book);

        return "BookInfo";
    }

}
