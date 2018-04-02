package com.education.framework.repo;

import com.education.framework.model.bo.NoteBo;
import com.education.framework.model.co.NoteCo;
import com.education.framework.model.po.Note;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class NoteRepo extends BaseDao<Note,NoteCo,NoteBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
