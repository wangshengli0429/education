package com.education.framework.model.student;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.education.framework.model.user.UserBaseInfo;

public class Student extends UserBaseInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1563097217235386854L;
	
	/**
	 * 学生姓名
	 */
	private String student;

 
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	 
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
