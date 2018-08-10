package com.education.controller.teacher;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.TeacherSubjectBo;
import com.education.framework.model.po.TeacherSubject;
import com.education.framework.service.TeacherSubjectApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/6.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/6.
 * @note
 */
@Controller
@RequestMapping("/teacherSubject")
public class TeacherSubjectController {

    @Autowired
    private TeacherSubjectApi teacherSubjectApi;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(@RequestBody TeacherSubjectBo teacherSubjectBo){
        if (null==teacherSubjectBo){return ResultData.failed("teacherSubjectBo不能为空!");}
        ApiResponse<Integer> apiResponse = teacherSubjectApi.save(teacherSubjectBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @ResponseBody
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResultData getById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        ApiResponse<TeacherSubjectBo> apiResponse = teacherSubjectApi.getById(id);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResultData updateById(@RequestBody TeacherSubjectBo teacherSubjectBo){
        if (null==teacherSubjectBo){return ResultData.failed("teacherSubjectBo不能为空!");}
        ApiResponse<Integer> apiResponse = teacherSubjectApi.updateById(teacherSubjectBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResultData deleteById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        ApiResponse<Integer> apiResponse = teacherSubjectApi.deleteById(id,-1);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }


    @ResponseBody
    @RequestMapping(value = "/teacherId",method = RequestMethod.GET)
    public ResultData getByTeacherId(@RequestParam Integer teacherId){
        if (null==teacherId){return ResultData.failed("teacherId不能为空!");}
        TeacherSubject teacherSubject = new TeacherSubject();
        teacherSubject.setTeacherId(teacherId);
        ApiResponse<List<TeacherSubjectBo>> apiResponse = teacherSubjectApi.getListByCondition(teacherSubject);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }



}
