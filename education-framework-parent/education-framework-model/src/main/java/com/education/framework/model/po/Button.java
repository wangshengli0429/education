package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Button extends ModelTemplet{

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 按钮ID
     */
    private String tagId;

    /**
     * 说明
     */
    private String tagDesc;

    /**
     * 备注
     */
    private String remark;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Button{" +
                "code='" + code + '\'' +
                ", id=" + id +
                ", tagId='" + tagId + '\'' +
                ", creatorId=" + creatorId +
                ", tagDesc='" + tagDesc + '\'' +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
