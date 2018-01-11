package com.education.framework.model.note;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 
 * <p>Note.java</p>
 * <p>留言</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月11日 下午2:08:24
 * <p>修改者姓名 修改内容说明</p>
 */
public class Note implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private String id;
		
	/** 留言内容 */	
	private String noteContent;
	/** 用户ID */	
	private String userId;
	/** 留言时间 */	
	private Date noteTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getNoteTime() {
		return noteTime;
	}
	public void setNoteTime(Date noteTime) {
		this.noteTime = noteTime;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
