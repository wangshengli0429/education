package com.education.framework.dao.order;

import com.education.framework.model.bo.OrderBo;
import com.education.framework.model.po.Orders;

import java.util.List;
import java.util.Map;


/**
 * <p>订单DAO</p>
 * 
 * @author wangqiang
 * @version 1.0
 * @Date 2018-01-22
 */
public interface OrderDao {
	/** 添加订单 */
	int insertOrder(Orders order);
	/** 获取所有订单 */
	List<OrderBo> getAllOrders(Map<String, Object> map);
	/** 查询订单总数 */
	int getAllOrdersCount(Map<String, Object> map);
}
