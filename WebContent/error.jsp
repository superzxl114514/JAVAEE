<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>
</head>
<body>
<% HttpSession hs = request.getSession();
	String m=(String)hs.getAttribute("sharingvar_error");
		out.println(m);
%>
</body>
</html>