package edu.fjut.bookshop.web.controller.backend;

import edu.fjut.bookshop.domain.Stock;
import edu.fjut.bookshop.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by qyw on 2017/6/21.
 */
@Controller
@RequestMapping("/admin/stock/")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(value = "getStockInfo")
    public String list(Map<String,Object> map){
        Stock stock=stockService.getStockInfo();
        map.put("stock",stock);
      return "StockInfo";
    }

}
