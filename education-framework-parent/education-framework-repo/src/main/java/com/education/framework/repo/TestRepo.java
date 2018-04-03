package com.education.framework.repo;

import com.education.framework.repo.base.BaseDao;
import com.education.framework.model.Test;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/3/30.
 */
@Repository
public class TestRepo extends BaseDao<Test,Test,Test>{

    @Resource
    private CommonMysqlClient mysqlClient;

}