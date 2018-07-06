package com.education.controller.order;

import com.education.framework.common.response.ResultData;
import com.education.framework.model.bo.OrderBo;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.repo.OrderRepo;
import com.education.framework.repo.StudentRepo;
import com.education.framework.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    private OrderRepo orderRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private StudentRepo studentRepo;


    @RequestMapping(value = "/byTeacher",method = RequestMethod.GET)
    public ResultData getByTeacher(OrderBo orderBo){
        List<OrderBo> list = new ArrayList<OrderBo>();
        OrderBo order = new OrderBo();
        order.setId(1);
        order.setOrderNumber("123456");
        order.setPayMode(1);
        order.setPayMoney(100d);
        order.setOrderStatus(1);
        order.setOrderDescr("订单描述");

        return ResultData.successed(1);
    }

}
