package edu.fjut.bookshop.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private String bookisbn;

    private String bookname;

    private String author;

    private String publisher;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date pubilshdata;

    private BigDecimal price;

    private Integer stocknum;

    private Integer categoryid;

    private String description;

    private String img;

    private MultipartFile file;

    public Book(String bookisbn, String bookname, String author, String publisher, Date pubilshdata, BigDecimal price, Integer stocknum, Integer categoryid, String description, String img) {
        this.bookisbn = bookisbn;
        this.bookname = bookname;
        this.author = author;
        this.publisher = publisher;
        this.pubilshdata = pubilshdata;
        this.price = price;
        this.stocknum = stocknum;
        this.categoryid = categoryid;
        this.description = description;
        this.img = img;
    }

    public Book() {
        super();
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getBookisbn() {
        return bookisbn;
    }

    public void setBookisbn(String bookisbn) {
        this.bookisbn = bookisbn == null ? null : bookisbn.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getPubilshdata() {
        return pubilshdata;
    }

    public void setPubilshdata(Date pubilshdata) {
        this.pubilshdata = pubilshdata;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStocknum() {
        return stocknum;
    }

    public void setStocknum(Integer stocknum) {
        this.stocknum = stocknum;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}