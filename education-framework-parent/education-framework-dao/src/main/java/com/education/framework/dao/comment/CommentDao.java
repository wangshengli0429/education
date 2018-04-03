package com.education.framework.dao.comment;

import com.education.framework.model.bo.CommentBo;
import com.education.framework.model.po.Comment;

import java.util.List;
import java.util.Map;


public interface CommentDao {
	List<CommentBo> findAllComment(Map<String, Object> map);
	int findCommentCount(Map<String, Object> map);
	int updateCommentStatusById(Map<String, Object> map);
	int insertComment(Comment comment);
	CommentBo queryCommentById(Map<String, Object> map);
}
