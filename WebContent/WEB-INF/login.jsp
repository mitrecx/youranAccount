<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body style="font-size: 30px;">
		<form action="login.do" method="post">
			<fieldset>
				<legend>登录</legend>
				用户名：<input name="username" />
				<br/>
				密码: <input type="password" name="password"/><br/>
				<input type="submit" value="登录" />
			</fieldset>
		</form>
		<% String msg=(String)request.getAttribute("loginFailed") ;%>
		<span style="color:red;"><%= msg==null ? "" : msg %></span>
	</body>
</html>