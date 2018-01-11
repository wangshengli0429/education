package com.education.framework.note.impl;

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
import com.education.framework.common.exception.BusinessException;
import com.education.framework.common.pagination.Pagination;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.dao.note.NoteDao;
import com.education.framework.model.note.Note;
import com.education.framework.service.note.NoteService;
@Service
@Transactional
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	NoteDao noteDao;
	 
	private static Logger logger = Logger.getLogger(NoteServiceImpl.class);
	@Override
	public ApiResult findAllNote(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("findAllNote begin"));
		Pagination<Note> page = new Pagination<Note>();
		
        try {
        	 
            page.setPageNo(Integer.valueOf(map.get("pageNo").toString()));//当前页
            page.setPageCount(Integer.valueOf(map.get("pageCount").toString()));//当前页总条数
            // 设置总数
            page.setItemCount(noteDao.findNoteCount(map));
            // 设置用户列表信息
        	page.setItems(noteDao.findAllNote(map));
        	
            logger.info(LogFormatService.logFormat("分页获取留言列表success"));
           
			return new ApiResult(EDU_CODE_009.getCode(),EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),page);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询留言异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("查询留言异常：{}"), e);
			logger.debug(e.getMessage());
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		
	}

	@Override
	public ApiResult deleteNoteById(String id) {
		logger.info(LogFormatService.logFormat("delete note【"+ id +"】 begin"));
		if(StringUtils.isNotBlank(id)){
			return  new ApiResult(EDU_CODE_010.getCode(), EDU_CODE_010.getMsg(), EDU_CODE_010.getShowMsg());
		}
		int num = 0;
		try {
			 num = noteDao.deleteNoteById(id);
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("删除留言异常：{}"), e);
		    throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		}catch (Exception e) {
			logger.debug(LogFormatService.logFormat("删除留言异常：{}"), e);
		    throw new BusinessException(EDU_CODE_006, EDU_CODE_006.getMsg());
		}
		
		logger.info(LogFormatService.logFormat("delete note "+(num > 0?"success":"fail") +"end."));    
		if (num > 0) {
            return new ApiResult(EDU_CODE_007.getCode(), EDU_CODE_007.getMsg(), EDU_CODE_007.getShowMsg());
        }
		return new ApiResult(EDU_CODE_006.getCode(), EDU_CODE_006.getMsg(), EDU_CODE_006.getShowMsg());
	
	}

	@Override
	public ApiResult insertNote(Note note) {
		logger.info(LogFormatService.logFormat("insert note begin"));
		int num = 0;
		try {
			num = noteDao.insertNote(note);
			
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("新增留言异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		} catch (Exception e) {
			logger.debug(LogFormatService.logFormat("新增留言异常：{}"), e);
		    throw new BusinessException(EDU_CODE_002, EDU_CODE_002.getMsg());
		}
		logger.info("insert student "+(num > 0?"success":"fail") +"end.");    
	       
		if (num > 0) {
            return new ApiResult(EDU_CODE_003.getCode(), EDU_CODE_003.getMsg(), EDU_CODE_003.getShowMsg());
        }
		return new ApiResult(EDU_CODE_002.getCode(), EDU_CODE_002.getMsg(), EDU_CODE_002.getShowMsg());
	
	}

	@Override
	public ApiResult queryNoteById(Map<String, Object> map) {
		logger.info(LogFormatService.logFormat("queryNoteById  begin"));
		Note note = null;
		try {
			note = noteDao.queryNoteById(map);
			if(null != note){
				logger.info(LogFormatService.logFormat(note.toString()));
				return new ApiResult(EDU_CODE_009.getCode(), EDU_CODE_009.getMsg(),EDU_CODE_009.getShowMsg(),note);
			}
		} catch (BusinessException e) {
			logger.debug(LogFormatService.logFormat("查询留言异常：{}"), e);
		    throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		} catch (Exception e) {
			logger.info(LogFormatService.logFormat("查询留言异常：{}"),e);
			 throw new BusinessException(EDU_CODE_008, EDU_CODE_008.getMsg());
		}
		logger.info(LogFormatService.logFormat("queryNoteById end 查询结果为空"));
		return new ApiResult(EDU_CODE_008.getCode(), EDU_CODE_008.getMsg(), EDU_CODE_008.getShowMsg());
	
	}
	
}
