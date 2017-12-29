package com.education.framework.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */

public class User implements Serializable {

    /***/
    private static final long serialVersionUID = 1L;
    /** 用户ID */
    private Integer userId;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String password;
    /** 用户真实姓名 */
    private String realName;
    /** 是否员工(0:否，1:是) */
    private Integer isstaff;
    /** TOKEN */
    private String token;
    /** 最后访问时间 */
    private Integer lastAccessTime;
    /** 创建或注册时间 */
    private Date createTime;
    /** 修改时间 */
    private Date updateTime;
    /** 创建或注册人 */
    private Integer operator;
    /** 访问ip */
    private String ip;
    /** 状态标志(0:无效，1:有效) */
    private String flag;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getIsstaff() {
        return isstaff;
    }

    public void setIsstaff(Integer isstaff) {
        this.isstaff = isstaff;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Integer lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", realName=" + realName + ", isstaff=" + isstaff
                + ", token=" + token + ", lastAccessTime=" + lastAccessTime + ", createTime=" + createTime
                + ", updateTime=" + updateTime + ", operator=" + operator + ", ip=" + ip + ", flag=" + flag + "]";
    }

}
