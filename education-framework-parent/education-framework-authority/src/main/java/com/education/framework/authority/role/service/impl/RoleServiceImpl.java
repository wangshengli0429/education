package com.education.framework.authority.role.service.impl;

import static com.education.framework.common.base.StatusCode.EDU_CODE_000;
import static com.education.framework.common.base.StatusCode.EDU_CODE_008;
import static com.education.framework.common.base.StatusCode.EDU_CODE_009;
import static com.education.framework.common.base.StatusCode.EDU_CODE_010;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.authority.role.dao.RoleDao;
import com.education.framework.authority.role.model.Role;
import com.education.framework.authority.role.service.RoleService;
import com.education.framework.common.base.ApiResult;
import com.education.framework.common.exception.BusinessException;
import com.education.framework.common.pagination.Pagination;
import com.education.framework.common.service.LogFormatService;
import com.google.common.collect.Lists;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	private static Logger logger = Logger.getLogger(RoleServiceImpl.class);
	
	@Autowired
	RoleDao roleDao;
	
	
	 @Override
	 public List<String> getRole(String manageCode) {
	        List<String> roleList = Lists.newArrayList();
	        logger.info(LogFormatService.logogram("用户ID获取用所拥有的角色字符串start..."));
	        List<Role> list =  roleDao.getRoleByManagementCode(manageCode);
	        if (CollectionUtils.isNotEmpty(list)) {
	            for (Role role : list) {
	                roleList.add(role.getRoleCode());
	            }
	        }
	        logger.info(LogFormatService.logogram("用户ID获取用所拥有的角色字符串:" + list.toString()));
	        logger.info(LogFormatService.logFormat("用户ID获取用所拥有的角色字符串end...", RoleServiceImpl.class.toString()
	                + ":getRole"));
	        return roleList;
	    }
	
	@Override
	public ApiResult findAllRole(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("findAllRole begin"));
		//Pagination<Role> page = new Pagination<Role>();
	    try {
	    	 logger.info(LogFormatService.logFormat("分页获取角色列表success"));
            //page.setPageNo(Integer.valueOf(map.get("rowStart").toString()));//当前页
            //page.setPageCount(Integer.valueOf(map.get("pageSize").toString()));//当前页总条数
            // 设置总数
            //page.setItemCount(roleDao.findRoleCount(map));
            // 设置用户列表信息
        	//page.setItems(roleDao.findAllRole(map));
        	ApiResult apiResult = new ApiResult(EDU_CODE_000.getCode(),EDU_CODE_000.getMsg());
        	 // 设置数据总数
		    apiResult.setCount(roleDao.findRoleCount(map));
		    // 设置数据
		    apiResult.setData(roleDao.findAllRole(map));
        	
            return apiResult;
			//return new ApiResult(EDU_CODE_009.getCode(),EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),page);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询角色异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("查询角色异常：{}"), e);
			logger.debug(e.getMessage());
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
	}

	@Override
	public ApiResult getRoleById(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("getRoleById  begin"));
		if(null != map){
			return 	new ApiResult(EDU_CODE_010.getCode(), EDU_CODE_010.getMsg(), EDU_CODE_010.getShowMsg());
		} 
		Role role = null;
		try {
				role = roleDao.getRoleById(map);
	          
				if(null != role){
					logger.info(LogFormatService.logFormat(role.toString()));
					return new ApiResult(EDU_CODE_009.getCode(), EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),role);
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

	@Override
	public ApiResult insertRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResult updateRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResult deleteRole(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
