package com.education.controller.teacher;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.service.TeacherApi;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Controller
@RequestMapping("/teacher")
public class TeacherController {

	private static Logger logger = Logger.getLogger(TeacherController.class);
	
	@Autowired
	TeacherApi teacherApi;

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ResultData save(@RequestBody TeacherBo teacherBo){
		if (null==teacherBo){return ResultData.failed("teacherBo不能为空!");}
		ApiResponse<Integer> apiResponse = teacherApi.save(teacherBo);
		return ApiRetCode.SUCCESS_CODE == apiResponse.getRetCode()?ResultData.successed(apiResponse.getMessage(),apiResponse.getBody()):ResultData.failed(apiResponse.getMessage());
	}

	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	public ResultData getById(@RequestParam Integer id){
		if (null==id){return ResultData.failed("id不能为空!");}
		TeacherBo teacherBo = new TeacherBo();
		teacherBo.setId(1);
		teacherBo.setSurname("熊");
		teacherBo.setName("凡");
		teacherBo.setSex(1);
		teacherBo.setBirthday(new Date());
		teacherBo.setNativePlace("湖北");
		teacherBo.setProvince("北京");
		teacherBo.setCity("北京市");
		teacherBo.setDictrict("海淀区");
		teacherBo.setAddress("鑫磊沙公寓305");
		teacherBo.setEducaion("本科");
		teacherBo.setMajor("计算机科学与技术");
		teacherBo.setSelfDescr("本人武汉大学毕业，多年从事教育工作...");
		teacherBo.setPhoto("http：//a/s.jpg");
		teacherBo.setIdCardStatus(1);
		teacherBo.setCreateTime(new Date());
		teacherBo.setCreatorId(1);
		teacherBo.setUpdateTime(new Date());
		teacherBo.setUpdaterId(1);
		return ResultData.successed(teacherBo);
	}
	

	
}
