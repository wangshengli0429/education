package com.education.framework.authority.role.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
/**
 * 
 * <p>ManagementRole.java</p>
 * <p>管理员And角色</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月10日 下午4:22:04
 * <p>修改者姓名 修改内容说明</p>
 */
public class ManagementRole implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 用户名 */	
	private String manageCode;
	/** 角色编码 */
	private String roleCode;
	 /** 备注  */
	private String remark;
	public String getManageCode() {
		return manageCode;
	}
	public void setManageCode(String manageCode) {
		this.manageCode = manageCode;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
