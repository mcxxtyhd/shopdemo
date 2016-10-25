package com.theo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.theo.domain.Book;
import com.theo.domain.PageBean;
import com.theo.domain.User;
import com.theo.service.BookService;
import com.theo.service.MyCart;
import com.theo.service.UserService;
import com.theo.service.impl.BookServiceImpl;
import com.theo.service.impl.MyCartImpl;
import com.theo.service.impl.UserServiceImpl;

public class GoHallUI extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	private BookService bookService = new BookServiceImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String message = request.getParameter("message");

		// 从登陆页面跳转过�?
		if (message.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String picCheckCode = (String) request.getSession().getAttribute(
					"checkCode");
			String checkCode = request.getParameter("checkCode");
			User user = new User();

			// 判断验证�?
			if (!picCheckCode.equals(checkCode)) {
				request.setAttribute("err", "验证码错�?");
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(
						request, response);
				return;
			}

			/**
			 * 根据用户名和密码匹配数据�?
			 * */
			user = userService.checkUser(user);
			if (user.getId() != 0) {
				HttpSession session = request.getSession();

				// 用户存在就执行一下的代码
				// 为用户创建一个购物车,使用session
				MyCart myCart = new MyCartImpl();
				session.setAttribute("myCart", myCart);

				// 设置用户的session
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(3600);

				// 根据分页处理图书页码信息
				int pageNowFree = 1;// 当前页面
				int pageSizeFree = 3;// 每页显示多少条记�?
				int rowCountFree = bookService.getAllPage();// 总共有多少条数据
				int pageCountFree = (rowCountFree - 1) / pageSizeFree + 1;// 总共分多少页
				PageBean bookPage = new PageBean(pageNowFree, pageSizeFree,
						rowCountFree, pageCountFree);
				session.setAttribute("bookPage", bookPage);

				// 获取数据库图书的信息，并传入下一个页�?
				ArrayList<Book> alBook = bookService.getAllBooks(bookPage);
				session.setAttribute("bookAll", alBook);
				request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(
						request, response);
			} else {
				// 用户不存在就执行�?下的代码
				request.setAttribute("err", "用户不存在或者密码错�?");
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(
						request, response);
			}
		}

		// 从购物车页面跳转过来
		if (message.equals("myCar")) {
			// 取出购物车，将书的对象放入购物车�?
			MyCart myCart = (MyCart) request.getSession()
					.getAttribute("myCart");

			// 把要显示的数据放入request中准备显�?
			request.setAttribute("myAllBook", myCart.getMyCatMess());

			// 跳转到我的购物车界面
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request,
					response);
		}

		// 上一�?
		if (message.equals("lastPage")) {
			HttpSession session = request.getSession();
			PageBean bookPage = (PageBean) session.getAttribute("bookPage");
			if (bookPage.getPageNow() != 1) {
				bookPage.setPageNow(bookPage.getPageNow() - 1);
			}
			ArrayList<Book> alBook = bookService.getAllBooks(bookPage);
			session.setAttribute("bookAll", alBook);
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request,
					response);
		}
		// 上一�?
		if (message.equals("nextPage")) {
			HttpSession session = request.getSession();
			PageBean bookPage = (PageBean) session.getAttribute("bookPage");
			if (bookPage.getPageNow() != bookPage.getPageCount()) {
				bookPage.setPageNow(bookPage.getPageNow() + 1);
			}
			ArrayList<Book> alBook = bookService.getAllBooks(bookPage);
			session.setAttribute("bookAll", alBook);
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request,
					response);
		}
		
		
		// 根据页面跳转页面
		if (message.equals("changePage")) {
			String pageNow=request.getParameter("pageNow");
			HttpSession session = request.getSession();
			PageBean bookPage = (PageBean) session.getAttribute("bookPage");
			bookPage.setPageNow(Integer.parseInt(pageNow));
			ArrayList<Book> alBook = bookService.getAllBooks(bookPage);
			session.setAttribute("bookAll", alBook);
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request,
					response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
