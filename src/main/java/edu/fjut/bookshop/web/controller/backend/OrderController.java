package edu.fjut.bookshop.web.controller.backend;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.domain.Order;
import edu.fjut.bookshop.service.AdminService;
import edu.fjut.bookshop.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dabendan on 2018/4/4.
 */
@Controller
@RequestMapping("/admin/order/")
public class OrderController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "getAllOrderInfo")
    public String getAllOrderInfo(Map<String,Object> map, @RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum, @RequestParam(value = "pageSize",defaultValue ="5") Integer pageSize, @RequestParam(value = "orderid",required = false) String orderid, @RequestParam(value = "status",required = false)String status){

        Map<String,Object> statusMap = new HashMap();
        statusMap.put(BookShopConst.OrderStatus.NOTPAY,"未 支 付");
        statusMap.put(BookShopConst.OrderStatus.PAYED,"已 支 付");
        statusMap.put(BookShopConst.OrderStatus.PASS,"已 取 消");
        statusMap.put(BookShopConst.OrderStatus.SENDED,"已 发 货");
        statusMap.put(BookShopConst.OrderStatus.GETED,"已 收 货");
        map.put("statusMap",statusMap);
        if(StringUtils.isNotBlank(orderid)){
            map.put("orderid",orderid);
        }
        if(StringUtils.isNotBlank(status)){
            map.put("status",status);
        }
        PageInfo pageInfo=adminService.getAllOrder(pageNum,pageSize,orderid,status);
        map.put("pageInfo",pageInfo);

        return "Order_List";
    }

    //回显
    @GetMapping(value = "toEdit")
    public String edit(Map<String,Object> map,@RequestParam(value = "orderid",required = false) String orderid){

        Order order = orderService.getOrderInfo(orderid);
        map.put("Order",order);
        return "Order_Update";
    }


    //更新订单基本信息
    @PostMapping(value = "update")
    public String update(Order order){
        orderService.update(order);
        return "redirect:getAllOrderInfo";
    }

}
