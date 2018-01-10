package com.education.framework.authority.management.dao;

import java.util.List;
import java.util.Map;

import com.education.framework.authority.management.model.Management;
/**
 * 
 * <p>ManagementDao.java</p>
 * <p>教育管理后台用户操作</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月10日 下午1:59:24
 * <p>修改者姓名 修改内容说明</p>
 */
public interface ManagementDao {
	List<Management> findAllManagement(Map<String, Object> map);
	int findAllManagementCount(Map<String, Object> map);
	
	int deleteManagement(String id);
	int insertManagement(Management management);
	int updateManagement(Management management);
	int updateManagetByPassword(Management management);
	Management findByManagementCode(String manageCode);
}
