package com.education.controller.dictionary;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.DictionaryBo;
import com.education.framework.service.DictionaryApi;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/4.
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Resource
    private DictionaryApi dictionaryApi;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(@RequestBody DictionaryBo dictionaryBo){
        if (null==dictionaryBo){return ResultData.failed("dictionaryBo不能为空!");}
        ApiResponse<Integer> apiResponse = dictionaryApi.save(dictionaryBo);
        return ApiRetCode.SUCCESS_CODE == apiResponse.getRetCode()?ResultData.successed(apiResponse.getMessage(),apiResponse.getBody()):ResultData.failed(apiResponse.getMessage());
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResultData getById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        ApiResponse<DictionaryBo> apiResponse = dictionaryApi.getById(id);
        return ApiRetCode.SUCCESS_CODE == apiResponse.getRetCode()?ResultData.successed(apiResponse.getMessage(),apiResponse.getBody()):ResultData.failed(apiResponse.getMessage());
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResultData updateById(@RequestBody DictionaryBo dictionaryBo){
        if (null==dictionaryBo){return ResultData.failed("dictionaryBo不能为空!");}
        ApiResponse<Integer> apiResponse = dictionaryApi.updateById(dictionaryBo);
        return ApiRetCode.SUCCESS_CODE == apiResponse.getRetCode()?ResultData.successed(apiResponse.getMessage(),apiResponse.getBody()):ResultData.failed(apiResponse.getMessage());
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResultData deleteById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        ApiResponse<Integer> apiResponse = dictionaryApi.deleteById(id,-1);
        return ApiRetCode.SUCCESS_CODE == apiResponse.getRetCode()?ResultData.successed(apiResponse.getMessage(),apiResponse.getBody()):ResultData.failed(apiResponse.getMessage());
    }

}
