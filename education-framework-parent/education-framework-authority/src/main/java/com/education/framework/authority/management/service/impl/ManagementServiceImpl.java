package com.education.framework.authority.management.service.impl;

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

import com.education.framework.authority.management.dao.ManagementDao;
import com.education.framework.authority.management.service.ManagementService;
import com.education.framework.authority.model.Management;
import com.education.framework.common.base.ApiResult;
import com.education.framework.common.exception.BusinessException;
import com.education.framework.common.pagination.Pagination;
import com.education.framework.common.service.LogFormatService;

@Service
@Transactional
public class ManagementServiceImpl implements ManagementService{

	private static Logger logger = Logger.getLogger(ManagementServiceImpl.class);
	
	@Autowired
	ManagementDao managementDao;
	@Override
	public ApiResult findAllManagement(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("findAllManagement begin"));
		Pagination<Management> page = new Pagination<Management>();
	    try {
       	 
            page.setPageNo(Integer.valueOf(map.get("pageNo").toString()));//当前页
            page.setPageCount(Integer.valueOf(map.get("pageCount").toString()));//当前页总条数
            // 设置总数
            page.setItemCount(managementDao.findAllManagementCount(map));
            // 设置用户列表信息
        	page.setItems(managementDao.findAllManagement(map));
        	
            logger.info(LogFormatService.logFormat("分页获取管理员列表success"));
           
			return new ApiResult(EDU_CODE_009.getCode(),EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),page);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询管理员异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("查询管理员异常：{}"), e);
			logger.debug(e.getMessage());
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		
	}

	 

	@Override
	public ApiResult deleteManagement(String id) {
		logger.info(LogFormatService.logFormat("deleteManagement begin"));
		int num = 0;
		try {
			num = managementDao.deleteManagement(id);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("删除管理员异常：{}"), e);
		    throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("删除管理员异常：{}"), e);
			throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("deleteManagement "+(num > 0?"success":"fail") +"end."));    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_007.getCode(), EDU_CODE_007.getMsg(), EDU_CODE_007.getShowMsg());
        }
		return new ApiResult(EDU_CODE_006.getCode(), EDU_CODE_006.getMsg(), EDU_CODE_006.getShowMsg());
	}


	@Override
	public ApiResult insertManagement(Management management) {
		logger.info(LogFormatService.logFormat("insertManagement begin"));
		int num = 0;
		try {
			num = managementDao.insertManagement(management);
			
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("新增管理员异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("新增管理员异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		}
		logger.info("insertManagement "+(num > 0?"success":"fail") +"end.");    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_003.getCode(), EDU_CODE_003.getMsg(), EDU_CODE_003.getShowMsg());
        }
		return new ApiResult(EDU_CODE_002.getCode(), EDU_CODE_002.getMsg(), EDU_CODE_002.getShowMsg());
	
	}

	@Override
	public ApiResult updateManagement(Management management) {
		logger.info(LogFormatService.logFormat("updateManagement begin"));
		int num = 0;
		try {
			num = managementDao.updateManagement(management);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("修改管理员异常：{}"), e);
		    throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("修改管理员异常：{}"), e);
			throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("updateManagement "+(num > 0?"success":"fail") +"end."));    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_005.getCode(), EDU_CODE_005.getMsg(), EDU_CODE_005.getShowMsg());
        }
		return new ApiResult(EDU_CODE_004.getCode(), EDU_CODE_004.getMsg(), EDU_CODE_004.getShowMsg());

	}

	@Override
	public ApiResult updateManagetByPassword(Management management) {
		logger.info(LogFormatService.logFormat("updateManagetByPassword begin"));
		int num = 0;
		try {
			num = managementDao.updateManagetByPassword(management);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("修改管理员密码异常：{}"), e);
		    throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("修改管理员密码异常：{}"), e);
			throw new BusinessException(EDU_CODE_004, EDU_CODE_004.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("updateManagetByPassword "+(num > 0?"success":"fail") +"end."));    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_005.getCode(), EDU_CODE_005.getMsg(), EDU_CODE_005.getShowMsg());
        }
		return new ApiResult(EDU_CODE_004.getCode(), EDU_CODE_004.getMsg(), EDU_CODE_004.getShowMsg());

	}

	@Override
	public ApiResult findByManagementCode(String manageCode) {
		logger.info(LogFormatService.logFormat("findByManagementCode  begin"));
		if(StringUtils.isNotBlank(manageCode)){
			return 	new ApiResult(EDU_CODE_010.getCode(), EDU_CODE_010.getMsg(), EDU_CODE_010.getShowMsg());
			
		}
		Management management = null;
		try {
			management = managementDao.findByManagementCode(manageCode);
			if(null != management){
				logger.info(LogFormatService.logFormat(management.toString()));
				return new ApiResult(EDU_CODE_009.getCode(), EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),management);
			}
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询管理员异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.info(LogFormatService.logFormat("查询管理员异常：{}"),e);
			 throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		logger.info(LogFormatService.logFormat("findByManagementCode end 查询结果为空"));
		return new ApiResult(EDU_CODE_008.getCode(), EDU_CODE_008.getMsg(), EDU_CODE_008.getShowMsg());
	}

}
