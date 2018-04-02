package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Wallet extends ModelTemplet{

    /**
     * 总金额
     */
    private Double amountMoney;

    /**
     * 允许提现余额
     */
    private Double allowBalance;

    /**
     * 不允许提现金额
     */
    private Double noAllowBalance;

    /**
     * 最后交易时间
     */
    private Date lastTransactionTime;

    /**
     * 最后交易金额
     */
    private Double lastTransactionMoney;

    public Double getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(Double amountMoney) {
        this.amountMoney = amountMoney;
    }

    public Double getAllowBalance() {
        return allowBalance;
    }

    public void setAllowBalance(Double allowBalance) {
        this.allowBalance = allowBalance;
    }

    public Double getNoAllowBalance() {
        return noAllowBalance;
    }

    public void setNoAllowBalance(Double noAllowBalance) {
        this.noAllowBalance = noAllowBalance;
    }

    public Date getLastTransactionTime() {
        return lastTransactionTime;
    }

    public void setLastTransactionTime(Date lastTransactionTime) {
        this.lastTransactionTime = lastTransactionTime;
    }

    public Double getLastTransactionMoney() {
        return lastTransactionMoney;
    }

    public void setLastTransactionMoney(Double lastTransactionMoney) {
        this.lastTransactionMoney = lastTransactionMoney;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "amountMoney=" + amountMoney +
                ", id=" + id +
                ", creatorId=" + creatorId +
                ", allowBalance=" + allowBalance +
                ", createTime=" + createTime +
                ", noAllowBalance=" + noAllowBalance +
                ", updaterId=" + updaterId +
                ", lastTransactionTime=" + lastTransactionTime +
                ", updateTime=" + updateTime +
                ", lastTransactionMoney=" + lastTransactionMoney +
                ", deleted=" + deleted +
                '}';
    }
}
