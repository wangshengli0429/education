package com.education.framework.dao.comment.impl;

import java.util.List;
import java.util.Map;

import com.education.framework.model.bo.CommentBo;
import com.education.framework.model.po.Comment;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.comment.CommentDao;


@Repository
public class CommentDaoImpl extends SqlSessionDaoSupport implements CommentDao{

	@Override
	public List<CommentBo> findAllComment(Map<String, Object> map) {
		return this.getSqlSession().selectList("comment.findAllComment", map);
	}

	@Override
	public int findCommentCount(Map<String, Object> map) {
		return 	 this.getSqlSession().selectOne("comment.findCommentCount", map);
	}

	@Override
	public int insertComment(Comment comment) {
		return this.getSqlSession().insert("comment.insertComment",comment);
	}

	@Override
	public CommentBo queryCommentById(Map<String, Object> map) {
		return this.getSqlSession().selectOne("comment.queryCommentById", map);
	}

	@Override
	public int updateCommentStatusById(Map<String, Object> map) {
		return this.getSqlSession().update("comment.updateCommentStatusById", map);
	}
	
}
