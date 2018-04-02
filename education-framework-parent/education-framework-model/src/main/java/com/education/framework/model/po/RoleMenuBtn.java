package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class RoleMenuBtn extends ModelTemplet{

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 按钮ID
     */
    private String tagId;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "RoleMenuBtn{" +
                "roleCode='" + roleCode + '\'' +
                ", id=" + id +
                ", menuCode='" + menuCode + '\'' +
                ", creatorId=" + creatorId +
                ", tagId='" + tagId + '\'' +
                ", createTime=" + createTime +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
