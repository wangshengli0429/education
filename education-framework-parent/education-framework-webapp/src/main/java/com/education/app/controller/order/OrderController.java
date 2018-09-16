package com.education.app.controller.order;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.common.util.AgeUtils;
import com.education.framework.common.util.BaseMapper;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.*;
import com.education.framework.model.co.OrderCo;
import com.education.framework.model.constant.CommentEnum;
import com.education.framework.model.constant.OrderEnum;
import com.education.framework.model.constant.TeacherEnum;
import com.education.framework.model.po.Comment;
import com.education.framework.model.po.TeacherTime;
import com.education.framework.model.vo.OrderVo;
import com.education.framework.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/5.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/5.
 * @note
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderApi orderApi;

    @Autowired
    private TeacherApi teacherApi;

    @Autowired
    private StudentApi studentApi;

    @Autowired
    private TeacherSubjectApi teacherSubjectApi;

    @Autowired
    private TeacherTimeApi teacherTimeApi;
    @Autowired
    private CommentApi commentApi;

    @Autowired
    private BaseMapper baseMapper;



    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(OrderBo orderBo){
        if (null==orderBo){return ResultData.failed("orderBo不能为空!");}
        if (null==orderBo.getTeacherId()){return ResultData.failed("teacherId不能为空!");}
        if (null==orderBo.getStudentId()){return ResultData.failed("studentId不能为空!");}
        if (CollectionUtils.isEmpty(orderBo.getTeacherTimeIds())){return ResultData.failed("授课时间不能为空!");}
        ApiResponse<Integer> apiResponse = orderApi.save(orderBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResultData updateById(@RequestBody OrderVo orderVo){
        if (null==orderVo){return ResultData.failed("orderVo不能为空!");}
        if (null==orderVo.getId()){return ResultData.failed("id不能为空!");}
        OrderBo orderBo = baseMapper.map(orderVo,OrderBo.class);
        // 修改订单状态
        ApiResponse<Integer> apiResponse = orderApi.updateById(orderBo);
        // 添加评论
        if (orderVo.getOrderStatus().equals(OrderEnum.orderStatus.pay_evaluate.getValue()) && null != orderVo.getCommentValue()){
            OrderBo obo = orderApi.getById(orderVo.getId()).getBody();
            CommentBo commentBo = new CommentBo();
            commentBo.setCommentValue(orderVo.getCommentValue());
            commentBo.setCommentContent(orderVo.getCommentContent());
            commentBo.setOrderId(orderVo.getId());
            commentBo.setStudentId(obo.getStudentId());
            commentBo.setTeacherId(obo.getTeacherId());
            commentBo.setStatus(CommentEnum.status.status_true.getValue());
            commentApi.save(commentBo);
        }
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    /**
     * 订单取消
     * @param id
     * @return
     */
    @RequestMapping(value = "/cancel",method = RequestMethod.DELETE)
    public ResultData cancel(Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        OrderBo orderBo = orderApi.getById(id).getBody();
        if (null==orderBo){return ResultData.failed("订单不存在");}
        ApiResponse<Integer> apiResponse = orderApi.deleteById(id,-1);
        if (!OrderEnum.orderStatus.pay_wait.getValue().equals(orderBo.getOrderStatus())){
            return ResultData.failed("该订单不允许取消");
        }
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }


    /**
     * 订单详情
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public ResultData details(Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        OrderBo orderBo = orderApi.getById(id).getBody();
        // 查询授课时间
        TeacherTime teacherTime = new TeacherTime();
        teacherTime.setOrderId(orderBo.getId());
        List<TeacherTimeBo> timeBos = teacherTimeApi.getListByCondition(teacherTime).getBody();
        // 查询授课科目
        TeacherSubjectBo subjectBo = teacherSubjectApi.getById(orderBo.getTeacherSubjectId()).getBody();
        orderBo.setTeacherSubjectBo(subjectBo);
        orderBo.setTeacherTimeBos(timeBos);
        TeacherBo teacherBo = teacherApi.getById(orderBo.getTeacherId()).getBody();
        StudentBo studentBo = studentApi.getById(orderBo.getStudentId()).getBody();
        setTeacherDo(orderBo,teacherBo);
        setStudentDo(orderBo,studentBo);
        if (orderBo.getOrderStatus().equals(OrderEnum.orderStatus.pay_do.getValue())){
            // 已支付,查询，学生，老师的联系方式
            orderBo.setTeacherName(teacherBo.getSurname()+teacherBo.getName());
            orderBo.setStudentName(studentBo.getSurname()+studentBo.getName());
            orderBo.setTeacherTelephone(teacherBo.getTelephone());
            orderBo.setStudentTelephone(teacherBo.getTelephone());
        }
        if (orderBo.getOrderStatus().equals(OrderEnum.orderStatus.pay_evaluate.getValue())){
            // 已评论，查询评论
            Comment comment = new Comment();
            comment.setOrderId(orderBo.getId());
            comment.setStatus(CommentEnum.status.status_true.getValue());
            List<CommentBo> commentBos = commentApi.getListByCondition(comment).getBody();
            orderBo.setCommentBos(commentBos);
        }
        return ResultData.successed(orderBo);
    }



    @ResponseBody
    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public ResultData getOrder(OrderCo orderCo){
        if (null==orderCo){return ResultData.failed("orderCo不能为空!");}
        PageParam pageParam = new PageParam();
        pageParam.setPageNum(orderCo.getPageNum());
        pageParam.setPageSize(orderCo.getPageSize());
        pageParam.setOrderBy(" update_time desc,id asc ");
        Page<OrderBo> page = orderApi.getPageByCondition(orderCo,pageParam).getBody();
        if (null!=page && CollectionUtils.isNotEmpty(page.getList())){
            for (OrderBo orderBo:page.getList()){
                TeacherBo teacherBo = teacherApi.getById(orderBo.getTeacherId()).getBody();
                setTeacherDo(orderBo,teacherBo);

                StudentBo studentBo = studentApi.getById(orderBo.getStudentId()).getBody();
                setStudentDo(orderBo,studentBo);

                TeacherSubjectBo teacherSubjectBo = teacherSubjectApi.getById(orderBo.getTeacherSubjectId()).getBody();
                orderBo.setTeacherSubjectBo(teacherSubjectBo);
            }
        }
        return ResultData.successed(page);
    }


    public void setTeacherDo(OrderBo orderBo,TeacherBo teacherBo){
        try {
            orderBo.setTeacherName(teacherBo.getSurname()+"老师");
            if (teacherBo.getSex().equals(TeacherEnum.SEX_GIRL)){
                orderBo.setTeacherGender("女");
            }else {
                orderBo.setTeacherGender("男");
            }
            // 计算年龄
            orderBo.setTeacherAge(AgeUtils.getAge(teacherBo.getBirthday()));
        }catch (Exception e){

        }
    }

    public void setStudentDo(OrderBo orderBo,StudentBo studentBo){
        try {
            orderBo.setStudentName(studentBo.getSurname()+"同学");
            if (studentBo.getSex().equals(TeacherEnum.SEX_GIRL)){
                orderBo.setStudentGender("女");
            }else {
                orderBo.setStudentGender("男");
            }
            // 计算年龄
            orderBo.setStudentAge(AgeUtils.getAge(studentBo.getBirthday()));
        }catch (Exception e){

        }
    }

}
