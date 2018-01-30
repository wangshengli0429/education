package com.education.framework.teacher.impl;

import static com.education.framework.common.base.StatusCode.EDU_CODE_000;
import static com.education.framework.common.base.StatusCode.EDU_CODE_002;
import static com.education.framework.common.base.StatusCode.EDU_CODE_003;
import static com.education.framework.common.base.StatusCode.EDU_CODE_004;
import static com.education.framework.common.base.StatusCode.EDU_CODE_005;
import static com.education.framework.common.base.StatusCode.EDU_CODE_006;
import static com.education.framework.common.base.StatusCode.EDU_CODE_007;
import static com.education.framework.common.base.StatusCode.EDU_CODE_008;
import static com.education.framework.common.base.StatusCode.EDU_CODE_009;
import static com.education.framework.common.base.StatusCode.EDU_CODE_010;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.common.base.ApiResult;
import com.education.framework.common.exception.BusinessException;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.dao.teacher.TeacherDao;
import com.education.framework.dao.user.UserDao;
import com.education.framework.model.teacher.Teacher;
import com.education.framework.model.user.User;
import com.education.framework.service.teacher.TeacherService;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherDao teacherDao;
	
	@Autowired
	UserDao userDao;
	private static Logger logger = Logger.getLogger(TeacherServiceImpl.class);

	@Override
	public ApiResult findAllTeacher(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("findAllTeacher begin"));
		ApiResult apiResult = new ApiResult(EDU_CODE_000.getCode(),EDU_CODE_000.getMsg());		
        try {
            // 设置总数z
        	apiResult.setCount(teacherDao.findTeacherCount(map));
            // 设置用户列表信息
        	apiResult.setData(teacherDao.findAllTeacher(map));
            logger.info(LogFormatService.logFormat("分页获取教师列表success"));
            logger.info(LogFormatService.logFormat(apiResult.toString()));
			return apiResult;
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询教师异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}catch (Exception e) {
			logger.debug(LogFormatService.logFormat("查询教师异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
	}

	@Override
	public ApiResult deleteTeacherById(String id,String status) {
		logger.info(LogFormatService.logFormat("delete Teacher【"+ id +"】 begin"));
		if(StringUtils.isBlank(id)){
			return  new ApiResult(EDU_CODE_010.getCode(), EDU_CODE_010.getMsg(), EDU_CODE_010.getShowMsg());
		}
		User user = null;
		int num = 0;
		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			user = userDao.queryUserById(map);
			if(null != user){
				user.setStatus(status);
			   num = userDao.updateUserById(user);
			}else{
				logger.info("删除出现异常未能查到user表中数据");
				return new ApiResult(EDU_CODE_006.getCode(), EDU_CODE_006.getMsg(), EDU_CODE_006.getShowMsg());
			}
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("删除教师异常：{}"), e);
		    throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		}catch (Exception e) {
			logger.debug(LogFormatService.logFormat("删除教师异常：{}"), e);
		    throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("delete Teacher "+(num > 0?"success":"fail") +"end."));    
		if (num > 0) {
            return new ApiResult(EDU_CODE_007.getCode(), EDU_CODE_007.getMsg(), EDU_CODE_007.getShowMsg());
        }
		return new ApiResult(EDU_CODE_006.getCode(), EDU_CODE_006.getMsg(), EDU_CODE_006.getShowMsg());
	}

	@Override
	public ApiResult insertTeacher(Teacher teacher) {
		logger.info(LogFormatService.logFormat("insert teacher begin"));
		int num = 0;
		try {
			num = teacherDao.insertTeacher(teacher);
			
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("新增教师异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("新增教师异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		}
		logger.info("insert teacher "+(num > 0?"success":"fail") +"end.");    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_003.getCode(), EDU_CODE_003.getMsg(), EDU_CODE_003.getShowMsg());
        }
		return new ApiResult(EDU_CODE_002.getCode(), EDU_CODE_002.getMsg(), EDU_CODE_002.getShowMsg());
	}

	@Override
	public ApiResult updateTeacherById(Teacher teacher,String cerStatus) {
		logger.info(LogFormatService.logFormat("update teacher begin"));
		int num = 0;
		User user = null;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", teacher.getUserId());
			user = userDao.queryUserById(map);
			if(null != user){
					user.setCerStatus(cerStatus);
					num = userDao.updateUserById(user);
			}else{
				logger.info("审批:"+teacher.getTeacherName()+",出现异常未能查到user表中数据");
				return new ApiResult(EDU_CODE_008.getCode(), EDU_CODE_008.getMsg(), EDU_CODE_008.getShowMsg());
			}
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("修改教师异常：{}"), e);
		    throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("修改教师异常：{}"), e);
			throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("update teacher "+(num > 0?"success":"fail") +"end."));    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_005.getCode(), EDU_CODE_005.getMsg(), EDU_CODE_005.getShowMsg());
        }
		return new ApiResult(EDU_CODE_004.getCode(), EDU_CODE_004.getMsg(), EDU_CODE_004.getShowMsg());
	}

	@Override
	public ApiResult queryTeacherById(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("queryTeacherById  begin"));
		Teacher teacher = null;
		try {
			teacher = teacherDao.queryTeacherById(map);
			if(null != teacher){
				logger.info(LogFormatService.logFormat(teacher.toString()));
				return new ApiResult(EDU_CODE_009.getCode(), EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),teacher);
			}
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询教师异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.info(LogFormatService.logFormat("查询教师异常：{}"),e);
			 throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		logger.info(LogFormatService.logFormat("queryTeacherById end 查询结果为空"));
		return new ApiResult(EDU_CODE_008.getCode(), EDU_CODE_008.getMsg(), EDU_CODE_008.getShowMsg());
	}
		

	 
}
