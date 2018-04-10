package edu.fjut.bookshop.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String orderid;

    private String username;

    private String bookname;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date buydata;

    private Integer buynumber;

    private BigDecimal buyprice;

    private String buyaddress;

    private Integer status;

    public Order(String orderid, String username, String bookname, Date buydata, Integer buynumber, BigDecimal buyprice, String buyaddress, Integer status) {
        this.orderid = orderid;
        this.username = username;
        this.bookname = bookname;
        this.buydata = buydata;
        this.buynumber = buynumber;
        this.buyprice = buyprice;
        this.buyaddress = buyaddress;
        this.status = status;
    }

    public Order() {
        super();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Date getBuydata() {
        return buydata;
    }

    public void setBuydata(Date buydata) {
        this.buydata = buydata;
    }

    public Integer getBuynumber() {
        return buynumber;
    }

    public void setBuynumber(Integer buynumber) {
        this.buynumber = buynumber;
    }

    public BigDecimal getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(BigDecimal buyprice) {
        this.buyprice = buyprice;
    }

    public String getBuyaddress() {
        return buyaddress;
    }

    public void setBuyaddress(String buyaddress) {
        this.buyaddress = buyaddress == null ? null : buyaddress.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}