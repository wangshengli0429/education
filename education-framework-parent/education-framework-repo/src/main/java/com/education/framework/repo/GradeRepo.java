package com.education.framework.repo;

import com.education.framework.model.bo.GradeBo;
import com.education.framework.model.co.GradeCo;
import com.education.framework.model.po.Grade;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class GradeRepo extends BaseDao<Grade,GradeCo,GradeBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}