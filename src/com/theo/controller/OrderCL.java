package com.theo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.theo.domain.Book;
import com.theo.domain.Order;
import com.theo.domain.OrderDetail;
import com.theo.domain.User;
import com.theo.service.MyCart;
import com.theo.service.OrderService;
import com.theo.service.impl.OrderServiceImpl;

public class OrderCL extends HttpServlet {
	private OrderService orderService = new OrderServiceImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
		User user = (User) request.getSession().getAttribute("user");
		
		//对订单进行初始化
		Order order=new Order();
		order.setOrd_total((float)myCart.getTotal());
		order.setUser_id(user.getId());
		
		//获取购物车中的书籍，以便对detail数据表进行添�?
		ArrayList<Book> alBook=myCart.getMyCatMess();
		int lastOrderId=orderService.submitOrder(order);
		//提交数据    且进行判�?
		if (lastOrderId!= 0)
		{
			//对detail的数据进行添�?
			for(Book book:alBook){
				float oneBookPrice=book.getNums()*book.getPrice();
				OrderDetail orderDetail=order.getOrderDetail();
				
				orderDetail.setOdl_price(oneBookPrice);
				orderDetail.setOdl_num(book.getNums());
				orderDetail.setOrd_id(lastOrderId);
				orderDetail.setS_id(user.getId());
				
				//连接数据�?
				orderService.submitDetail(orderDetail);
			}
			request.getRequestDispatcher("/WEB-INF/orderOk.jsp").forward(
					request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
