package com.education.controller.teacher;

import java.util.List;
import java.util.Map;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.bo.TeacherTimeBo;
import com.education.framework.model.co.TeacherTimeCo;
import com.education.framework.model.constant.TeacherTimeEnum;
import com.education.framework.model.po.TeacherTime;
import com.education.framework.service.TeacherTimeApi;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.education.framework.common.base.ApiResult;
import com.google.common.collect.Maps;
@Controller
@RequestMapping("/teacherTime")
public class TeacherTimeController {

    @Autowired
    private TeacherTimeApi teacherTimeApi;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(@RequestBody TeacherTimeBo teacherTimeBo){
        if (null==teacherTimeBo){return ResultData.failed("teacherTimeBo不能为空!");}
        ApiResponse<Integer> apiResponse =teacherTimeApi.save(teacherTimeBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResultData updateById(@RequestBody TeacherTimeBo teacherTimeBo){
        if (null==teacherTimeBo){return ResultData.failed("teacherTimeBo不能为空!");}
        if (teacherTimeBo.getTimeStatus().equals(TeacherTimeEnum.timeStatus.no.getValue())){
            return ResultData.failed("已预约的授课时间不可修改");
        }
        ApiResponse<Integer> apiResponse = teacherTimeApi.updateById(teacherTimeBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResultData deleteById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        TeacherTimeBo teacherTimeBo = teacherTimeApi.getById(id).getBody();
        if (teacherTimeBo.getTimeStatus().equals(TeacherTimeEnum.timeStatus.no.getValue())){
            return ResultData.failed("已预约的授课时间不可删除");
        }
        ApiResponse<Integer> apiResponse = teacherTimeApi.deleteById(id,-1);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }


    @ResponseBody
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResultData getById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        ApiResponse<TeacherTimeBo> apiResponse = teacherTimeApi.getById(id);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @ResponseBody
    @RequestMapping(value = "/listByTeacherAndDate",method = RequestMethod.GET)
    public ResultData listByTeacherAndDate(TeacherTimeCo teacherTimeCo){
        if (null==teacherTimeCo){return ResultData.failed("teacherTimeCo不能为空!");}
        ApiResponse<List<TeacherTimeBo>> apiResponse = teacherTimeApi.listByTeacherAndDate(teacherTimeCo.getTeacherId(),teacherTimeCo.getDateStr());
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }



}
