package com.theo.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class OrderDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ord_id;
	private int s_id;
	private int odl_num;
	private float odl_price;
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getOdl_num() {
		return odl_num;
	}
	public void setOdl_num(int odl_num) {
		this.odl_num = odl_num;
	}
	public float getOdl_price() {
		return odl_price;
	}
	public void setOdl_price(float odl_price) {
		this.odl_price = odl_price;
	}
	public OrderDetail(int ord_id, int s_id, int odl_num, float odl_price) {
		super();
		this.ord_id = ord_id;
		this.s_id = s_id;
		this.odl_num = odl_num;
		this.odl_price = odl_price;
	}
	public OrderDetail() {
		super();
	}
	
}
