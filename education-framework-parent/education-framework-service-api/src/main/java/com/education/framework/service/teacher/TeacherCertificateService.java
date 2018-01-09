package com.education.framework.service.teacher;

import java.util.Map;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.teacher.TeacherCertificate;

/**
 * 
 * <p>TeacherService.java</p>
 * <p>教师相关证书CRUD</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午6:54:56
 * <p>修改者姓名 修改内容说明</p>
 */
public interface TeacherCertificateService {
	
	ApiResult findAllTeacherCertificate(Map<String, Object> map);
	 
	ApiResult deleteTeacherCertificateById(String id);
	ApiResult insertTeacherCertificate(TeacherCertificate teacherCertificate);
	ApiResult updateTeacherCertificateById(TeacherCertificate teacherCertificate);
	ApiResult queryTeacherCertificateById(Map<String, Object> map);
}
