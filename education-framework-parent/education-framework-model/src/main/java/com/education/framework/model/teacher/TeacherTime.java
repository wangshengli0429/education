package com.education.framework.model.teacher;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;
/**
 * 
 * <p>TeacherTime.java</p>
 * <p>教师授课时间</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午4:59:39
 * <p>修改者姓名 修改内容说明</p>
 */
public class TeacherTime implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4031799144968176663L;
	
	private String id;
	private String userId;
	/**
	 * 年级
	 */
	private String grade;
	/**
	 * 课程
	 */
	private String course;
	/**
	 * 开始时间 注意：精确到分钟
	 */
	private Date beginTime;
	
	/**
	 * 结束时间 注意：精确到分钟
	 */
	private Date endTime;

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

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
