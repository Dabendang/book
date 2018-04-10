package edu.fjut.bookshop.web.controller.backend;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.common.ViewConst;
import edu.fjut.bookshop.domain.Admin;
import edu.fjut.bookshop.domain.Stock;
import edu.fjut.bookshop.domain.UsersInfo;
import edu.fjut.bookshop.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qyw on 2017/6/21.
 */
@Controller
@RequestMapping(value = "/backend/admin/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "login")
    @ResponseBody
    public ServerResponse<Admin> login(String username, String password,HttpSession session){

        ServerResponse<Admin> response = adminService.login(username, password);
        if(response.isSuccess()){
            session.setAttribute(BookShopConst.CURRENT_ADMIN,response.getData());
            session.removeAttribute(BookShopConst.CURRENT_USER);
        }

        return response;
    }

    @GetMapping(value = "index")
    public String index(){

      return ViewConst.ADMIN_MAIN;
    }

    @GetMapping(value = "logout")
    public String logout(HttpSession session){
        session.removeAttribute(BookShopConst.CURRENT_ADMIN);
        return "redirect:/admin";
    }

    @GetMapping(value = "getUsersInfo")
    public String getUsersInfo(Map<String,Object> map){

        UsersInfo usersInfo=adminService.getUsersInfo();
        map.put("UsersInfo",usersInfo);
      return "UsersTotalInfo";
    }

    @GetMapping(value = "getAllUserInfo")
    public String getAllUser(Map<String,Object> map, @RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum, @RequestParam(value = "pageSize",defaultValue ="5") Integer pageSize, @RequestParam(value = "username",required = false) String username, @RequestParam(value = "status",required = false)String status){

        Map<String,Object> statusMap = new HashMap();
        statusMap.put(BookShopConst.UserStatus.NORMAL,"普 通 用 户");
        statusMap.put(BookShopConst.UserStatus.VIP,"会 员");
        map.put("statusMap",statusMap);
        if(StringUtils.isNotBlank(username)){
            map.put("username",username);
        }
        if(StringUtils.isNotBlank(status)){
            map.put("status",status);
        }
        PageInfo pageInfo=adminService.getAllUser(pageNum,pageSize,username,status);
        map.put("pageInfo",pageInfo);
        return "User_List";
    }

    @GetMapping(value = "recharge")
    @ResponseBody
    public ServerResponse doRecharge(String username,String payPassword,BigDecimal money){
        return adminService.doRecharge(username,payPassword,money);
    }

    @GetMapping(value = "toRecharge")
    public String ToRecharge(){

        return "admin_RechargeUser";
    }

    @GetMapping(value = "delete")
    @ResponseBody
    public ServerResponse deleteUser(@RequestParam(required = false) String userid){

        return adminService.deleteUser(userid);
    }

    @GetMapping(value = "toNormal")
    @ResponseBody
    public ServerResponse toNormal(@RequestParam(required = false) String userid){

        return adminService.normalUser(userid);
    }

    @GetMapping(value = "toVip")
    @ResponseBody
    public ServerResponse toVip(@RequestParam(required = false) String userid){

        return adminService.vipUser(userid);
    }


}
