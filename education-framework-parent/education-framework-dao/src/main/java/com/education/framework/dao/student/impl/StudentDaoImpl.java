package com.education.framework.dao.student.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.student.StudentDao;
import com.education.framework.model.student.Student;
import com.education.framework.model.student.vo.StudentVo;

@Repository
public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao{

	@Override
	public List<StudentVo> findAllStudent(Map<String, Object> map) {
		return  this.getSqlSession().selectList("student.findAllStudent", map);
	}

	@Override
	public int findStudentCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("student.findStudentCount", map);
	}

	@Override
	public int deleteStudentById(String id) {
		return this.getSqlSession().delete("student.deleteStudentById", id);
	}

	@Override
	public int insertStudent(Student student) {
		return this.getSqlSession().insert("student.insertStudent", student);
	}

	@Override
	public int updateStrudentById(Student student) {
		return this.getSqlSession().update("student.updateStrudentById", student);
	}

	@Override
	public Student queryStudentById(Map<String, Object> map) {
		return this.getSqlSession().selectOne("student.queryStudentById", map);
	}

}
