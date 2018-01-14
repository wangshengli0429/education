package com.education.framework.teacher.impl;

import static com.education.framework.common.base.StatusCode.EDU_CODE_002;
import static com.education.framework.common.base.StatusCode.EDU_CODE_003;
import static com.education.framework.common.base.StatusCode.EDU_CODE_004;
import static com.education.framework.common.base.StatusCode.EDU_CODE_005;
import static com.education.framework.common.base.StatusCode.EDU_CODE_006;
import static com.education.framework.common.base.StatusCode.EDU_CODE_007;
import static com.education.framework.common.base.StatusCode.EDU_CODE_008;
import static com.education.framework.common.base.StatusCode.EDU_CODE_009;
import static com.education.framework.common.base.StatusCode.EDU_CODE_010;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.common.base.ApiResult;
import com.education.framework.common.exception.BusinessException;
import com.education.framework.common.pagination.Pagination;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.dao.teacher.TeacherTimeDao;
import com.education.framework.model.teacher.TeacherTime;
import com.education.framework.service.teacher.TeacherTimeService;

@Service
@Transactional
public class TeacherTimeServiceImpl implements TeacherTimeService{
	
	@Autowired
	private TeacherTimeDao teacherTimeDao;
	

	private static Logger logger = Logger.getLogger(TeacherTimeServiceImpl.class);
	
	@Override
	public ApiResult findAllTeacherTime(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("findAllTeacherTime begin ..."));
		Pagination<TeacherTime> page = new Pagination<TeacherTime>();
		
	  try {
        	 
            page.setPageNo(Integer.valueOf(map.get("pageNo").toString()));//当前页
            page.setPageCount(Integer.valueOf(map.get("pageCount").toString()));//当前页总条数
            // 设置总数
            page.setItemCount(teacherTimeDao.findTeacherTimeCount(map));
            // 设置用户列表信息
        	page.setItems(teacherTimeDao.findAllTeacherTime(map));
        	
            logger.info(LogFormatService.logFormat("分页获取教师授课时间列表success"));
           
			return new ApiResult(EDU_CODE_009.getCode(),EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),page);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询教师授课时间异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}catch (Exception e) {
			logger.debug(LogFormatService.logFormat("查询教师授课时间异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		
	}

	@Override
	public ApiResult deleteTeacherTimeById(String id) {
		
		logger.info(LogFormatService.logFormat("delete TeacherTime【"+ id +"】 begin"));
		if(StringUtils.isNotBlank(id)){
			return  new ApiResult(EDU_CODE_010.getCode(), EDU_CODE_010.getMsg(), EDU_CODE_010.getShowMsg());
		}
		
		int num = 0;
		try {
			 num = teacherTimeDao.deleteTeacherTimeById(id);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("删除教师授课时间异常：{}"), e);
		    throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		}catch (Exception e) {
			logger.debug(LogFormatService.logFormat("删除教师授课时间异常：{}"), e);
		    throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("delete TeacherTime "+(num > 0?"success":"fail") +"end."));    
		if (num > 0) {
            return new ApiResult(EDU_CODE_007.getCode(), EDU_CODE_007.getMsg(), EDU_CODE_007.getShowMsg());
        }
		return new ApiResult(EDU_CODE_006.getCode(), EDU_CODE_006.getMsg(), EDU_CODE_006.getShowMsg());

	}

	@Override
	public ApiResult insertTeacherTime(TeacherTime teacherTime) {
		logger.info(LogFormatService.logFormat("insert teacherTime begin"));
		int num = 0;
		try {
			num = teacherTimeDao.insertTeacherTime(teacherTime);
			
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("新增教师授课时间异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("新增教师授课时间异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		}
		logger.info("insert teacherTime "+(num > 0?"success":"fail") +"end.");    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_003.getCode(), EDU_CODE_003.getMsg(), EDU_CODE_003.getShowMsg());
        }
		return new ApiResult(EDU_CODE_002.getCode(), EDU_CODE_002.getMsg(), EDU_CODE_002.getShowMsg());
	
	}

	@Override
	public ApiResult updateTeacherTimeById(TeacherTime teacherTime) {
		logger.info(LogFormatService.logFormat("update teacherTime begin"));
		int num = 0;
		try {
			num = teacherTimeDao.updateTeacherTimeById(teacherTime);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("修改教师授课时间异常：{}"), e);
		    throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("修改教师授课时间异常：{}"), e);
			throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("update teacherTime "+(num > 0?"success":"fail") +"end."));    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_005.getCode(), EDU_CODE_005.getMsg(), EDU_CODE_005.getShowMsg());
        }
		return new ApiResult(EDU_CODE_004.getCode(), EDU_CODE_004.getMsg(), EDU_CODE_004.getShowMsg());

	}

	@Override
	public ApiResult queryTeacherTimeById(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("queryTeacherTimeById  begin"));
		TeacherTime teacherTime = null;
		try {
			teacherTime = teacherTimeDao.queryTeacherTimeById(map);
			if(null != teacherTime){
				logger.info(LogFormatService.logFormat(teacherTime.toString()));
				return new ApiResult(EDU_CODE_009.getCode(), EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),teacherTime);
			}
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询教师授课时间异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.info(LogFormatService.logFormat("查询教师授课时间异常：{}"),e);
			 throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		logger.info(LogFormatService.logFormat("queryTeacherTimeById end 查询结果为空"));
		return new ApiResult(EDU_CODE_008.getCode(), EDU_CODE_008.getMsg(), EDU_CODE_008.getShowMsg());

	}
	
}
