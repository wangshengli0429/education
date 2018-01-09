package com.education.framework.service.teacher;

import java.util.Map;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.teacher.Teacher;

public interface TeacherService {
	
	ApiResult findAllTeacher(Map<String, Object> map);
	 
	ApiResult deleteTeacherById(String id);
	ApiResult insertTeacher(Teacher teacher);
	ApiResult updateTeacherById(Teacher teacher);
	ApiResult queryTeacherById(Map<String, Object> map);
}
