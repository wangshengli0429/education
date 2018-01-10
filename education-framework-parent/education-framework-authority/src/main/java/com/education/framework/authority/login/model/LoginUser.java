package com.education.framework.authority.login.model;

import java.util.Date;
import java.util.List;

import com.education.framework.authority.management.model.Management;

public class LoginUser {

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
	
	   /** 用户角色 */
    private List<String> roleList;
	
	public LoginUser(Management managemet, List<String> roleList) {
        this.manageCode = managemet.getManageCode();
        this.managePwd = managemet.getManagePwd();
        this.remark = managemet.getRemark();
        this.creator = managemet.getCreator();
        this.createTime = managemet.getCreateTime();
        this.lastLoginIp = managemet.getLastLoginIp();
        this.lastLoginTime = managemet.getLastLoginTime();
        this.roleList = roleList;
    }
	  @Override
	    public String toString() {
	        return "LoginUser [manageCode=" + manageCode + ", remark=" + remark + ", creator=" + creator + ", createTime="
	                + createTime + ", lastLoginIp=" + lastLoginIp + ", roleList=" + roleList + ", lastLoginTime=" + lastLoginTime + "]";
	    }
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
	
    public LoginUser() {
    
    }

    

  
  

}
