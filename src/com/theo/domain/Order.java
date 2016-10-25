package com.theo.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ord_id;
	private int user_id;
	private float ord_total;
	private OrderDetail orderDetail;
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public float getOrd_total() {
		return ord_total;
	}
	public void setOrd_total(float ord_total) {
		this.ord_total = ord_total;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Order(int ord_id, int user_id, float ord_total,
			OrderDetail orderDetail) {
		super();
		this.ord_id = ord_id;
		this.user_id = user_id;
		this.ord_total = ord_total;
		this.orderDetail = orderDetail;
	}
	public Order() {
		super();
		this.orderDetail=new OrderDetail();
	}
	
	
}
