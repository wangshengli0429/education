package com.education.framework.model.bo;

import com.education.framework.model.po.Subject;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/6.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/6.
 * @note
 */
public class BasicDataBo implements Serializable,Cloneable{

    /**
     * 学部code
     */
    private String departmentCode;

    /**
     * 全部学部
     */
    private List<DictionaryBo> departmentBos;

    /**
     * 学科
     */
    private List<SubjectBo> subjectBos;

    /**
     * 年级
     */
    private List<GradeBo> gradeBos;


    public List<DictionaryBo> getDepartmentBos() {
        return departmentBos;
    }

    public void setDepartmentBos(List<DictionaryBo> departmentBos) {
        this.departmentBos = departmentBos;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public List<SubjectBo> getSubjectBos() {
        return subjectBos;
    }

    public void setSubjectBos(List<SubjectBo> subjectBos) {
        this.subjectBos = subjectBos;
    }

    public List<GradeBo> getGradeBos() {
        return gradeBos;
    }

    public void setGradeBos(List<GradeBo> gradeBos) {
        this.gradeBos = gradeBos;
    }
}
