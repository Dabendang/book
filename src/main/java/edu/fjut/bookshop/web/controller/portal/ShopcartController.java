package edu.fjut.bookshop.web.controller.portal;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.domain.Shopcart;
import edu.fjut.bookshop.domain.User;
import edu.fjut.bookshop.service.ShopcartService;
import edu.fjut.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by dabendan on 2018/4/5.
 */

@Controller
@RequestMapping("/portal/shopcart/")
public class ShopcartController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShopcartService shopcartService;

    @GetMapping(value = "getUserShopcartInfo")
    public String getUserOrderInfo(Map<String,Object> map, @RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum, @RequestParam(value = "pageSize",defaultValue ="5") Integer pageSize, HttpSession session){

        User user= (User) session.getAttribute(BookShopConst.CURRENT_USER);
        PageInfo pageInfo=userService.getUserShopcart(pageNum,pageSize,user.getUserid());
        map.put("pageInfo",pageInfo);

        return "User_Shopcart";

    }

    @GetMapping(value = "deleteShopcartInfo")
    public String deleteShopcartInfo(Map<String,Object> map, @RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum, @RequestParam(value = "pageSize",defaultValue ="5") Integer pageSize, @RequestParam(required = false) Integer scid){

         shopcartService.deleteShopcart(scid);

        return "redirect:getUserShopcartInfo";
    }

    //回显
    @GetMapping(value = "toSettle")
    public String toSettle(Map<String,Object> map,HttpSession session, @RequestParam(value = "scid")Integer scid, @RequestParam(value = "booknum",defaultValue ="1") Integer booknum){

        Shopcart shopcart=shopcartService.getShopcartByScid(scid);
        if(booknum != shopcart.getBooknum())
            shopcart=shopcartService.getNewShopcartByBooknum(shopcart,booknum);
        map.put("Shopcart",shopcart);
        return "User_UpdateInfo";
    }

    @GetMapping(value = "addShopcart")
    @ResponseBody
    public ServerResponse addShopcart(HttpSession session,@RequestParam(value = "bookname")String bookname){

        User user = (User)session.getAttribute(BookShopConst.CURRENT_USER);

        return shopcartService.saveByUsernameAndBookname(user.getUsername(),bookname);
    }
}
