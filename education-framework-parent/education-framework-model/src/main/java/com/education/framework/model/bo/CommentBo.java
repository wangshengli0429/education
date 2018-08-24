package com.education.framework.model.bo;

import com.education.framework.model.po.Comment;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class CommentBo extends Comment {

    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
