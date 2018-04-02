package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class TradeRecord extends ModelTemplet{

    /**
     * 流水号
     */
    private String serialNumber;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 交易金额
     */
    private Double amountMoney;

    /**
     * 描述
     */
    private String descr;

    /**
     * 交易时间
     */
    private Date amountTime;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 来源 :  1订单，2充值，3提现
     */
    private Integer datasource;

    /**
     * 状态 1有效，0无效
     */
    private Integer status;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(Double amountMoney) {
        this.amountMoney = amountMoney;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getAmountTime() {
        return amountTime;
    }

    public void setAmountTime(Date amountTime) {
        this.amountTime = amountTime;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getDatasource() {
        return datasource;
    }

    public void setDatasource(Integer datasource) {
        this.datasource = datasource;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TradeRecord{" +
                "serialNumber='" + serialNumber + '\'' +
                ", id=" + id +
                ", creatorId=" + creatorId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", amountMoney=" + amountMoney +
                ", descr='" + descr + '\'' +
                ", updaterId=" + updaterId +
                ", amountTime=" + amountTime +
                ", updateTime=" + updateTime +
                ", orderNumber='" + orderNumber + '\'' +
                ", deleted=" + deleted +
                ", datasource=" + datasource +
                ", status=" + status +
                '}';
    }
}
