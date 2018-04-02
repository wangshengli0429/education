package com.education.framework.repo;

import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.TeacherCo;
import com.education.framework.model.po.Teacher;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class TeacherRepo extends BaseDao<Teacher,TeacherCo,TeacherBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
