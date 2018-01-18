package com.education.framework.model.comment.vo;

import java.util.Date;

import com.alibaba.fastjson.JSON;

public class CommentVo {

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
	/** 学生姓名*/
	private String studentName;
	/** 教师姓名*/
	private String teacherName;
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
