package edu.fjut.bookshop.service.impl;

import edu.fjut.bookshop.dao.StockMapper;
import edu.fjut.bookshop.domain.Stock;
import edu.fjut.bookshop.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dabendan on 2018/3/24.
 */
@Service
public class StockServiceImpl  implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public Stock getStockInfo() {

        Stock stock = stockMapper.selectByPrimaryKey(  1);
        return stock;
    }
}
