package com.theo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.theo.dao.OrderDao;
import com.theo.domain.Order;
import com.theo.domain.OrderDetail;
import com.theo.utils.ConnectionFactory;

public class OrderDaoImpl implements OrderDao{
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * 提交form订单
	 */
	public int submitOrder(Order order) {
		Connection conn = ConnectionFactory.getCon();
		int flag = 0;
		try {
			String sql = "insert into orderform(user_id,ord_total) values('"
					+ order.getUser_id() + "','" + order.getOrd_total() + "')";
			conn.prepareStatement(sql).executeUpdate();
			String sql1 = "SELECT LAST_INSERT_ID()";
			rs = conn.prepareStatement(sql1).executeQuery();
			if (rs.next()) {
				flag = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(conn, pst, rs);
		}
		return flag;

	}

	/**
	 * detail的提�?
	 */
	public void submitDetail(OrderDetail orderDetail) {
		Connection conn = ConnectionFactory.getCon();
		try {
			String sql = "insert into orderdetail(ord_id,s_id,odl_num,odl_price) values('"
					+ orderDetail.getOrd_id()
					+ "','"
					+ orderDetail.getS_id()
					+ "','"
					+ orderDetail.getOdl_num()
					+ "','"
					+ orderDetail.getOdl_price() + "')";
			conn.prepareStatement(sql).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeAll(conn, pst, rs);
		}
	}
}
