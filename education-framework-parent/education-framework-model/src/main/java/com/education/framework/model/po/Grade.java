package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Grade extends ModelTemplet{

    /**
     * 年级编码
     */
    private String code;

    /**
     * 年级名称
     */
    private String name;

    /**
     * 学部编码
     */
    private String departmentCode;

    /**
     * 0禁用，1启用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;

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

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
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
        return "Grade{" +
                "code=" + code +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", creatorId=" + creatorId +
                ", departmentCode='" + departmentCode + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", updaterId=" + updaterId +
                ", sort=" + sort +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
