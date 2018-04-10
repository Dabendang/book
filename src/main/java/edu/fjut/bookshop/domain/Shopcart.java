package edu.fjut.bookshop.domain;

import java.math.BigDecimal;

public class Shopcart {
    private Integer scid;

    private String username;

    private String bookname;

    private Integer booknum;

    private BigDecimal bookprice;

    private BigDecimal totalprice;

    public Shopcart(Integer scid, String username, String bookname, Integer booknum, BigDecimal bookprice, BigDecimal totalprice) {
        this.scid = scid;
        this.username = username;
        this.bookname = bookname;
        this.booknum = booknum;
        this.bookprice = bookprice;
        this.totalprice = totalprice;
    }

    public Shopcart() {
        super();
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
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

    public Integer getBooknum() {
        return booknum;
    }

    public void setBooknum(Integer booknum) {
        this.booknum = booknum;
    }

    public BigDecimal getBookprice() {
        return bookprice;
    }

    public void setBookprice(BigDecimal bookprice) {
        this.bookprice = bookprice;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }
}