package com.education.framework.dao.order;

import java.util.List;
import java.util.Map;

import com.education.framework.model.order.Order;
import com.education.framework.model.order.vo.OrderVo;

/**
 * <p>订单DAO</p>
 * 
 * @author wangqiang
 * @version 1.0
 * @Date 2018-01-22
 */
public interface OrderDao {
	/** 添加订单 */
	int insertOrder(Order order);
	/** 获取所有订单 */
	List<OrderVo> getAllOrders(Map<String, Object> map);
	/** 查询订单总数 */
	int getAllOrdersCount(Map<String, Object> map);
}
