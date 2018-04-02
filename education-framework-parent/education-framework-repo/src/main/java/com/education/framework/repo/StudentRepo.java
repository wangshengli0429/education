package com.education.framework.repo;

import com.education.framework.model.bo.StudentBo;
import com.education.framework.model.co.StudentCo;
import com.education.framework.model.po.Student;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class StudentRepo extends BaseDao<Student,StudentCo,StudentBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
