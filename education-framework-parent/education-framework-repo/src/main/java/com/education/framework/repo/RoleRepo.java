package com.education.framework.repo;

import com.education.framework.model.bo.RoleBo;
import com.education.framework.model.co.RoleCo;
import com.education.framework.model.po.Role;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class RoleRepo extends BaseDao<Role,RoleCo,RoleBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
