package com.education.framework.repo;

import com.education.framework.model.bo.ManageBo;
import com.education.framework.model.co.ManageCo;
import com.education.framework.model.po.Manage;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class ManageRepo extends BaseDao<Manage,ManageCo,ManageBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
