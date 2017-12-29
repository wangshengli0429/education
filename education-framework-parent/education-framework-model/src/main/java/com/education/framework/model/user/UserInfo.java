package com.education.framework.model.user;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -963684835880319832L;
	private Integer id;
	private String userId;
	private String pwd;
	 
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
