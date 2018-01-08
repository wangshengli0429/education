package com.education.framework.model.teacher;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 
 * <p>TeacherCertificate.java</p>
 * <p>教师相关证书</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午4:53:40
 * <p>修改者姓名 修改内容说明</p>
 */
public class TeacherCertificate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1694616289148721845L;

	private String id;
	private String userId;
	/**
	 * 证书类型
	 */
	private String certificateType;
	/**
	 * 证书图片
	 */
	private Date certificateRegDate;
	/**
	 * 描述
	 */
	private String descr;
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
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	 
	
	public Date getCertificateRegDate() {
		return certificateRegDate;
	}
	public void setCertificateRegDate(Date certificateRegDate) {
		this.certificateRegDate = certificateRegDate;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
