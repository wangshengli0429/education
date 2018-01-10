package com.education.framework.model.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2617261527358774194L;
	
	private String id;
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 支付账号
	 */
	private String payAccount;
	/**
	 * 支付状态
	 */
	private String payStatus;
	/**
	 * 支付方式
	 */
	private String payMode;
	/**
	 * 订单金额
	 */
	private BigDecimal payMoney;
	/**
	 * 订单状态
	 */
	private String orderStatus;
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
	private Date orderTime;

	/**
	 * 学生ID
	 */
	private String studentId;
	/**
	 * 教师ID
	 */
	private String teacherId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public BigDecimal getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
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
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
