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
import com.education.framework.model.teacher.Teacher;
import com.education.framework.model.teacher.vo.TeacherVo;
import com.education.framework.service.teacher.TeacherService;
import com.google.common.collect.Maps;


@Controller
public class TeacherController {

	private static Logger logger = Logger.getLogger(TeacherController.class);
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value={"rest/query/teacher","query/teacher"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult findAllTeacher(TeacherVo teacher, @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int rows){
		logger.info("controller queryAllTeacher ");
		 
		Map<String, Object> map = Maps.newHashMap();
		map.put("id", teacher.getId());
		
		// 设置检索开始条数
		map.put("pageNo", (page - 1) * rows);
//      // 设置检索截止条数
		map.put("pageCount", rows);
		
		return teacherService.findAllTeacher(map);
	}
	
	@RequestMapping(value={"rest/query/teacher/{id}","query/teacher/{id}"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult queryTeacherById(@PathVariable String id){
		logger.info("controller queryAllStudent "+ id );
		Map<String, Object> map = Maps.newHashMap();
		map.put("id",id);
		
		return teacherService.queryTeacherById(map);
	}
	
	@RequestMapping(value={"rest/teacher/insert","teacher/insert"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult insertTeacher(@RequestParam Teacher teacher){
		logger.info("controller insertTeacher ");
		return teacherService.insertTeacher(teacher);
	}
	
	@RequestMapping(value={"rest/teacher/update","teacher/update"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult updateTeacher(@RequestParam Teacher teacher){
		logger.info("controller updateTeacher ");
		return teacherService.updateTeacherById(teacher);
	}
	
	@RequestMapping(value={"rest/teacher/delete","teacher/delete"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult deleteTeacher(@RequestParam String id){
		logger.info("controller deleteTeacher ");
		return teacherService.deleteTeacherById(id);
	}
	
}