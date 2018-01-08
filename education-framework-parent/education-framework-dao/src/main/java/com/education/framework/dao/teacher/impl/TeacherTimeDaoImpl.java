package com.education.framework.dao.teacher.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.education.framework.dao.teacher.TeacherTimeDao;
import com.education.framework.model.teacher.TeacherTime;

public class TeacherTimeDaoImpl extends SqlSessionDaoSupport implements
		TeacherTimeDao {

	@Override
	public List<TeacherTime> findAllTeacherTime(Map<String, Object> map) {
		return this.getSqlSession().selectList("teacherTime.findAllTeacherTime", map);
	}

	@Override
	public int findTeacherTimeCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("teacherTime.findTeacherTimeCount", map);
	}

	@Override
	public int deleteTeacherTimeById(String id) {
		return this.getSqlSession().delete("teacherTime.deleteTeacherTimeById", id);
	}

	@Override
	public int insertTeacherTime(TeacherTime teacherTime) {
		return this.getSqlSession().insert("teacherTime.insertTeacherTime", teacherTime);
	}

	@Override
	public int updateTeacherTimeById(TeacherTime teacherTime) {
		return this.getSqlSession().update("teacherTime.updateTeacherTimeById", teacherTime);
	}

	@Override
	public TeacherTime queryTeacherTimeById(Map<String, Object> map) {
		return this.getSqlSession().selectOne("teacherTime", map);
	}

}
