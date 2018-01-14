package com.education.controller.teacher;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.teacher.TeacherTime;
import com.education.framework.service.teacher.TeacherTimeService;
import com.education.framework.teacher.impl.TeacherTimeServiceImpl;
import com.google.common.collect.Maps;
@Controller
public class TeacherTimeController {
	@Autowired
	private TeacherTimeService teacherTimeService;
	
	private static Logger logger = Logger.getLogger(TeacherTimeServiceImpl.class);

	@RequestMapping(value={"",""},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult findAllTeacherTime(TeacherTime teacherTime, @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int rows){
		logger.info("controller findAllTeacherTime ");
		
		Map<String, Object> map = Maps.newHashMap();
		map.put("id", teacherTime.getId());
		// 设置检索开始条数
		map.put("pageNo", (page - 1) * rows);
		// 设置检索截止条数
		map.put("pageCount", rows);
		return teacherTimeService.findAllTeacherTime(map);
	}
	
	@RequestMapping(value={"rest/query/teacherTime/{id}","query/teacherTime/{id}"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult queryTeacherById(@PathVariable String id){
		logger.info("controller queryTeacherById "+ id );
		Map<String, Object> map = Maps.newHashMap();
		map.put("id",id);
		
		return teacherTimeService.queryTeacherTimeById(map);
	}
	
	@RequestMapping(value={"rest/teacherTime/insert","teacherTime/insert"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult insertTeacherTime(@RequestParam TeacherTime teacherTime){
		logger.info("controller insertTeacher ");
		return teacherTimeService.insertTeacherTime(teacherTime);
	}
	
	@RequestMapping(value={"rest/teacher/update","teacher/update"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult updateTeacherTime(@RequestParam TeacherTime teacherTime){
		logger.info("controller updateTeacherTime ");
		return teacherTimeService.updateTeacherTimeById(teacherTime);
	}
	
	@RequestMapping(value={"rest/teacherTime/delete","teacherTime/delete"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult deleteTeacherTime(@RequestParam String id){
		logger.info("controller deleteTeacherTime ");
		return teacherTimeService.deleteTeacherTimeById(id);
	}

}
