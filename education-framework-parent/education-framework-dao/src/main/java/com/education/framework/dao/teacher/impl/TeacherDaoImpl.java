package com.education.framework.dao.teacher.impl;

import java.util.List;
import java.util.Map;

import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.po.Teacher;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.teacher.TeacherDao;
@Repository
public class TeacherDaoImpl extends SqlSessionDaoSupport implements TeacherDao{

	@Override
	public List<TeacherBo> findAllTeacher(Map<String, Object> map) {
		return this.getSqlSession().selectList("teacher.findAllTeacher", map);
	}

	@Override
	public int findTeacherCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("teacher.findTeacherCount", map);
	}

	@Override
	public int deleteTeacherById(String id) {
		return this.getSqlSession().delete("teacher.deleteTeacherById", id);
	}

	@Override
	public int insertTeacher(Teacher teacher) {
		return this.getSqlSession().insert("teacher.insertTeacher", teacher);
	}

	@Override
	public int updateTeacherById(Teacher teacher) {
		return this.getSqlSession().update("teacher.updateTeacherById", teacher);
	}

	@Override
	public Teacher queryTeacherById(Map<String, Object> map) {
		return this.getSqlSession().selectOne("teacher.queryTeacherById", map);
	}

}
