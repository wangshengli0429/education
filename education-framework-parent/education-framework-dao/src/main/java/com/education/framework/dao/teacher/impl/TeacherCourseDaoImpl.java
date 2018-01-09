package com.education.framework.dao.teacher.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.teacher.TeacherCourseDao;
import com.education.framework.model.teacher.TeacherCourse;
@Repository
public class TeacherCourseDaoImpl extends SqlSessionDaoSupport implements
		TeacherCourseDao {

	@Override
	public List<TeacherCourse> findAllTeacherCourse(Map<String, Object> map) {
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
	public int insertTeacherCourse(TeacherCourse teacherCourse) {
		return this.getSqlSession().insert("teacherCourse.insertTeacherCourse", teacherCourse);
	}

	@Override
	public int updateStrudentById(TeacherCourse teacherCourse) {
		return this.getSqlSession().update("teacherCourse.updateStrudentById", teacherCourse);
	}

	@Override
	public TeacherCourse queryTeacherCourseById(Map<String, Object> map) {
		
		return this.getSqlSession().selectOne("teacherCourse.queryTeacherCourseById", map);
	}

}
