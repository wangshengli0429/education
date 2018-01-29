package com.education.framework.model.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5469148884677320245L;
	private String id;
	private String userName;
	private String userPwd;
	private Date regTime;
	private Date lastTime;
	private String lastIp;
	/**
	 * 类型（T:教师，S:学生）
	 */
	private String userType;
	/**
	 * 状态 D删除，F冻结，N正常
	 */
	private String status;
	/**
	 * 认证状态  Y:通过，N:未通过
	 */
	private String cerStatus;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCerStatus() {
		return cerStatus;
	}
	public void setCerStatus(String cerStatus) {
		this.cerStatus = cerStatus;
	}
	
	
}
