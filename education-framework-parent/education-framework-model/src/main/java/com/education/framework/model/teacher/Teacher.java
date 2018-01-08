package com.education.framework.model.teacher;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 
 * <p>Teacher.java</p>
 * <p>教师信息</p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午4:33:36
 * <p>修改者姓名 修改内容说明</p>
 */
public class Teacher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8250059160847833797L;
	/**
	 * 主键ID
	 */
	private String id;
	private String userId;
	/**
	 * 姓名
	 */
	private String teacherName;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 籍惯
	 */
	private String nativePlace;
	/**
	 * 所在省份
	 */
	private String province;
	/**
	 * 所在城市
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
	private String idNumber;
	/**
	 * 最高学历
	 */
	private String education;
	/**
	 * 所学专业
	 */
	private String major;
	/**
	 * 自我介绍
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
