package edu.fjut.bookshop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

public class User {
    private String userid;

    @Length(min = 6,max = 16,message = "登 录 密 码 的 长 度 须 在 6 到 16 位 之 间!")
    private String logpassword;

    @Length(min = 6,max = 16,message = "支 付 密 码 的 长 度 须 在 6 到 16 位 之 间!")
    private String paypassword;

    @Length(min = 2,max = 10,message = "用 户 名 的 长 度 须 在 2 到 10 位 之 间!")
    private String username;


    private String sex;

    @NotBlank(message = "地址不能为空")
    private String liveplace;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private BigDecimal balance;

    private String status;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLogpassword() {
        return logpassword;
    }

    public void setLogpassword(String logpassword) {
        this.logpassword = logpassword;
    }

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLiveplace() {
        return liveplace;
    }

    public void setLiveplace(String liveplace) {
        this.liveplace = liveplace;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User(String userid, String logpassword, String paypassword, String username, String sex, String liveplace, Date createTime, Date updateTime, BigDecimal balance, String status) {
        this.userid = userid;
        this.logpassword = logpassword;
        this.paypassword = paypassword;
        this.username = username;
        this.sex = sex;
        this.liveplace = liveplace;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.balance = balance;
        this.status = status;
    }

    public User() {
    }
}