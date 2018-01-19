package com.education.controller.comment;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.education.framework.common.base.WebResult;
import com.education.framework.service.comment.CommentService;
import com.google.common.collect.Maps;


/**
 * 
 * <p>CommentController.java</p>
 * <p>评论</p>
 * <p>Company:</p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月11日 下午7:03:33
 * <p>修改者姓名 修改内容说明</p>
 */
@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	/** Log */
	private static Logger logger = Logger.getLogger(CommentController.class);
	
	@RequestMapping(value={"rest/comment/toGetAllComment","comment/toGetAllComment"},method={RequestMethod.GET,RequestMethod.POST})
	public String toGetAllComment() {
		return "manager/comment/comment-list";
	}
	
	/**
	 * <p>评论查询</p>
	 * 
	 * @author wangqiang
	 * @param keyword    检索关键字
	 * @param page       页码
	 * @param limit      每页显示数
	 * @return
	 */
	@RequestMapping(value={"rest/comment/getAllComment","comment/getAllComment"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public WebResult getAllComment(@RequestParam(required=false) String keyword, @RequestParam Integer page, @RequestParam Integer limit) {
		logger.info("controller comment begin");
		Map<String,Object> map = Maps.newHashMap();
		// 检索条件
		map.put("keyword", keyword);
		map.put("rowStart", page-1);
		map.put("pageSize",limit);
		WebResult webResult = commentService.findAllComment(map);
		System.out.println(webResult);
		return webResult;
	}
	

}
