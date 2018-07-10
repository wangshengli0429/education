package com.education.controller.teacher;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.TeacherCo;
import com.education.framework.model.vo.TeacherVo;
import com.education.framework.service.TeacherApi;
import com.education.framework.service.UserApi;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/teacher")
public class TeacherController {

	private static Logger logger = Logger.getLogger(TeacherController.class);
	
	@Autowired
	private TeacherApi teacherApi;

	@Autowired
	private UserApi userApi;

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ResultData save(@RequestBody TeacherBo teacherBo){
		if (null==teacherBo){return ResultData.failed("teacherBo不能为空!");}
		if (null==teacherBo.getUserId()){return ResultData.failed("userId不能为空!");}
		ApiResponse<Integer> apiResponse = teacherApi.save(teacherBo);
		return ApiRetCode.SUCCESS_CODE == apiResponse.getRetCode()?ResultData.successed(apiResponse.getMessage(),apiResponse.getBody()):ResultData.failed(apiResponse.getMessage());
	}

	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	public ResultData getById(@RequestParam Integer id){
		if (null==id){return ResultData.failed("id不能为空!");}
		ApiResponse<TeacherBo> apiResponse = teacherApi.getById(id);
		if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
			return ResultData.failed(apiResponse.getMessage());
		}
		return ResultData.successed(apiResponse.getBody());
	}

	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResultData updateById(@RequestBody TeacherBo teacherBo){
		if (null==teacherBo){return ResultData.failed("teacherBo不能为空!");}
		if (null==teacherBo.getId()){return ResultData.failed("id不能为空!");}
		ApiResponse<Integer> apiResponse = teacherApi.updateById(teacherBo);
		if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
			return ResultData.failed(apiResponse.getMessage());
		}
		return ResultData.successed(apiResponse.getBody());
	}

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public ResultData list(TeacherCo teacherCo){
		TeacherVo teacherVo = new TeacherVo();
		teacherVo.setId(1);
		teacherVo.setUserId(1);
		teacherVo.setArea("北京市");
		teacherVo.setGender("男");
		teacherVo.setName("周老师");
		teacherVo.setSubjects("小学语文、小学数学");
		teacherVo.setAttentionCount(10);
		teacherVo.setCommentCount(10);
		teacherVo.setOrderCount(10);
		List<TeacherVo> list = new ArrayList<TeacherVo>();
		list.add(teacherVo);
		return ResultData.successed(list);
	}
	
}
