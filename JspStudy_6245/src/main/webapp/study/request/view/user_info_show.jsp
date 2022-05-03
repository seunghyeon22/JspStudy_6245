<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="user.User" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String username = request.getParameter("username");
String phone = request.getParameter("phone");
String email = request.getParameter("email");
String address = request.getParameter("address");
String[] select =request.getParameterValues("select");
	
	System.out.println(select.length);
	
	for(String str : select){
		System.out.println(str);
	}
	
	int data = (Integer)request.getAttribute("data");
	System.out.println(data);
	
	
	User user = (User)request.getAttribute("user");
	
%>
<body>
	사용자 아이디 : <%= username %><br>
	<%= user.getUsername() %>
	사용자 연락처 : <%= phone %><br>
	사용자 이메일 : <%= email %><br>
	주소 : <%=address %>
</body>
</html>