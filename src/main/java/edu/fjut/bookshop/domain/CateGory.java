package edu.fjut.bookshop.domain;

public class CateGory {
    private Integer categoryid;

    private String categoryname;

    private Long inventory;

    private Long salesvolume;

    public CateGory(Integer categoryid, String categoryname, Long inventory, Long salesvolume) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.inventory = inventory;
        this.salesvolume = salesvolume;
    }

    public CateGory() {
        super();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public Long getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(Long salesvolume) {
        this.salesvolume = salesvolume;
    }
}