package com.education.framework.comment.impl;

import static com.education.framework.common.base.StatusCode.EDU_CODE_000;
import static com.education.framework.common.base.StatusCode.EDU_CODE_002;
import static com.education.framework.common.base.StatusCode.EDU_CODE_003;
import static com.education.framework.common.base.StatusCode.EDU_CODE_006;
import static com.education.framework.common.base.StatusCode.EDU_CODE_007;
import static com.education.framework.common.base.StatusCode.EDU_CODE_008;
import static com.education.framework.common.base.StatusCode.EDU_CODE_009;
import static com.education.framework.common.base.StatusCode.EDU_CODE_010;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.common.base.ApiResult;
import com.education.framework.common.base.WebResult;
import com.education.framework.common.exception.BusinessException;
import com.education.framework.common.pagination.Pagination;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.dao.comment.CommentDao;
import com.education.framework.model.comment.Comment;
import com.education.framework.model.comment.vo.CommentVo;
import com.education.framework.note.impl.NoteServiceImpl;
import com.education.framework.service.comment.CommentService;
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	 
	private static Logger logger = Logger.getLogger(NoteServiceImpl.class);
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public WebResult findAllComment(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("findAllComment begin"));
		try {
		    logger.info(LogFormatService.logFormat("分页获取评论列表success"));
		    WebResult webResult = new WebResult(EDU_CODE_000.getCode(),EDU_CODE_000.getMsg());
		    webResult.setCount(commentDao.findCommentCount(map));
		    webResult.setData(commentDao.findAllComment(map));
			return webResult;
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询评论异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(LogFormatService.logFormat("查询评论异常：{}"), e);
			logger.debug(e.getMessage());
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
	}

 

	@Override
	public ApiResult deleteCommentById(String id) {
		logger.info(LogFormatService.logFormat("delete comment【"+ id +"】 begin"));
		if(StringUtils.isNotBlank(id)){
			return  new ApiResult(EDU_CODE_010.getCode(), EDU_CODE_010.getMsg(), EDU_CODE_010.getShowMsg());
		}
		int num = 0;
		try {
			 num = commentDao.deleteCommentById(id);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("删除评论异常：{}"), e);
		    throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		}catch (Exception e) {
			logger.debug(LogFormatService.logFormat("删除评论异常：{}"), e);
		    throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("delete comment "+(num > 0?"success":"fail") +"end."));    
		if (num > 0) {
            return new ApiResult(EDU_CODE_007.getCode(), EDU_CODE_007.getMsg(), EDU_CODE_007.getShowMsg());
        }
		return new ApiResult(EDU_CODE_006.getCode(), EDU_CODE_006.getMsg(), EDU_CODE_006.getShowMsg());
	
	}

	@Override
	public ApiResult insertComment(Comment comment) {
		logger.info(LogFormatService.logFormat("insert comment begin"));
		int num = 0;
		try {
			num = commentDao.insertComment(comment);
			
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("新增评论异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("新增评论异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		}
		logger.info("insert comment "+(num > 0?"success":"fail") +"end.");    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_003.getCode(), EDU_CODE_003.getMsg(), EDU_CODE_003.getShowMsg());
        }
		return new ApiResult(EDU_CODE_002.getCode(), EDU_CODE_002.getMsg(), EDU_CODE_002.getShowMsg());
	
	}

	@Override
	public ApiResult queryCommentById(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("queryNoteById  begin"));
		CommentVo commentVo = null;
		try {
			commentVo = commentDao.queryCommentById(map);
			if(null != commentVo){
				logger.info(LogFormatService.logFormat(commentVo.toString()));
				return new ApiResult(EDU_CODE_009.getCode(), EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),commentVo);
			}
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询评论异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.info(LogFormatService.logFormat("查询评论异常：{}"),e);
			 throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		logger.info(LogFormatService.logFormat("queryNoteById end 查询结果为空"));
		return new ApiResult(EDU_CODE_008.getCode(), EDU_CODE_008.getMsg(), EDU_CODE_008.getShowMsg());
	}
	
}
