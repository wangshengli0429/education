package com.education.controller.note;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.note.Note;
import com.education.framework.service.note.NoteService;
import com.google.common.collect.Maps;

@Controller
public class NoteController {
	
	private static Logger logger = Logger.getLogger(NoteController.class);
	
	@Autowired
	private NoteService noteService;
	
	@RequestMapping(value={"rest/query/note","query/note"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult queryAllNote(Note note, @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int rows){
		logger.info("controller queryAllNote begin ");
		 
		Map<String, Object> map = Maps.newHashMap();
		map.put("id", note.getId());
		
		// 设置检索开始条数
		map.put("pageNo", (page - 1) * rows);
//      // 设置检索截止条数
		map.put("pageCount", rows);
		
		return  noteService.findAllNote(map);
	}
	
	@RequestMapping(value={"rest/query/note/{id}","query/note/{id}"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult queryNoteById(@PathVariable String id){
		logger.info("controller queryAllNote begin ");
		
		Map<String, Object> map = Maps.newHashMap();
		map.put("id",id);
		return noteService.queryNoteById(map);
	}
	
	
	@RequestMapping(value={"rest/note/insert","note/insert"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult insertNote(@RequestParam Note note){
		logger.info("controller insertNote ");
		return noteService.insertNote(note);
	}
	
	 
	
	@RequestMapping(value={"rest/note/delete","note/delete"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult deleteNote(@RequestParam String id){
		logger.info("controller deleteNote ");
		return noteService.deleteNoteById(id);
	}
	
}
