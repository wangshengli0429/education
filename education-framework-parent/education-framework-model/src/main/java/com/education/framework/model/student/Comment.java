package com.education.framework.model.student;

import java.io.Serializable;
import java.util.Date; 

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSON;


/**
 * <p>评论</p>
 * 
 * @author wangqiang
 * v1.0
 */
public class Comment implements Serializable{

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;
	/** 主键 */
	private String id;
	/** 教师主键（被评论） */
	private String teacherId;
	/** 评论内容  */
	private String content;
	/** 学生主键（评论人） */
	private String studentId;
	/** 评论时间  */
	private Date commentTime;

	//********************************************************* 以下是 get/set 方法 ******************************************************
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
