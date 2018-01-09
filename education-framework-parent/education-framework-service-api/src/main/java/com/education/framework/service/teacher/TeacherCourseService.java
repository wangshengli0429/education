package com.education.framework.service.teacher;

import java.util.Map;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.teacher.TeacherCourse;

/**
 * 
 * <p>TeacherCourseService.java</p>
 * <p>教师课程CRUD</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午6:54:56
 * <p>修改者姓名 修改内容说明</p>
 */
public interface TeacherCourseService {
	
	ApiResult findAllTeacherCourse(Map<String, Object> map);
	 
	ApiResult deleteTeacherCourseById(String id);
	ApiResult insertTeacherCourse(TeacherCourse teacherCourse);
	ApiResult updateStrudentById(TeacherCourse teacherCourse);
	ApiResult queryTeacherCourseById(Map<String, Object> map);
}
