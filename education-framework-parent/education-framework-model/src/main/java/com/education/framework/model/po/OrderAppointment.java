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

    private Integer teacherTimeId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTeacherTimeId() {
        return teacherTimeId;
    }

    public void setTeacherTimeId(Integer teacherTimeId) {
        this.teacherTimeId = teacherTimeId;
    }


    @Override
    public String toString() {
        return "OrderAppointment{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                "} " + super.toString();
    }
}
