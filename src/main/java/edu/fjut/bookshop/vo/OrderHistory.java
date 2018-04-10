package edu.fjut.bookshop.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/27.
 */
@Getter
@Setter
public class OrderHistory {

    private String orderid;

    private String username;

    private String bookname;

    private Date buyTime;

}
