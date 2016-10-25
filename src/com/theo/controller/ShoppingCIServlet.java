package com.theo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.theo.service.BookService;
import com.theo.service.MyCart;
import com.theo.service.impl.BookServiceImpl;

/**
 * @author theo 该控制器响应用户购买商品的请�?
 */
public class ShoppingCIServlet extends HttpServlet {
	private BookService bookService = new BookServiceImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String shopCLMess = request.getParameter("shopCLMess");

		// 取出购物车，将书的对象放入购物车�?
		MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");

		// 判断是否存在shopCLMess
		if (shopCLMess != null) {

			// 更新购物�?
			if (shopCLMess.equals("updateCar")) {
				//购物车更�?
				//得到�?有表格中的数�?
				String[] bookIds=request.getParameterValues("bookids");
				String[] nums=request.getParameterValues("bookNum");
				for(int i=0;i<bookIds.length;i++){
					myCart.updateBook(bookIds[i], nums[i]);
				}
			}

			// 根据书的ID将书放入购物车中
			if (shopCLMess.equals("buyStuff")) {
				myCart.addBook(id,bookService.getBookById(Integer.parseInt(id)));
			}

			// 根据ID删除数据
			if (shopCLMess.equals("delStuff")) {
				myCart.delBook(id);
			}

			// 清空购物�?
			if (shopCLMess.equals("delAllStuff")) {
				myCart.clearCar();
			}
		}

		//跳转到中转页�?
		response.sendRedirect("/myShopping/ShowMyCar");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
