package com.education.framework.dao.teacher.impl;

import java.util.List;
import java.util.Map;

import com.education.framework.model.po.TeacherSubject;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.teacher.TeacherCourseDao;
@Repository
public class TeacherCourseDaoImpl extends SqlSessionDaoSupport implements
		TeacherCourseDao {

	@Override
	public List<TeacherSubject> findAllTeacherCourse(Map<String, Object> map) {
		return this.getSqlSession().selectList("teacherCourse.findAllTeacherCourse", map);
	}

	@Override
	public int findTeacherCourseCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("teacherCourse.findTeacherCourseCount", map);
	}

	@Override
	public int deleteTeacherCourseById(String id) {
		return this.getSqlSession().delete("teacherCourse.deleteTeacherCourseById", id);
	}

	@Override
	public int insertTeacherCourse(TeacherSubject teacherCourse) {
		return this.getSqlSession().insert("teacherCourse.insertTeacherCourse", teacherCourse);
	}

	@Override
	public int updateStrudentById(TeacherSubject teacherCourse) {
		return this.getSqlSession().update("teacherCourse.updateStrudentById", teacherCourse);
	}

	@Override
	public TeacherSubject queryTeacherCourseById(Map<String, Object> map) {
		
		return this.getSqlSession().selectOne("teacherCourse.queryTeacherCourseById", map);
	}

}
