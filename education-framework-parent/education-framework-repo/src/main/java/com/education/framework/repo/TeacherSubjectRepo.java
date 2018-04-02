package com.education.framework.repo;

import com.education.framework.model.bo.TeacherSubjectBo;
import com.education.framework.model.co.TeacherSubjectCo;
import com.education.framework.model.po.TeacherSubject;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class TeacherSubjectRepo extends BaseDao<TeacherSubject,TeacherSubjectCo,TeacherSubjectBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
