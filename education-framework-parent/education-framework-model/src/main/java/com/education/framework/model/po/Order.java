package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Order extends ModelTemplet{

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 支付方式 1支付宝，2微信，3银行卡
     */
    private Integer payMode;

    /**
     * 订单金额
     */
    private Double payMoney;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 订单描述
     */
    private String orderDescr;

    /**
     * 地址
     */
    private String address;

    /**
     * 订单日期
     */
    private Integer orderTime;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 课程ID
     */
    private Integer teacherSubjectId;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDescr() {
        return orderDescr;
    }

    public void setOrderDescr(String orderDescr) {
        this.orderDescr = orderDescr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getTeacherSubjectId() {
        return teacherSubjectId;
    }

    public void setTeacherSubjectId(Integer teacherSubjectId) {
        this.teacherSubjectId = teacherSubjectId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", id=" + id +
                ", payMode=" + payMode +
                ", creatorId=" + creatorId +
                ", payMoney=" + payMoney +
                ", createTime=" + createTime +
                ", orderStatus=" + orderStatus +
                ", updaterId=" + updaterId +
                ", orderDescr='" + orderDescr + '\'' +
                ", updateTime=" + updateTime +
                ", address='" + address + '\'' +
                ", deleted=" + deleted +
                ", orderTime=" + orderTime +
                ", studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", teacherSubjectId=" + teacherSubjectId +
                '}';
    }

}
