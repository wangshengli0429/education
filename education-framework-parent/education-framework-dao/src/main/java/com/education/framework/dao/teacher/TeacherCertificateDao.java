package com.education.framework.dao.teacher;

import com.education.framework.model.po.TeacherCertificate;

import java.util.List;
import java.util.Map;


/**
 * 
 * <p>TeacherDao.java</p>
 * <p>教师相关证书CRUD</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午6:54:56
 * <p>修改者姓名 修改内容说明</p>
 */
public interface TeacherCertificateDao {
	
	List<TeacherCertificate> findAllTeacherCertificate(Map<String, Object> map);
	int findTeacherCertificateCount(Map<String, Object> map);
	 
	int deleteTeacherCertificateById(String id);
	int insertTeacherCertificate(TeacherCertificate teacherCertificate);
	int updateTeacherCertificateById(TeacherCertificate teacherCertificate);
	TeacherCertificate queryTeacherCertificateById(Map<String, Object> map);
}
