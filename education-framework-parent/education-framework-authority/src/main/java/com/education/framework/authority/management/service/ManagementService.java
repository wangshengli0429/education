package com.education.framework.authority.management.service;

import java.util.Map;

import com.education.framework.authority.management.model.Management;
import com.education.framework.common.base.ApiResult;

public interface ManagementService {
	ApiResult findAllManagement(Map<String, Object> map);
	
	ApiResult deleteManagement(String id);
	ApiResult insertManagement(Management management);
	ApiResult updateManagement(Management management);
	ApiResult updateManagetByPassword(Management management);
	ApiResult findByManagementCode(String manageCode);
}
