package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Authentication extends ModelTemplet{

    /**
     * 用户表id
     */
    private Integer userId;

    /**
     * 证件类型：1身份证，2学历证，3学生证
     */
    private Integer authenticationType;

    /**
     * 证件：多张认证时以逗号隔开
     */
    private String authenticationImg;

    /**
     * 1:通过，0:未通过
     */
    private Integer status;

    /**
     * 反馈描述
     */
    private String descr;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(Integer authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getAuthenticationImg() {
        return authenticationImg;
    }

    public void setAuthenticationImg(String authenticationImg) {
        this.authenticationImg = authenticationImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }


    @Override
    public String toString() {
        return "Authentication{" +
                "userId=" + userId +
                ", id=" + id +
                ", authenticationType=" + authenticationType +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", authenticationImg='" + authenticationImg + '\'' +
                ", updaterId=" + updaterId +
                ", status=" + status +
                ", updateTime=" + updateTime +
                ", descr='" + descr + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
