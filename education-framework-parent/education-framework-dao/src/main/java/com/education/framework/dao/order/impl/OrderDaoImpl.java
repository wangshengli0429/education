package com.education.framework.dao.order.impl;

import java.util.List;
import java.util.Map;

import com.education.framework.model.bo.OrderBo;
import com.education.framework.model.po.Orders;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.order.OrderDao;


/**
 * <p>订单DAOIMPL</p>
 * 
 * @author wangqiang
 * @version 1.0
 * @Date 2018-01-22
 */
@Repository
public class OrderDaoImpl extends SqlSessionDaoSupport implements OrderDao {

	@Override
	public int insertOrder(Orders order) {
		return this.getSqlSession().insert("order.insertOrder", order);
	}

	@Override
	public List<OrderBo> getAllOrders(Map<String, Object> map) {
		return this.getSqlSession().selectList("order.getAllOrders", map);
	}

	@Override
	public int getAllOrdersCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("order.getAllOrdersCount", map);
	}

}
