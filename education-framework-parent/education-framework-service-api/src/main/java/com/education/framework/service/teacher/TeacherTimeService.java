package com.education.framework.service.teacher;

import java.util.Map;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.teacher.TeacherTime;

/**
 * 
 * <p>TeacherTimeService.java</p>
 * <p>教师授课时间CRUD</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午6:54:56
 * <p>修改者姓名 修改内容说明</p>
 */
public interface TeacherTimeService {
	
	ApiResult findAllTeacherTime(Map<String, Object> map);
	 
	ApiResult deleteTeacherTimeById(String id);
	ApiResult insertTeacherTime(TeacherTime teacherTime);
	ApiResult updateTeacherTimeById(TeacherTime teacherTime);
	ApiResult queryTeacherTimeById(Map<String, Object> map);
}
