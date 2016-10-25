<%@page import="com.theo.service.MyCart"%>
<%@page import="com.theo.domain.Book"%>
<%@page import="com.theo.domain.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'myOrder.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/customCSS.css">
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
</head>

<body>
	<form action="${root}/OrderCL" id="form1">
		<h1>我的订单</h1>
		<table class="table">
			<tr>
				<th colspan="2">用户个人信息</th>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" value="${user.name}">
				</td>
			</tr>
			<tr>
				<td>Emails</td>
				<td><input type="text" value="${user.email}">
				</td>
			</tr>
			<tr>
				<td>用户级别</td>
				<td><input type="text" value="${user.grade}">
				</td>
			</tr>

			<tr>
				<td colspan="5"></td>
			</tr>
		</table>
		<br> <br>
		<table class="table">
			<tr>
				<th>BookId</th>
				<th>书名</th>
				<th>价格</th>
				<th>出版社</th>
				<th>数量</th>
			</tr>

			<c:forEach var='book' items="${myAllBook}" varStatus="booknum">
				<tr>
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.publishHouse}</td>
					<td>${book.nums}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">所有书的总价为${myCart.allBookSums}元</td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</table>
		<br> <input type="submit" value="提交订单"> <br> <br>
		<a href="${root}/ShoppingCIServlet">返回我的购物车</a><br> <a
			href="${root}">重新登录</a>
	</form>
</body>
</html>
