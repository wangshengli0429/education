package com.education.framework.authority.menu.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Menu implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 菜单编码 */
	private String menuCode;
	/** 父菜单编码 */
	private String parentCode;
	/** 菜单名称 */
	private String menuDescr;
	/** URL */
	private String menuHref;
	/** 打开方式:_blank,_self,framename */
	private String target;
	/** 显示顺序 */
	private int idx;
	/** 备注*/
	private String remark;
	
	/** 创建人 */
	private String creator;
	/** 创建时间 */
	private String 	createrTime;
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getMenuDescr() {
		return menuDescr;
	}
	public void setMenuDescr(String menuDescr) {
		this.menuDescr = menuDescr;
	}
	public String getMenuHref() {
		return menuHref;
	}
	public void setMenuHref(String menuHref) {
		this.menuHref = menuHref;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreaterTime() {
		return createrTime;
	}
	public void setCreaterTime(String createrTime) {
		this.createrTime = createrTime;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
