package com.education.framework.service.comment;

import java.util.Map;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.comment.Comment;

public interface CommentService {
	ApiResult findAllComment(Map<String, Object> map);
	ApiResult updateCommentStatusById(Map<String, Object> map); 
	ApiResult insertComment(Comment comment);
	ApiResult queryCommentById(Map<String, Object> map);
}
