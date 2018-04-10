package edu.fjut.bookshop.web.controller.portal;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.common.ServerCode;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.common.ViewConst;
import edu.fjut.bookshop.domain.CateGory;
import edu.fjut.bookshop.domain.Order;
import edu.fjut.bookshop.domain.User;
import edu.fjut.bookshop.service.BookService;
import edu.fjut.bookshop.service.CategoryService;
import edu.fjut.bookshop.service.OrderService;
import edu.fjut.bookshop.service.UserService;
import edu.fjut.bookshop.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qyw on 2017/6/21.
 */
@Controller
@RequestMapping("/portal/user/")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;


    @PostMapping(value = "login")
    @ResponseBody
    public ServerResponse<User> login(@RequestParam(value = "logUsername",required = true) String username, @RequestParam(value = "userPassword",required = true)String logpassword, HttpSession session){

        ServerResponse<User> response = userService.login(username, logpassword);
        if(response.isSuccess()){
            session.setAttribute(BookShopConst.CURRENT_USER,response.getData());
            session.removeAttribute(BookShopConst.CURRENT_ADMIN);
        }
        return response;
    }

    @GetMapping(value = "index")
    public String index(){

        return ViewConst.READER_MAIN;
    }

    @PostMapping(value = "register")
    @ResponseBody
    public ServerResponse<Map> register(@Valid User user, BindingResult result){


        if(result.hasErrors()){
            Map<String,Object> errorFields=new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError:fieldErrors) {
                errorFields.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ServerResponse.createByErrorCodeMsgDate(ServerCode.ILLEGAL_ARGUMENTS.getCode(),"格式不正确",errorFields);
        }
        return userService.register(user);
    }

    @PostMapping(value = "checkUsername")
    @ResponseBody
    public Boolean checkUsername( @RequestParam(value = "username",required = false)String username){
        return userService.checkUsername(username);
    }


    @GetMapping(value = "logout")
    public String logout(HttpSession session){
        session.removeAttribute(BookShopConst.CURRENT_USER);
        return "redirect:/";
    }

    @GetMapping(value = "getUserOrderInfo")
    public String getUserOrderInfo(Map<String,Object> map, @RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum, @RequestParam(value = "pageSize",defaultValue ="5") Integer pageSize,HttpSession session){

            User user= (User) session.getAttribute(BookShopConst.CURRENT_USER);
            PageInfo pageInfo=userService.getUserOrder(pageNum,pageSize,user.getUserid());
            map.put("pageInfo",pageInfo);

            return "User_OrderInfo";

    }

    @GetMapping(value = "getUserInfo")
    public String getUserInfo(Map<String,Object> map,HttpSession session){
        User user= (User) session.getAttribute(BookShopConst.CURRENT_USER);
        User userInfo = userService.getUserInfo(user.getUserid());
        map.put("User",userInfo);
        return "UserInfo";
    }

    //回显
    @GetMapping(value = "toEdit")
    public String edit(Map<String,Object> map,HttpSession session){

        User user = (User) session.getAttribute(BookShopConst.CURRENT_USER);
        map.put("User",user);
        return "User_UpdateInfo";
    }

    //修改密码
    @GetMapping(value = "toEditPassword")
    public String editPassword(Map<String,Object> map,HttpSession session){

        User user = (User) session.getAttribute(BookShopConst.CURRENT_USER);
        map.put("User",user);
        return "User_UpdatePass";
    }



    //更新基本信息
    @PostMapping(value = "update")
    public String update(User user){
        userService.update(user);
        return "redirect:getUserInfo";
    }

    //更新密码
    @PostMapping(value = "updatePass")
    public String updatePass(@Valid User user, BindingResult result){


//        if(result.hasErrors()){
//            Map<String,Object> errorFields=new HashMap<>();
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            for (FieldError fieldError:fieldErrors) {
//                errorFields.put(fieldError.getField(),fieldError.getDefaultMessage());
//            }
//            return ServerResponse.createByErrorCodeMsgDate(ServerCode.ILLEGAL_ARGUMENTS.getCode(),"格式不正确",errorFields);
//        }

        user.setLogpassword(MD5Util.MD5EncodeUtf8(user.getLogpassword()));
        user.setPaypassword(MD5Util.MD5EncodeUtf8(user.getPaypassword()));
        userService.update(user);
        return "redirect:getUserInfo";
    }


    @GetMapping(value = "getBookInfo")
    public String list(Map<String,Object> map, @RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum, @RequestParam(value = "pageSize",defaultValue ="5") Integer pageSize,@RequestParam(value = "author",required = false) String author,@RequestParam(value = "bookName",required = false) String bookName,@RequestParam(value = "categoryid",required = false)String categoryid ){
        List<CateGory> cateGories;
        cateGories = categoryService.getCategorysWithOutPage();
        map.put("cateGories",cateGories);
        if(StringUtils.isNotBlank(author)){
            map.put("author",author);
        }
        if(StringUtils.isNotBlank(bookName)){
            map.put("bookName",bookName);
        }
        if(StringUtils.isNotBlank(categoryid)){
            map.put("category_id",categoryid);
        }
        PageInfo pageInfo=bookService.listForUser(pageNum,pageSize,author,bookName,categoryid);
        map.put("pageInfo",pageInfo);
        return "User_BookList";
    }

    //取消未支付订单
    @GetMapping(value = "passOrder")
    public String passOrder(@RequestParam(value = "orderid",required = false) String orderid){

        Order order= orderService.getOrderInfo(orderid);
        order.setStatus(2);
        orderService.update(order);
        return "redirect:getUserOrderInfo";
    }

    //取消已支付订单
    @GetMapping(value = "passOrderPayed")
    public String passOrderPayed(@RequestParam(value = "orderid",required = false) String orderid,HttpSession session){

        User user = (User) session.getAttribute(BookShopConst.CURRENT_USER);
        Order order= orderService.getOrderInfo(orderid);
        userService.updateBalanceADD(user.getUserid(),order.getBuyprice());
        order.setStatus(2);
        orderService.update(order);

        return "redirect:getUserOrderInfo";
    }

}
