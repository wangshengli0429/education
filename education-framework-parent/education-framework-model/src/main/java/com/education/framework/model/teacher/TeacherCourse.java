package com.education.framework.model.teacher;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
/**
 * 
 * <p>TeacherCourse.java</p>
 * <p>教师课程</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午5:06:20
 * <p>修改者姓名 修改内容说明</p>
 */
public class TeacherCourse  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1862115578533412484L;
	
	private String id;
	private String userId;
	private String grade;
	private String course;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	
}	
