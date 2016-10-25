package com.theo.service.impl;

import com.theo.dao.OrderDao;
import com.theo.dao.impl.OrderDaoImpl;
import com.theo.domain.Order;
import com.theo.domain.OrderDetail;
import com.theo.service.OrderService;

public class OrderServiceImpl implements OrderService{
	OrderDao orderDao=new OrderDaoImpl();
	/**
	 * 提交form订单
	 */
	public int submitOrder(Order order) {
		return orderDao.submitOrder(order);
	}

	/**
	 * detail的提�?
	 */
	public void submitDetail(OrderDetail orderDetail) {
		orderDao.submitDetail(orderDetail);
	}
}
