package edu.fjut.bookshop.domain;

import java.util.Date;

/**
 * Created by dabendan on 2018/4/3.
 */
public class UsersInfo {

    private Integer normalNum;

    private Integer vipNum;

    private Integer manNum;

    private Integer womanNum;

    private Integer totalNum;

    public UsersInfo(Integer normalNum, Integer vipNum, Integer manNum,Integer womanNum,Integer totalNum ) {
        this.normalNum = normalNum;
        this.vipNum = vipNum;
        this.manNum = manNum;
        this.womanNum = womanNum;
        this.totalNum = totalNum;
    }

    public UsersInfo() {
        super();
    }

    public Integer getNormalNum() {
        return normalNum;
    }

    public void setNormalNum(Integer normalNum) {
        this.normalNum = normalNum;
    }

    public Integer getVipNum() {
        return vipNum;
    }

    public void setVipNum(Integer vipNum) {
        this.vipNum = vipNum;
    }

    public Integer getManNum() {
        return manNum;
    }

    public void setManNum(Integer manNum) {
        this.manNum = manNum;
    }

    public Integer getWomanNum() {
        return womanNum;
    }

    public void setWomanNum(Integer womanNum) {
        this.womanNum = womanNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}
