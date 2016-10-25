package com.theo.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.theo.domain.Book;
import com.theo.domain.PageBean;
import com.theo.domain.User;
import com.theo.service.BookService;
import com.theo.service.MyCart;
import com.theo.service.UserService;
import com.theo.service.impl.MyCartImpl;

@Controller
@ParentPackage("struts-default")
@Namespace("/GoHallUI")
@Scope("protoType")
@AllowedMethods({"login"})
public class GoHallUIAction extends ActionSupport implements ModelDriven<User>{
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	private User user;
	
	private static final long serialVersionUID = 1L;
	
	@Action(value="login",results={
			@Result(name="successlogin",location="/hall.jsp"),
			@Result(name="errorlogin",location="/errorlogin.jsp")
	})
	public String login() throws ServletException, IOException {
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		user=userService.checkUser(user);
		if(user.getId()!=0){
			session.setAttribute("user", user);
			MyCart myCart = new MyCartImpl();
			session.setAttribute("myCart", myCart);
			
			int pageNowFree = 1;// 当前页面
			int pageSizeFree = 3;// 每页显示多少条记�?
			int rowCountFree = 12;// 总共有多少条数据
			int pageCountFree = (rowCountFree - 1) / pageSizeFree + 1;// 总共分多少页
			PageBean bookPage = new PageBean(pageNowFree, pageSizeFree,
					rowCountFree, pageCountFree);
			session.setAttribute("bookPage", bookPage);
			
			ArrayList<Book> alBook = bookService.getAllBooks(bookPage);
			session.setAttribute("bookAll", alBook);
			
			
			return "successlogin";
		}
		else{
			return "errorlogin";
		}
		/*
		else{
			return "errorlogin";
		}*/
		/*if (message.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String picCheckCode = (String) request.getSession().getAttribute(
					"checkCode");
			String checkCode = request.getParameter("checkCode");
			User user = new User(username, password);

			// 判断验证�?
			if (!picCheckCode.equals(checkCode)) {
				request.setAttribute("err", "验证码错�?");
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(
						request, response);
				return null;
			}

			*//**
			 * 根据用户名和密码匹配数据�?
			 * *//*
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
		return null;
*/
	}
	
	@Action(value = "vcode", results = { @Result(name = "succes", location = "/login.jsp"),
			@Result(name = "input", location = "/login.jsp") })
	public String vcode() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		// 6.通知客户机以图片方式打开发�?�过去的数据
		response.setHeader("Content-Type", "image/jpeg");

		// 1.在内存中创建�?幅图�?
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);

		// 2.向图片上写数�?
		Graphics g = image.getGraphics();

		// 设置背景�?
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 80, 30);

		// 3.设置写入数据的颜色和字体
		g.setColor(Color.BLACK);
		g.setFont(new Font(null, Font.BOLD, 20));

		// 4.向图片上写数�?
		String num = makeNum();
		// 这句话的意�?�把随机生成的数值，保存到session
		request.getSession().setAttribute("checkCode", num);
		// 这里的NUM可以改变验证码的值画的主要部�?
		g.drawString(num, 0, 20);

		// 把写好的数据的图片输出给浏览�?
		ImageIO.write(image, "jpg", response.getOutputStream());

		return null;
	}

	//生成随机数的验证码
	public String makeNum() {
		Random r = new Random();
		String num = r.nextInt(9999) + "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4 - num.length(); i++) {
			sb.append("0");
		}
		num = sb.toString() + num;
		return num;
	}

	@Override
	public User getModel() {
		user=new User();
		return user;	
	}

}
