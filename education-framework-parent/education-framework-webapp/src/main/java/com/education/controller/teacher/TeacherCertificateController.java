package com.education.controller.teacher;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.TeacherCertificateBo;
import com.education.framework.model.po.TeacherCertificate;
import com.education.framework.service.TeacherCertificateApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/5.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/5.
 * @note
 */
@Controller
@RequestMapping("/teacherCertificate")
public class TeacherCertificateController {

    @Resource
    private TeacherCertificateApi teacherCertificateApi;


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(@RequestBody TeacherCertificateBo teacherCertificateBo){
        if (null==teacherCertificateBo){return ResultData.failed("teacherCertificateBo不能为空!");}
        ApiResponse<Integer> apiResponse = teacherCertificateApi.save(teacherCertificateBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @ResponseBody
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResultData getById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        ApiResponse<TeacherCertificateBo> apiResponse = teacherCertificateApi.getById(id);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResultData updateById(@RequestBody TeacherCertificateBo teacherCertificateBo){
        if (null==teacherCertificateBo){return ResultData.failed("teacherCertificateBo不能为空!");}
        ApiResponse<Integer> apiResponse = teacherCertificateApi.updateById(teacherCertificateBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResultData deleteById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        ApiResponse<Integer> apiResponse = teacherCertificateApi.deleteById(id,-1);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }


    @ResponseBody
    @RequestMapping(value = "/teacherId",method = RequestMethod.GET)
    public ResultData getByTeacherId(@RequestParam Integer teacherId){
        if (null==teacherId){return ResultData.failed("teacherId不能为空!");}
        TeacherCertificate teacherCertificate = new TeacherCertificate();
        teacherCertificate.setTeacherId(teacherId);
        ApiResponse<List<TeacherCertificateBo>> apiResponse = teacherCertificateApi.getListByCondition(teacherCertificate);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

}
