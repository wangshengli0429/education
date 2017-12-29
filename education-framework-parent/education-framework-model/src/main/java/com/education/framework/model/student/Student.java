package com.education.framework.model.student;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1563097217235386854L;
	
	private String id;
	/**
	 * 用户表主键
	 */
	private String userId;
	/**
	 * 学生姓名
	 */
	private String student;
	/**
	 * 学生性别：M:男  W：女
	 */
	private String gender;
	
	private Integer age;
	/**
	 * 籍惯
	 */
	private String nativePlace;
	/**
	 * 所在省份
	 */
	private String province;
	/**
	 * 所在市
	 */
	private String city;
	/**
	 * 所在区县
	 */
	private String district;
	/**
	 * 现在住址
	 */
	private String address;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 简介
	 */
	private String selfDescr;
	/**
	 * 头像
	 */
	private String photo;
	/**
	 * 备注
	 */
	private String remark;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getSelfDescr() {
		return selfDescr;
	}
	public void setSelfDescr(String selfDescr) {
		this.selfDescr = selfDescr;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	 
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
