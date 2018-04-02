package com.education.framework.repo;

import com.education.framework.model.bo.CommentBo;
import com.education.framework.model.co.CommentCo;
import com.education.framework.model.po.Comment;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class CommentRepo extends BaseDao<Comment,CommentCo,CommentBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
