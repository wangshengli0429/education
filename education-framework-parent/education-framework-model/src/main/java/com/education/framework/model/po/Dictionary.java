package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Dictionary extends ModelTemplet{

    /**
     * 数据字典类型表类型
     */
    private Integer dictionaryTypeType;

    /**
     * 编码
     */
    private String code;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 中文名称
     */
    private String cnName;

    /**
     * 英文名称
     */
    private String enName;

    /**
     * 序号
     */
    private Integer idx;

    /**
     * 有效标志 1:有效，0无效
     */
    private Integer validFlag;

    public Integer getDictionaryTypeType() {
        return dictionaryTypeType;
    }

    public void setDictionaryTypeType(Integer dictionaryTypeType) {
        this.dictionaryTypeType = dictionaryTypeType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
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
        return "Dictionary{" +
                "dictionaryTypeType=" + dictionaryTypeType +
                ", id=" + id +
                ", code='" + code + '\'' +
                ", creatorId=" + creatorId +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", cnName='" + cnName + '\'' +
                ", updaterId=" + updaterId +
                ", enName='" + enName + '\'' +
                ", updateTime=" + updateTime +
                ", idx=" + idx +
                ", deleted=" + deleted +
                ", validFlag=" + validFlag +
                '}';
    }
}
