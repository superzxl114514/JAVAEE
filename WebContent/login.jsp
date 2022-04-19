<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
</head>
<body>

<form action = "/ServletPractice/DataAccess?op=2" method="post" target="workspace">
				登录:<br>
				    用户名：<input type="text" name="username">
				    密码：<input type="text" name="password"><br>
				    <input type="submit" name="login" value="登录">
				</form>
<% HttpSession hs = request.getSession();
	String m=(String)hs.getAttribute("sharingvar_false");
	if(m=="1"){
		out.println("登陆失败，用户名与密码不匹配！");
	}
%>
</body>
</html>