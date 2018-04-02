package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class BindAccount extends ModelTemplet{

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 姓名
     */
    private String personName;

    /**
     * 帐户
     */
    private String accountName;

    /**
     * 户类型:1支付宝，2微信，3银行卡
     */
    private Integer accountType;

    /**
     * 绑定时间
     */
    private Date bingTime;

    /**
     * 解绑时间
     */
    private Date unbingTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Date getBingTime() {
        return bingTime;
    }

    public void setBingTime(Date bingTime) {
        this.bingTime = bingTime;
    }

    public Date getUnbingTime() {
        return unbingTime;
    }

    public void setUnbingTime(Date unbingTime) {
        this.unbingTime = unbingTime;
    }

    @Override
    public String toString() {
        return "BindAccount{" +
                "id=" + id +
                ", userId=" + userId +
                ", creatorId=" + creatorId +
                ", personName='" + personName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", createTime=" + createTime +
                ", updaterId=" + updaterId +
                ", accountType=" + accountType +
                ", updateTime=" + updateTime +
                ", bingTime=" + bingTime +
                ", unbingTime=" + unbingTime +
                ", deleted=" + deleted +
                '}';
    }
}
