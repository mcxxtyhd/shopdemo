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

<title>My JSP 'login.jsp' starting page</title>

<!-- 为了显示验证码  必不可少的组件 -->
	<style>
		.add { width: 80px; height: 30px; float: left; _display: inline; cursor: pointer; margin-left: 20px; }

            .phoKey { background: #ff7200; text-align: center; line-height: 44px; color: #fff; }

            .phoKey{letter-spacing: 3px; font-size:18px;}

			.refresh{cursor: pointer;}
	</style>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/customCSS.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="javascript/test_js.js"></script>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
</head>

<body>
	<h1 class="textCenter">登陆界面</h1>
	<form method="post" id="form1" action="GoHallUI/login">
		<table class="table">
			<tr>
				<td id="test">用户名</td>
				<td><input type="text" name="username" id="username" value="theo" />
				</td>
				<td class="focus">请输入用户名</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" id="password" value="123" />
				</td>
				<td class="focus">请输入密码</td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input name="vcode" type="text" class="input sradd photokey" placeholder="请输入验证码" />
				</td>
				<td colspan="3">
					<a class="refresh">看不清</a>	
					<span class="add phoKey"></span>
				</td>
			</tr>
			<tr>
				<td><input class="btn btn-default" type="submit" value="登录"
					onclick="return checkLogin()" />
				</td>
				<td><input class="btn btn-default" type="button" value="注册" />
				</td>
				<td><input class="btn btn-default" type="reset" value="清空重输" />
				</td>
			</tr>
		</table>
	</form>
	<!--用户信息错误的提示  -->
	<div class="div01">
	<c:out value="${err}"></c:out>
	</div>
	<script src="javascript/jquery-3.1.0.js"></script>
	<script src="javascript/login.js"></script>
	
	<script type="text/javascript">
		// 阻止表单提交？
		$(function(){
			var rootPath = '${pageContext.request.contextPath }';// 根路径
			//设置验证码
			$('.phoKey').css('background', 'url('+rootPath+'/GoHallUI/vcode.action)');
			$('.refresh').on('click', function(){
				$('.phoKey').css('background', 'url('+rootPath+'/GoHallUI/vcode.action?flushTime='+new Date().getTime()+')');
			});
		});
	</script>
</body>
</html>
