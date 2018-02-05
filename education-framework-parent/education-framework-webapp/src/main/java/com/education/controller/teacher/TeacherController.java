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
import com.education.framework.common.util.Const;
import com.education.framework.model.teacher.Teacher;
import com.education.framework.service.teacher.TeacherService;
import com.google.common.collect.Maps;


@Controller
public class TeacherController {

	private static Logger logger = Logger.getLogger(TeacherController.class);
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value={"rest/query/teacher","query/teacher"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult findAllTeacher(
            @RequestParam(required=false) String keyword,@RequestParam(required=true) String cerStatus, @RequestParam Integer page, @RequestParam Integer limit){
		logger.info("controller queryAllTeacher ");
		Map<String,Object> map = Maps.newHashMap();
		// 检索条件
		map.put("keyword", keyword);
		map.put("rowStart", page-1);
		map.put("pageSize",limit);
		map.put("cerStatus", cerStatus);
		return teacherService.findAllTeacher(map);
	}
 
	@RequestMapping(value={"rest/to/query/teacher","to/query/teacher"},method={RequestMethod.GET,RequestMethod.POST})
	public String toAllTeacher() {
		return "manager/teacher/teacher-list";
	}
	
	@RequestMapping(value={"rest/query/teacher/{id}","query/teacher/{id}"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public  Map<String, Object> queryTeacherById(@PathVariable String id){
		logger.info("controller queryAllStudent "+ id );
		Map<String, Object> map = Maps.newHashMap();
		map.put("id",id);
		ApiResult apiResult = teacherService.queryTeacherById(map);
		if(apiResult.getCode() == 9){
			map.put("teacher", (Teacher)apiResult.getData());
		}
		return map;
	}
	
	@RequestMapping(value={"rest/teacher/insert","teacher/insert"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult insertTeacher(@RequestParam Teacher teacher){
		logger.info("controller insertTeacher ");
		return teacherService.insertTeacher(teacher);
	}
	/**
	 * 审核通过
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value={"rest/teacher/examine","teacher/examine"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult updateTeacher( Teacher teacher){
		logger.info("controller updateTeacher ");
		return teacherService.updateTeacherById(teacher,Const.CER_STATUS_Y);
	}
	/**
	 * 审核未通过
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value={"rest/teacher/unaudited","teacher/unaudited"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult unauditedTeacher( Teacher teacher){
		logger.info("controller updateTeacher ");
		return teacherService.updateTeacherById(teacher,Const.CER_STATUS_N);
	}
	
	@RequestMapping(value={"rest/teacher/del","teacher/del"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult deleteTeacher(@RequestParam(required=true) String id){
		logger.info("controller deleteTeacher ");
		return teacherService.deleteTeacherById(id,Const.STATUS_D);
	}
	
}
