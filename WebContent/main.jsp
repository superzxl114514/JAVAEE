<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="biz.*"%>
<%@ page import="jluee.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
</head>
<body>
	<%
	HttpSession hs = request.getSession();
	String un=(String)hs.getAttribute("sharingvar_username");
	out.println("欢迎"+un+"<br>");
	 %>
</body>
</html>