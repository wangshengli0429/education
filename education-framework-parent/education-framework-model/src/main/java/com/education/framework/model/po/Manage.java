package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Manage extends ModelTemplet{

    /**
     * 登陆名
     */
    private Integer loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 状态 1有效，0无效
     */
    private Integer status;

    public Integer getLoginName() {
        return loginName;
    }

    public void setLoginName(Integer loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "loginName=" + loginName +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", creatorId=" + creatorId +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", updaterId=" + updaterId +
                ", lastLoginTime=" + lastLoginTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", deleted=" + deleted +
                '}';
    }
}
