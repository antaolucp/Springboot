<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>学生学籍管理系统登陆</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style2.0.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<style type="text/css">

</style>
<body style="background:url(${pageContext.request.contextPath}/images/page1_3.jpg) no-repeat;background-size:cover">
	<%
		//对用户名和密码进行校验
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
				out.print("<script>alert('"+msg+"');</script>");
			}
	%>
	<div id="contPar" class="contPar">
		<div id="page1" style="z-index:1;">
			<div class="title0">学生学籍管理系统</div>
		</div>
	</div>
	<div class="tyg-div-denglv">
		<div class="tyg-div-form">
			<form action="${pageContext.request.contextPath}/login.action" method="post">
				<h2>登录</h2>
				<p class="tyg-p">欢迎访问 学生学籍管理系统</p>
				<div style="margin:5px 0px;">
					<input type="text" name="usercode" placeholder="请输入账号..." />
				</div>
				<div style="margin:5px 0px;">
					<input type="password" name="password" placeholder="请输入密码..." />
				</div>
				<center>
				<button name="checked" value="0" type="submit">
					学生登<span style="width:20px;"></span>录
				</button>
				<button name="checked" value="1" type="submit">
					教师登<span style="width:20px;"></span>录
				</button>
				<button name="checked" value="2" type="submit">
					管理员登<span style="width:20px;"></span>录
				</button>
				</center>
			</form>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/com.js"></script>


</body>
</html>
