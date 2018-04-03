package com.education.framework.repo;

import com.education.framework.model.bo.TeacherTimeBo;
import com.education.framework.model.co.TeacherTimeCo;
import com.education.framework.model.po.TeacherTime;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class TeacherTimeRepo extends BaseDao<TeacherTime,TeacherTimeCo,TeacherTimeBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
