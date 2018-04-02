package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class User extends ModelTemplet{

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册时间
     */
    private Date regTime;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 类型（1:教师，2:学生）
     */
    private Integer userType;

    /**
     * 1正常,2冻结
     */
    private Integer status;

    /**
     * 1通过，2不通过
     */
    private Integer cerStatus;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCerStatus() {
        return cerStatus;
    }

    public void setCerStatus(Integer cerStatus) {
        this.cerStatus = cerStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", creatorId=" + creatorId +
                ", regTime=" + regTime +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", updaterId=" + updaterId +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", updateTime=" + updateTime +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", deleted=" + deleted +
                ", userType=" + userType +
                ", status=" + status +
                ", cerStatus=" + cerStatus +
                '}';
    }

}
