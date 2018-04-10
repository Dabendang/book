package edu.fjut.bookshop.web.controller;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.domain.Book;
import edu.fjut.bookshop.domain.CateGory;
import edu.fjut.bookshop.service.BookService;
import edu.fjut.bookshop.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.ParseException;
import java.util.*;

/**
 * Created by qyw on 2017/6/21.
 */
@Controller
@RequestMapping("/admin/book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "books")
    public String list(Map<String,Object> map, @RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum, @RequestParam(value = "pageSize",defaultValue ="5") Integer pageSize,@RequestParam(value = "bookName",required = false) String bookName,@RequestParam(value = "categoryid",required = false)String categoryid ){
        List<CateGory> cateGories=categoryService.getCategorysWithOutPage();
        map.put("cateGories",cateGories);
        if(StringUtils.isNotBlank(bookName)){
            map.put("bookName",bookName);
        }
        if(StringUtils.isNotBlank(categoryid)){
            map.put("category_id",categoryid);
        }
        PageInfo pageInfo=bookService.list(pageNum,pageSize,bookName,categoryid);
        map.put("pageInfo",pageInfo);
      return "BookList";
    }

//    @PostMapping(value = "insertBook")
//    public String insert(Map<String,Object> map){
//        List<CateGory> cateGories=categoryService.getCategorysWithOutPage();
//        map.put("cateGories",cateGories);
//        map.put("Book",new Book());
//
//        return "BookInput";
//    }

    //go添加页面
    @GetMapping(value = "book")
    public String input(Map<String,Object> map){
        List<CateGory> cateGories=categoryService.getCategorysWithOutPage();
        map.put("cateGories",cateGories);
        map.put("Book",new Book());

        return "BookInput";
    }




    //更新或修改方法
    @PostMapping(value = "book")
    @ResponseBody
    public ServerResponse saveOrUpdate(HttpServletRequest request, Book book)throws Exception{
        //保存数据库的路径
        String sqlPath = null;
        //定义文件保存的本地路径
        String localPath="E:\\File\\";
        //定义 文件名
        String filename=null;
        if(!book.getFile().isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=book.getFile().getContentType();
            //获得文件后缀名
            String suffixName=contentType.substring(contentType.indexOf("/")+1);
            //得到 文件名
            filename=uuid+"."+suffixName;
            //文件保存路径
            book.getFile().transferTo(new File(localPath+filename));
        }
        //把图片的相对路径保存至数据库
        sqlPath = "/images/"+filename;
        book.setImg(sqlPath);
        if(!book.getBookisbn().equals("")){
            return bookService.update(book);
        }
        return bookService.save(book);
    }


    @GetMapping(value = "toDelete")
    @ResponseBody
    public ServerResponse delete(@RequestParam(value = "bookisbn",required = false) String bookisbn,Map<String,Object> map){
       return   bookService.delete(bookisbn);
    }

    //go修改页
    @GetMapping(value = "toEdit/{bookisbn}")
    public String ToInputForUpdate(@PathVariable("bookisbn") String bookisbn,Map<String,Object> map) throws ParseException {
        List<CateGory> cateGories=categoryService.getCategorysWithOutPage();
        map.put("cateGories",cateGories);
        Book book=bookService.getBookInfo(bookisbn);
        map.put("Book",book);

        return "BookInput";
    }










}
