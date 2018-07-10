package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * @author zhoulin
 * @createTime 2018/7/10.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/10.
 * @note
 */
public class Idcard extends ModelTemplet {

    /**
     * 用户id
     */
    private Integer  userId;

    /**
     * 类型（1:教师，2:学生）
     */
    private Integer userType;

    /**
     * 0待审核，1审核通过，2不通过
     */
    private Integer status;

    /**
     * 审核不通过原因
     */
    private String descr;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 身份证正面url
     */
    private String positiveUrl;

    /**
     * 身份证反面url
     */
    private String negativeUrl;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPositiveUrl() {
        return positiveUrl;
    }

    public void setPositiveUrl(String positiveUrl) {
        this.positiveUrl = positiveUrl;
    }

    public String getNegativeUrl() {
        return negativeUrl;
    }

    public void setNegativeUrl(String negativeUrl) {
        this.negativeUrl = negativeUrl;
    }
}
