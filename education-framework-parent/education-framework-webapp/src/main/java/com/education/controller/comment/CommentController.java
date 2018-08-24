package com.education.controller.comment;

import java.util.List;
import java.util.Map;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.CommentBo;
import com.education.framework.model.bo.StudentBo;
import com.education.framework.model.co.CommentCo;
import com.education.framework.model.constant.CommentEnum;
import com.education.framework.service.CommentApi;
import com.education.framework.service.StudentApi;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.education.framework.common.base.ApiResult;
import com.education.framework.common.util.Const;
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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentApi commentApi;

    @Autowired
    private StudentApi studentApi;

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultData list(CommentCo commentCo){
        if (null==commentCo){return ResultData.failed("commentCo不能为空!");}
        PageParam pageParam = new PageParam();
        pageParam.setPageNum(commentCo.getPageNum());
        pageParam.setPageSize(commentCo.getPageSize());
        pageParam.setOrderBy(" update_time desc,id desc ");
        commentCo.setStatus(CommentEnum.status.status_true.getValue());
        ApiResponse<Page<CommentBo>> apiResponse = commentApi.getPageByCondition(commentCo,pageParam);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        if (null!=apiResponse.getBody() && CollectionUtils.isNotEmpty(apiResponse.getBody().getList())){
            List<Integer> studentIds = Lists.newArrayList();
            for (CommentBo commentBo : apiResponse.getBody().getList()) {
                studentIds.add(commentBo.getStudentId());
            }
            if (CollectionUtils.isNotEmpty(studentIds)){
                List<StudentBo> studentBos = studentApi.getListByIds(studentIds).getBody();
                for (CommentBo commentBo : apiResponse.getBody().getList()) {
                    for (StudentBo studentBo:studentBos){
                        if (commentBo.getStudentId().equals(studentBo.getId())){
                            commentBo.setStudentName(studentBo.getSurname()+"同学");
                            break;
                        }
                    }
                }

            }
        }
        return ResultData.successed(apiResponse.getBody());
    }

}
