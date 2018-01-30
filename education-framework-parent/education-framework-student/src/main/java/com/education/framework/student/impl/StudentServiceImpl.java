package com.education.framework.student.impl;

import static com.education.framework.common.base.StatusCode.EDU_CODE_000;
import static com.education.framework.common.base.StatusCode.EDU_CODE_002;
import static com.education.framework.common.base.StatusCode.EDU_CODE_003;
import static com.education.framework.common.base.StatusCode.EDU_CODE_004;
import static com.education.framework.common.base.StatusCode.EDU_CODE_005;
import static com.education.framework.common.base.StatusCode.EDU_CODE_006;
import static com.education.framework.common.base.StatusCode.EDU_CODE_007;
import static com.education.framework.common.base.StatusCode.EDU_CODE_008;
import static com.education.framework.common.base.StatusCode.EDU_CODE_009;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.common.base.ApiResult;
import com.education.framework.common.exception.BusinessException;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.dao.student.StudentDao;
import com.education.framework.dao.user.UserDao;
import com.education.framework.model.student.Student;
import com.education.framework.model.user.User;
import com.education.framework.service.student.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	 
	@Autowired
	private UserDao userDao;
	
	private static Logger logger = Logger.getLogger(StudentServiceImpl.class);
	

	@Override
	public ApiResult findAllStudent(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("findAllStudent begin"));
		ApiResult apiResult = new ApiResult(EDU_CODE_000.getCode(),EDU_CODE_000.getMsg());			
        try {
            // 设置总数
        	apiResult.setCount(studentDao.findStudentCount(map));
            // 设置用户列表信息
        	apiResult.setData(studentDao.findAllStudent(map));
        	
            logger.info(LogFormatService.logFormat("分页获取资源列表success"));
            logger.info(LogFormatService.logFormat(apiResult.toString()));
           
			return apiResult;
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询学生异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("查询学生异常：{}"), e);
			logger.debug(e.getMessage());
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		
		
	}
 

	@Override
	public ApiResult queryStudentById(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("queryStudentById  begin"));
		Student student = null;
		try {
			student = studentDao.queryStudentById(map);
			if(null != student){
				logger.info(LogFormatService.logFormat(student.toString()));
				return new ApiResult(EDU_CODE_009.getCode(), EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),student);
			}
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询学生异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.info(LogFormatService.logFormat("查询学生异常：{}"),e);
			 throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		logger.info(LogFormatService.logFormat("queryStudentById end 查询结果为空"));
		return new ApiResult(EDU_CODE_008.getCode(), EDU_CODE_008.getMsg(), EDU_CODE_008.getShowMsg());
	}

	@Override
	public ApiResult insertStudent(Student student) {
		logger.info(LogFormatService.logFormat("insert student begin"));
		int num = 0;
		try {
			num = studentDao.insertStudent(student);
			
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("新增学生异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("新增学生异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		}
		logger.info("insert student "+(num > 0?"success":"fail") +"end.");    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_003.getCode(), EDU_CODE_003.getMsg(), EDU_CODE_003.getShowMsg());
        }
		return new ApiResult(EDU_CODE_002.getCode(), EDU_CODE_002.getMsg(), EDU_CODE_002.getShowMsg());
	}

	@Override
	public ApiResult updateStudent(Student student,String cerStatus) {
		logger.info(LogFormatService.logFormat("update student begin"));
		int num = 0;
		User user = null ;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", student.getUserId());
			user = userDao.queryUserById(map);
			if(null != user){
					user.setCerStatus(cerStatus);
					num = userDao.updateUserById(user);
			}else{
				logger.info("审批:"+student.getStudent()+",出现异常未能查到user表中数据");
				return new ApiResult(EDU_CODE_008.getCode(), EDU_CODE_008.getMsg(), EDU_CODE_008.getShowMsg());
			}
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("修改学生异常：{}"), e);
		    throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("修改学生异常：{}"), e);
			throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("update student "+(num > 0?"success":"fail") +"end."));    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_005.getCode(), EDU_CODE_005.getMsg(), EDU_CODE_005.getShowMsg());
        }
		return new ApiResult(EDU_CODE_004.getCode(), EDU_CODE_004.getMsg(), EDU_CODE_004.getShowMsg());
	}
 

	@Override
	public ApiResult updateStrudentById(String id,String status) {
		logger.info(LogFormatService.logFormat("update student begin"));
		int num = 0;
		User user = null;
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
			logger.debug(LogFormatService.logFormat("删除学生异常：{}"), e);
		    throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("删除学生异常：{}"), e);
			throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("update student "+(num > 0?"success":"fail") +"end."));    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_007.getCode(), EDU_CODE_007.getMsg(), EDU_CODE_007.getShowMsg());
        }
		return new ApiResult(EDU_CODE_006.getCode(), EDU_CODE_006.getMsg(), EDU_CODE_006.getShowMsg());
	}
	
}
