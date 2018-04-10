package edu.fjut.bookshop.web.controller;

import edu.fjut.bookshop.common.ViewConst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qyw on 2017/6/21.
 */
@Controller
public class IndexController {


    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.HEAD})
    public String index(){


        return ViewConst.LOGIN;
    }

    @RequestMapping(value = "/admin",method = {RequestMethod.GET,RequestMethod.HEAD})
    public String ToAdmin(){

        return ViewConst.ADMIN_LOGIN;
    }



}
