package com.education.framework.repo;

import com.education.framework.model.bo.BindAccountBo;
import com.education.framework.model.co.BindAccountCo;
import com.education.framework.model.po.BindAccount;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class BindAccountRepo extends BaseDao<BindAccount,BindAccountCo,BindAccountBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
