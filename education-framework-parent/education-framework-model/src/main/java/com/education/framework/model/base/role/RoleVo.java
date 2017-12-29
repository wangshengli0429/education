package com.education.framework.model.base.role;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 */

public class RoleVo implements Serializable {

    /***/
    private static final long serialVersionUID = 1L;
    /** 角色ID */
    private Integer roleId;
    /** 用户角色英文对应名称 */
    private String roleNameEn;
    /** 用户角色中文对应名称 */
    private String roleNameCn;
    /** 创建或注册时间 */
    private Date createTime;
    /** 创建或注册人 */
    private Integer operator;
    private String userName;
    private String userId;
    /** 状态标志(0:无效，1:有效) */
    private String flag;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleNameEn() {
        return roleNameEn;
    }

    public void setRoleNameEn(String roleNameEn) {
        this.roleNameEn = roleNameEn;
    }

    public String getRoleNameCn() {
        return roleNameCn;
    }

    public void setRoleNameCn(String roleNameCn) {
        this.roleNameCn = roleNameCn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
    public String toString() {
        return "Role [roleId=" + roleId + ", roleNameEn=" + roleNameEn + ", roleNameCn=" + roleNameCn + ", createTime="
                + createTime + ", userId=" + userId + ", userName=" + userName + ", operator=" + operator + ", flag=" + flag + "]";
    }

}
