package com.education.framework.authority.management.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;
/**
 * 
 * <p>Management.java</p>
 * <p>后台管理用户表</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月10日 上午10:57:18
 * <p>修改者姓名 修改内容说明</p>
 */
public class Management implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1546285000951495152L;
	/**
	 * 用户名
	 */
	private String manageCode;
	/**
	 * 密码
	 */
	private String managePwd;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 最后登录IP
	 */
	private String lastLoginIp;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	/**
	 * 状态
	 */
	private String status;
	public String getManageCode() {
		return manageCode;
	}
	public void setManageCode(String manageCode) {
		this.manageCode = manageCode;
	}
	public String getManagePwd() {
		return managePwd;
	}
	public void setManagePwd(String managePwd) {
		this.managePwd = managePwd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
