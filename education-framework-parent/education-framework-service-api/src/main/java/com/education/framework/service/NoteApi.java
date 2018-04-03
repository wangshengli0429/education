package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.NoteBo;
import com.education.framework.model.co.NoteCo;
import com.education.framework.model.po.Note;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface NoteApi {

    /**
     * 保存
     * @param note
     * @return
     */
    ApiResponse<Integer> save(Note note);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Note> list);

    /**
     * 根据id修改
     * @param note
     * @return
     */
    ApiResponse<Integer> updateById(Note note);

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
    ApiResponse<NoteBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<NoteBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param note
     * @return
     */
    ApiResponse<Integer> countByCondition(Note note);

    /**
     * 根据条件查询
     * @param note
     * @return
     */
    public ApiResponse<List<NoteBo>> getListByCondition(Note note);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<NoteBo>> getPageByCondition(NoteCo condition, PageParam pageParam);

}
