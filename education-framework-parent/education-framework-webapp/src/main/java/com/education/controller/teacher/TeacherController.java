package com.education.controller.teacher;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.common.util.AgeUtils;
import com.education.framework.common.util.BaseMapper;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.AttentionBo;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.AttentionCo;
import com.education.framework.model.co.TeacherCertificateCo;
import com.education.framework.model.co.TeacherCo;
import com.education.framework.model.co.TeacherSubjectCo;
import com.education.framework.model.constant.TeacherCertificateEnum;
import com.education.framework.model.constant.TeacherEnum;
import com.education.framework.model.po.District;
import com.education.framework.model.po.TeacherSubject;
import com.education.framework.model.vo.TeacherVo;
import com.education.framework.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
	private TeacherCertificateApi teacherCertificateApi;

	@Autowired
	private TeacherSubjectApi teacherSubjectApi;

	@Autowired
	private DistrictApi districtApi;

	@Resource
	private AttentionApi attentionsApi;

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ResultData save(@RequestBody TeacherBo teacherBo){
		if (null==teacherBo){return ResultData.failed("teacherBo不能为空!");}
		if (null==teacherBo.getUserId()){return ResultData.failed("userId不能为空!");}
		ApiResponse<Integer> apiResponse = teacherApi.save(teacherBo);
		return ApiRetCode.SUCCESS_CODE == apiResponse.getRetCode()?ResultData.successed(apiResponse.getMessage(),apiResponse.getBody()):ResultData.failed(apiResponse.getMessage());
	}

	/**
	 * 个人中心
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	public ResultData getById(@RequestParam Integer id){
		if (null==id){return ResultData.failed("id不能为空!");}
		ApiResponse<TeacherBo> apiResponse = teacherApi.getById(id);
		if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
			return ResultData.failed(apiResponse.getMessage());
		}
		return ResultData.successed(apiResponse.getBody());
	}

	/**
	 * 教师详情
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/information",method = RequestMethod.GET)
	public ResultData information(TeacherBo teacher){
		if (null==teacher){return ResultData.failed("teacherBo不能为空!");}
		if (null==teacher.getId()){return ResultData.failed("id不能为空!");}
		Integer id = teacher.getId();
		// 当前登录的学生id
		Integer studentId = teacher.getStudentId();
		TeacherBo teacherBo = null;
		try {
			ApiResponse<TeacherBo> apiResponse = teacherApi.getById(id);
			if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
				return ResultData.failed(apiResponse.getMessage());
			}
			teacherBo = apiResponse.getBody();
			teacherBo.setSurname(teacherBo.getSurname()+"老师");
			teacherBo.setAge(AgeUtils.getAge(teacherBo.getBirthday()));
			TeacherCertificateCo teacherCertificateCo = new TeacherCertificateCo();
			teacherCertificateCo.setTeacherId(id);
			teacherCertificateCo.setStatus(TeacherCertificateEnum.status.check_pass.getValue());
			// 教师证书
			teacherBo.setTeacherCertificateBos(teacherCertificateApi.getListByCondition(teacherCertificateCo).getBody());
			// 科目
			TeacherSubjectCo teacherSubjectCo = new TeacherSubjectCo();
			teacherSubjectCo.setTeacherId(id);
			teacherBo.setTeacherSubjectBos(teacherSubjectApi.getListByCondition(teacherSubjectCo).getBody());
			// 授课地点
			District district = districtApi.getByCode(teacherBo.getDictrict()).getBody();
			if (null!=district){
				teacherBo.setAreas(district.getArea());
			}
			if (null!=studentId){
				AttentionCo attentionCo = new AttentionCo();
				attentionCo.setStudentId(studentId);
				attentionCo.setTeacherId(id);
				// 当前登录学生是否盖教师
				List<AttentionBo> attentionBoList = attentionsApi.findByCondition(attentionCo).getBody();
				if (CollectionUtils.isNotEmpty(attentionBoList)){
					teacherBo.setAttentionStatus(1);
				}else {
					teacherBo.setAttentionStatus(0);
				}
			}

		}catch (Exception e){

		}
		return ResultData.successed(teacherBo);
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

//	@RequestMapping(value = "/list",method = RequestMethod.GET)
//	public ResultData list(TeacherCo teacherCo){
//		PageParam pageParam = new PageParam();
//		if (null != teacherCo.getSortOrder() && teacherCo.getSortOrder().equals(TeacherCo.ZONGHE)){
//			pageParam.setOrderBy(" update_time desc ");
//		}
//		if (null != teacherCo.getSortOrder() && teacherCo.getSortOrder().equals(TeacherCo.COMMENT_DESC)){
//			pageParam.setOrderBy(" comment_count desc ");
//		}
//		if (null != teacherCo.getSortOrder() && teacherCo.getSortOrder().equals(TeacherCo.ORDER_DESC)){
//			pageParam.setOrderBy(" order_count desc ");
//		}
//		pageParam.setPageSize(null==teacherCo.getPageSize()? 20:teacherCo.getPageSize());
//		pageParam.setPageNum(null==teacherCo.getPageNum()? 1:teacherCo.getPageNum());
//		teacherCo.setAuthentication(TeacherEnum.authentication.pass.getValue());
//		ApiResponse<Page<TeacherBo>> apiResponse = teacherApi.getPageByCondition(teacherCo,pageParam);
//		if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
//			return ResultData.failed(apiResponse.getMessage());
//		}
//		Page<TeacherVo> teacherVoPage = this.boToVo(apiResponse.getBody());
//
//		return ResultData.successed();
//	}

	/**
	 * app 教师列表页
	 * @param teacherCo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public ResultData list(TeacherCo teacherCo){
		if (null==teacherCo){return ResultData.failed("teacherCo不能为空!");}
		ApiResponse<Page<TeacherVo>> apiResponse = null;
		try {
			apiResponse = teacherApi.getPageByTeacher(teacherCo);
			if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
				return ResultData.failed(apiResponse.getMessage());
			}
			this.teacherHandle(apiResponse.getBody());
			return ResultData.successed(apiResponse.getBody());
		}catch (Exception e){

		}
		return ResultData.successed(apiResponse.getBody());
	}

	private void teacherHandle(Page<TeacherVo> teacherVoPage) throws Exception{
		if (CollectionUtils.isNotEmpty(teacherVoPage.getList())){
			for (TeacherVo teacher:teacherVoPage.getList()){
				teacher.setName(teacher.getName()+"老师");
				if (teacher.getSex().equals(TeacherEnum.SEX_GIRL)){
					teacher.setGender("女");
				}else {
					teacher.setGender("男");
				}
				// 计算年龄
				teacher.setAge(AgeUtils.getAge(teacher.getBirthday()));
				teacher.setSubjects(teacher.getSubjects()+"...");
			}
		}
	}

	
}
