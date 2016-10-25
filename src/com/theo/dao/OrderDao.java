package com.theo.dao;

import com.theo.domain.Order;
import com.theo.domain.OrderDetail;

public interface OrderDao {
	public int submitOrder(Order order);
	public void submitDetail(OrderDetail orderDetail);
}
