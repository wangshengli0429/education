package com.education.framework.model.bo;

import com.education.framework.model.po.Order;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class OrderBo extends Order {

    private TeacherBo teacherBo;

    private StudentBo studentBo;

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
