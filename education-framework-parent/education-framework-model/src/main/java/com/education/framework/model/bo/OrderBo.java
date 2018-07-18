package com.education.framework.model.bo;

import com.education.framework.model.po.Order;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class OrderBo extends Order {

    private TeacherBo teacherBo;

    private StudentBo studentBo;

    private List<Integer> teacherTimeIds;

    public List<Integer> getTeacherTimeIds() {
        return teacherTimeIds;
    }

    public void setTeacherTimeIds(List<Integer> teacherTimeIds) {
        this.teacherTimeIds = teacherTimeIds;
    }

    public TeacherBo getTeacherBo() {
        return teacherBo;
    }

    public void setTeacherBo(TeacherBo teacherBo) {
        this.teacherBo = teacherBo;
    }

    public StudentBo getStudentBo() {
        return studentBo;
    }

    public void setStudentBo(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

}
