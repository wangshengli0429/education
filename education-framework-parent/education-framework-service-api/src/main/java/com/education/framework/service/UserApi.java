package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.UserBo;
import com.education.framework.model.co.UserCo;
import com.education.framework.model.po.User;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface UserApi {

    /**
     * 保存
     * @param userBo
     * @return
     */
    ApiResponse<Integer> save(UserBo userBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<User> list);

    /**
     * 根据id修改
     * @param userBo
     * @return
     */
    ApiResponse<Integer> updateById(UserBo userBo);

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
    ApiResponse<UserBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<UserBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param user
     * @return
     */
    ApiResponse<Integer> countByCondition(User user);

    /**
     * 根据条件查询
     * @param user
     * @return
     */
    public ApiResponse<List<UserBo>> getListByCondition(User user);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<UserBo>> getPageByCondition(UserCo condition, PageParam pageParam);

}
