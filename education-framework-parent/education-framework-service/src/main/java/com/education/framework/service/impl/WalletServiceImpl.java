package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.WalletBo;
import com.education.framework.model.co.WalletCo;
import com.education.framework.model.po.Wallet;
import com.education.framework.repo.WalletRepo;
import com.education.framework.service.WalletApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
@Service
public class WalletServiceImpl implements WalletApi{

    @Resource
    private WalletRepo walletRepo;

    @Override
    public ApiResponse<Integer> save(WalletBo walletBo) {
        if (null==walletBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"wallet不能为空!");}
        int result = walletRepo.save(walletBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Wallet> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = walletRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(WalletBo walletBo) {
        if (null==walletBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"walletBo不能为空!");}
        if (null==walletBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"walletBo.getId()不能为空!");}
        int result = walletRepo.updateById(walletBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = walletRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<WalletBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        WalletBo walletBo = walletRepo.getById(id);
        return ApiResponse.success(walletBo,"查询成功");
    }

    @Override
    public ApiResponse<List<WalletBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<WalletBo> walletBoList = walletRepo.getListByIds(ids);
        return ApiResponse.success(walletBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Wallet wallet) {
        if (null==wallet){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"wallet不能为空!");}
        int count = walletRepo.countByCondition(wallet);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<WalletBo>> getListByCondition(Wallet wallet) {
        if (null==wallet){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"wallet不能为空!");}
        List<WalletBo> result = walletRepo.getListByCondition(wallet);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<WalletBo>> getPageByCondition(WalletCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<WalletBo> result = walletRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

}
