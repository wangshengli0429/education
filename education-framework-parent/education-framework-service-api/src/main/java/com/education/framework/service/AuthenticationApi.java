package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.AuthenticationBo;
import com.education.framework.model.co.AuthenticationCo;
import com.education.framework.model.po.Authentication;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
public interface AuthenticationApi {

    /**
     * 保存
     * @param authenticationBo
     * @return
     */
    ApiResponse<Integer> save(AuthenticationBo authenticationBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Authentication> list);

    /**
     * 根据id修改
     * @param authenticationBo
     * @return
     */
    ApiResponse<Integer> updateById(AuthenticationBo authenticationBo);

    /**
     * 逻辑删除
     * @param id
     * @param operatorId 操作人
     * @return
     */
    ApiResponse<Integer> deleteById(Integer id,Integer operatorId);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ApiResponse<AuthenticationBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<AuthenticationBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param authentication
     * @return
     */
    ApiResponse<Integer> countByCondition(Authentication authentication);

    /**
     * 根据条件查询
     * @param authentication
     * @return
     */
    public ApiResponse<List<AuthenticationBo>> getListByCondition(Authentication authentication);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<AuthenticationBo>> getPageByCondition(AuthenticationCo condition, PageParam pageParam);

}
