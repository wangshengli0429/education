package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.CommentBo;
import com.education.framework.model.co.CommentCo;
import com.education.framework.model.po.Comment;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface CommentApi {

    /**
     * 保存
     * @param commentBo
     * @return
     */
    ApiResponse<Integer> save(CommentBo commentBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Comment> list);

    /**
     * 根据id修改
     * @param commentBo
     * @return
     */
    ApiResponse<Integer> updateById(CommentBo commentBo);

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
    ApiResponse<CommentBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<CommentBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param comment
     * @return
     */
    ApiResponse<Integer> countByCondition(Comment comment);

    /**
     * 根据条件查询
     * @param comment
     * @return
     */
    public ApiResponse<List<CommentBo>> getListByCondition(Comment comment);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<CommentBo>> getPageByCondition(CommentCo condition, PageParam pageParam);

}
