<%@page import="com.theo.domain.Book"%>
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

<title>My JSP 'hall.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css">
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
</head>

<body>
	<h1>欢迎光临购物大厅 </h1>
	<table class="table table-hover">
		<tr>
			<th>书名</th>
			<th>作者</th>
			<th>出版社</th>
			<th>价格</th>
			<th>点击购买</th>
		</tr>
		<c:forEach var="book" items="${bookAll}" varStatus="booknum">
			<tr>
				<td><c:out value="${book.name }"></c:out>
				</td>
				<td><c:out value="${book.author }"></c:out>
				</td>
				<td><c:out value="${book.publishHouse }"></c:out>
				</td>
				<td><c:out value="${book.price }"></c:out>
				</td>
				<td><a
					href="${root}/ShoppingCIServlet?shopCLMess=buyStuff&id=${book.id}">点击购买</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="${root}/ShoppingCIServlet">查看购物车</a>
			</td>
		</tr>
		<tr>
			<td colspan="5"><a href="${root}/GoHallUI?message=lastPage">上一页</a> &nbsp &nbsp
			<c:forEach var="s"  begin="1" end="${bookPage.pageCount}">
				<a href="${root}/GoHallUI?message=changePage&pageNow=${s}">${s}</a>
			</c:forEach>
			 &nbsp &nbsp<a href="${root}/GoHallUI?message=nextPage">下一页</a></td>
		</tr>
		<tr>
			<td colspan="5"><span class="page">共有 ${bookPage.rowCount
					} 条信息 每页显示 ${bookPage.pageSize } 条 第 ${bookPage.pageNow } 页/共
					${bookPage.pageCount } 页</span></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="${root}">重新登录</a>
</body>
</html>
