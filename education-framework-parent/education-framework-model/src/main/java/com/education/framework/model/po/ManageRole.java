package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class ManageRole extends ModelTemplet{

    /**
     * 管理员登陆名
     */
    private String manageLoginName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 备注
     */
    private String remark;

    public String getManageLoginName() {
        return manageLoginName;
    }

    public void setManageLoginName(String manageLoginName) {
        this.manageLoginName = manageLoginName;
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
        return "ManageRole{" +
                "manageLoginName='" + manageLoginName + '\'' +
                ", id=" + id +
                ", roleCode='" + roleCode + '\'' +
                ", creatorId=" + creatorId +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }

}
