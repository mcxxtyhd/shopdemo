<%@page import="com.theo.domain.Book"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'showMyCar.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/test_js.js"></script>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
</head>

<body>
	<h1>我的购物车</h1>
	<form method="post"
		action="${root}/ShoppingCIServlet?shopCLMess=updateCar">
		<table class="table table-hover">
			<tr>
				<th>bookId</th>
				<th>书名</th>
				<th>价格</th>
				<th>数量</th>
				<th>删除</th>
			</tr>

			<c:forEach var="book" items="${myAllBook}">
				<tr>
					<td>${book.id}<input type="hidden" name="bookids"
						value="${book.id}" />
					</td>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td><input type="text" name="bookNum" value="${book.nums}"
						size="5px" />
					</td>
					<td><a
						href="${root}/ShoppingCIServlet?shopCLMess=delStuff&id=${book.id}"
						onclick="return checkDel()">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><input type="submit" value="更新"></td>
			</tr>
			<tr>
				<td colspan="5">所有书的总价为：${myCart.allBookSums}元</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="">1页</a>
	<hr>
	<a href="${root}/ShoppingCIServlet?shopCLMess=<%="delAllStuff"%>">清空购物车</a>
	<a href="${root}/submitOrder">提交订单</a>
	<br>
	<br>
	<a href="${root}">安全退出</a>
	<a href="${root}/GoHallUI?message=myCar">返回购物大厅</a>
	<script src="javascript/test_js.js"></script>
</body>
</html>
