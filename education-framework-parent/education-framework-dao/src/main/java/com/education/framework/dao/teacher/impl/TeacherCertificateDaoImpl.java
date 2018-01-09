package com.education.framework.dao.teacher.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.teacher.TeacherCertificateDao;
import com.education.framework.model.teacher.TeacherCertificate;
@Repository
public class TeacherCertificateDaoImpl extends SqlSessionDaoSupport implements TeacherCertificateDao{

	@Override
	public List<TeacherCertificate> findAllTeacherCertificate(Map<String, Object> map) {
		return this.getSqlSession().selectList("teacherCertificate.findAllTeacherCertificate", map);
	}

	@Override
	public int findTeacherCertificateCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("teacherCertificate.findTeacherCertificateCount", map);
	}

	@Override
	public int deleteTeacherCertificateById(String id) {
		return this.getSqlSession().delete("teacherCertificate.deleteTeacherCertificateById", id);
	}

	@Override
	public int insertTeacherCertificate(TeacherCertificate teacherCertificate) {
		return this.getSqlSession().insert("teacherCertificate.insertTeacherCertificate", teacherCertificate);
	}

	@Override
	public int updateTeacherCertificateById(TeacherCertificate teacherCertificate) {
		return this.getSqlSession().update("teacherCertificate.updateStrudentById", teacherCertificate);
	}

	@Override
	public TeacherCertificate queryTeacherCertificateById(Map<String, Object> map) {
		return this.getSqlSession().selectOne("teacherCertificate.queryTeacherCertificateById", map);
	}

}
