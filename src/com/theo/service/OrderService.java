package com.theo.service;

import com.theo.domain.Order;
import com.theo.domain.OrderDetail;

/**
 * @author theo 订单的服�?
 */
public interface OrderService {
	public int submitOrder(Order order);
	public void submitDetail(OrderDetail orderDetail);
}
