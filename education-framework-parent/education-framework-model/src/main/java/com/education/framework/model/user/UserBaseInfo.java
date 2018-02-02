package com.education.framework.model.user;
/**
 * 
 * 用户基本信息
 * <p>UserBaseInfo.java</p>
 * <p>类的详细说明</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年2月2日 上午10:27:03
 * <p>修改者姓名 修改内容说明</p>
 */
public class UserBaseInfo {

	/**
	 * 主键ID
	 */
	private String id;
	/**
	 * 用户表主键
	 */
	private String userId;
	
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
	private String idNumber;
	  
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
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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
	
	
}
