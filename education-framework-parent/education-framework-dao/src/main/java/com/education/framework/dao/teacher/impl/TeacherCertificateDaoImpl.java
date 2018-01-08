package com.education.framework.dao.teacher.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.education.framework.dao.teacher.TeacherCertificateDao;
import com.education.framework.model.teacher.TeacherCertificate;

public class TeacherCertificateDaoImpl extends SqlSessionDaoSupport implements TeacherCertificateDao{

	@Override
	public List<TeacherCertificate> findAllTeacherCertificate(Map<String, Object> map) {
		return this.getSqlSession().selectList("teacher.findAllTeacherCertificate", map);
	}

	@Override
	public int findTeacherCertificateCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("teacher.findTeacherCertificateCount", map);
	}

	@Override
	public int deleteTeacherCertificateById(String id) {
		return this.getSqlSession().delete("teacher.deleteTeacherCertificateById", id);
	}

	@Override
	public int insertTeacherCertificate(TeacherCertificate teacherCertificate) {
		return this.getSqlSession().insert("teacher.insertTeacherCertificate", teacherCertificate);
	}

	@Override
	public int updateTeacherCertificateById(TeacherCertificate teacherCertificate) {
		return this.getSqlSession().update("teacher.updateStrudentById", teacherCertificate);
	}

	@Override
	public TeacherCertificate queryTeacherCertificateById(Map<String, Object> map) {
		return this.getSqlSession().selectOne("teacher.queryTeacherCertificateById", map);
	}

}
