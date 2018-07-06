package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Subject extends ModelTemplet {

    /**
     * 科目编码
     */
    private String code;

    /**
     * 科目名称
     */
    private String name;

    /**
     * 0禁用，1启用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 学部编码
     */
    private String departmentCode;

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", creatorId=" + creatorId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", sort=" + sort +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }

}
