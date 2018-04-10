package edu.fjut.bookshop.domain;

public class Stock {
    private Integer stockid;

    private Long stocknum;

    private Integer totalcategory;

    public Stock(Integer stockid, Long stocknum, Integer totalcategory) {
        this.stockid = stockid;
        this.stocknum = stocknum;
        this.totalcategory = totalcategory;
    }

    public Stock() {
        super();
    }

    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public Long getStocknum() {
        return stocknum;
    }

    public void setStocknum(Long stocknum) {
        this.stocknum = stocknum;
    }

    public Integer getTotalcategory() {
        return totalcategory;
    }

    public void setTotalcategory(Integer totalcategory) {
        this.totalcategory = totalcategory;
    }
}