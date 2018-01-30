package com.education.controller.student;

import java.util.HashMap;
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
import com.education.framework.model.student.Student;
import com.education.framework.service.student.StudentService;
import com.google.common.collect.Maps;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	private static Logger logger = Logger.getLogger(StudentController.class);
	
	@RequestMapping(value={"rest/to/query/student","to/query/student"},method={RequestMethod.GET,RequestMethod.POST})
	public String toAllStudent() {
		return "manager/student/student-list";
	}
	
	@RequestMapping(value={"rest/query/student","query/student"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult queryAllStudent(
            @RequestParam(required=false) String keyword, @RequestParam Integer page, @RequestParam Integer limit){
		logger.info("controller queryAllStudent begin ");
		 
		Map<String,Object> map = Maps.newHashMap();
		// 检索条件
		map.put("keyword", keyword);
		map.put("rowStart", page-1);
		map.put("pageSize",limit);
		
		return  studentService.findAllStudent(map);
	}
	
	@RequestMapping(value={"rest/query/student/{id}","query/student/{id}"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> queryStudentById(@PathVariable String id){
		logger.info("controller queryAllStudent begin ");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		ApiResult apiResult = studentService.queryStudentById(map);
		logger.info(""+ apiResult.toString());
		if(apiResult.getCode() == 9){
			map.put("student",(Student)apiResult.getData());
		}
		 return map;
	}
	
	
	@RequestMapping(value={"rest/student/insert","student/insert"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult insertStudent(@RequestParam Student student){
		logger.info("controller insertStudent ");
		return studentService.insertStudent(student);
	}
	/**
	 * 审核通过
	 * @param student
	 * @return
	 */
	@RequestMapping(value={"rest/student/examine","student/examine"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> updateStudent(Student student){
		logger.info("controller updateStudent ");
		Map<String, Object> map = new HashMap<String, Object>();
		ApiResult apiResult = studentService.updateStudent(student,Const.CER_STATUS_Y);
		
		map.put("code", apiResult.getCode());
		map.put("msg", apiResult.getMsg());
		
		return map;
	}
	/**
	 * 审核未通过
	 * @param student
	 * @return
	 */
	@RequestMapping(value={"rest/student/unaudited","student/unaudited"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> unauditedStudent(Student student){
		logger.info("controller updateStudent ");
		Map<String, Object> map = new HashMap<String, Object>();
		ApiResult apiResult = studentService.updateStudent(student,Const.CER_STATUS_N);
		
		map.put("code", apiResult.getCode());
		map.put("msg", apiResult.getMsg());
		
		return map;
	}
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	@RequestMapping(value={"rest/student/del","student/del"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult updateStudentById(@RequestParam(required=true) String id){
		logger.info("controller updateStudent ");
		 
		return studentService.updateStrudentById(id,Const.STATUS_D);
	}
	 
	
}
