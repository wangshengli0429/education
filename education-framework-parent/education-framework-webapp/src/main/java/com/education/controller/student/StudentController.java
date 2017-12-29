package com.education.controller.student;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.student.Student;
import com.education.framework.service.student.StudentService;
import com.google.common.collect.Maps;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	private static Logger logger = Logger.getLogger(StudentController.class);
	
	@RequestMapping(value={"rest/student/queryStudent","student/queryStudent"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult queryAllStudent(Student student, @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int rows){
		logger.info("controller queryAllStudent begin ");
		 
		Map<String, Object> map = Maps.newHashMap();
		map.put("id", student.getId());
		
		// 设置检索开始条数
		map.put("pageNo", (page - 1) * rows);
//      // 设置检索截止条数
		map.put("pageCount", rows);
		
		return  studentService.findAllStudent(map);
	}
	
	@RequestMapping(value={"rest/student/insert","student/insert"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult insertStudent(@RequestParam Student student){
		
		return studentService.insertStudent(student);
	}
	
}
