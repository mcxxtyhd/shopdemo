package com.theo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.theo.service.MyCart;

public class ShowMyCar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 取出购物车，将书的对象放入购物车�?
		MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
		myCart.setAllBookSums(myCart.getTotal());
		// 把要显示的数据放入request中准备显�?
		request.setAttribute("myAllBook", myCart.getMyCatMess());
		
		//防止刷新
		request.getRequestDispatcher("/WEB-INF/showMyCar.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
