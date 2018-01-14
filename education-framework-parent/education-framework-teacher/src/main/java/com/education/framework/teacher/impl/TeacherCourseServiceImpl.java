package com.education.framework.teacher.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.common.base.ApiResult;
import com.education.framework.dao.teacher.TeacherCourseDao;
import com.education.framework.model.teacher.TeacherCourse;
import com.education.framework.service.teacher.TeacherCourseService;
@Service
@Transactional
public class TeacherCourseServiceImpl implements TeacherCourseService {
	@Autowired
	private TeacherCourseDao teacCourseDao;
	private static Logger logger = Logger.getLogger(TeacherCourseServiceImpl.class);
	
	
	@Override
	public ApiResult findAllTeacherCourse(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResult deleteTeacherCourseById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResult insertTeacherCourse(TeacherCourse teacherCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResult updateStrudentById(TeacherCourse teacherCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResult queryTeacherCourseById(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}