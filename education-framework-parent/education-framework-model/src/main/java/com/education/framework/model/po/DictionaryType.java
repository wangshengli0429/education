package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class DictionaryType extends ModelTemplet{

    /**
     * 类型:1学部(小学，初中，高中)
     */
    private Integer type;

    /**
     * 描述
     */
    private String desc;

    /**
     * 序号
     */
    private Integer idx;

    /**
     * 有效标志 1有效，0无效
     */
    private Integer validFlag;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Integer getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
    }

    @Override
    public String toString() {
        return "dictionaryType{" +
                "type=" + type +
                ", id=" + id +
                ", desc='" + desc + '\'' +
                ", creatorId=" + creatorId +
                ", idx=" + idx +
                ", createTime=" + createTime +
                ", validFlag=" + validFlag +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
