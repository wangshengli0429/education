package com.education.framework.repo;

import com.education.framework.model.bo.CommentBo;
import com.education.framework.model.co.CommentCo;
import com.education.framework.model.po.Comment;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class CommentRepo extends BaseDao<Comment,CommentCo,CommentBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

    public List<CommentBo> listByTeacherIds(List<Integer> teacherIds) {
        if (CollectionUtils.isEmpty(teacherIds)){
            return new ArrayList<CommentBo>();
        }
        StringBuilder sql = new StringBuilder(" SELECT c.id,c.teacher_id,AVG(DISTINCT c.comment_value) as commentValue FROM `comment` c ");
        sql.append(" where c.teacher_id in(");
        sql.append(StringUtils.join(teacherIds,","));
        sql.append(") ");
        sql.append(" GROUP BY c.teacher_id ");
        return mysqlClient.query(sql.toString(), new Object[]{}, new BeanPropertyRowMapper<>(CommentBo.class));
    }

}
