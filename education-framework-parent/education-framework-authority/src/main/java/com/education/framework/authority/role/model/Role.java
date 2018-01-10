package com.education.framework.authority.role.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 角色
 */

public class Role implements Serializable {

    /***/
    private static final long serialVersionUID = 1L;
    /** 角色ID */
    private String roleCode;
    /** 用户角色名称 */
    private String roleDescr;
    
    /** 创建或注册时间 */
    private Date createTime;
  
    /** 备注 */
    private String remark;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDescr() {
		return roleDescr;
	}

	public void setRoleDescr(String roleDescr) {
		this.roleDescr = roleDescr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
