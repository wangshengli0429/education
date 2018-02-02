package com.education.framework.model.teacher;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.education.framework.model.user.UserBaseInfo;

/**
 * 
 * <p>Teacher.java</p>
 * <p>教师信息</p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午4:33:36
 * <p>修改者姓名 修改内容说明</p>
 */
public class Teacher extends UserBaseInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8250059160847833797L;
	 /**
	 * 姓名
	 */
	private String teacherName;
	 
	 
	/**
	 * 最高学历
	 */
	private String education;
	/**
	 * 所学专业
	 */
	private String major;
	  
	
	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
