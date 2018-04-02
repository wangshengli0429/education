package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class OrderAppointment extends ModelTemplet{

    /**
     * 订单主键
     */
    private Integer orderId;

    /**
     * 预约开始时间
     */
    private Date beginTime;

    /**
     * 预约截止时间
     */
    private Date endTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "OrderAppointment{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", creatorId=" + creatorId +
                ", beginTime=" + beginTime +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
