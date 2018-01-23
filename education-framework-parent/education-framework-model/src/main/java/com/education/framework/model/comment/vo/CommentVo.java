package com.education.framework.model.comment.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.education.framework.model.comment.Comment;

/**
 * <p>评论VO</p>
 * 
 * @author wangqiang
 * @version 1.0
 * @date 2018-01-23
 */
public class CommentVo extends Comment implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;
	
	/** 学生姓名*/
	private String studentName;
	/** 教师姓名*/
	private String teacherName;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
