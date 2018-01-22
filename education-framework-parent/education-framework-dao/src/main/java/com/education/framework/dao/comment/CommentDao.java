package com.education.framework.dao.comment;

import java.util.List;
import java.util.Map;

import com.education.framework.model.comment.Comment;
import com.education.framework.model.comment.vo.CommentVo;

public interface CommentDao {
	List<CommentVo> findAllComment(Map<String, Object> map);
	int findCommentCount(Map<String, Object> map);
	int updateCommentStatusById(Map<String, Object> map);
	int insertComment(Comment comment);
	CommentVo queryCommentById(Map<String, Object> map);
}
