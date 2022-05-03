<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="student.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	Student stud = (Student)request.getAttribute("stud");
%>
</head>
<body>
		학교명 : <%=stud.getSchoolName() %><br>
		학생명 : <%=stud.getName() %><br>
		학년 : <%=stud.getStudentYear() %><br>
		학과 : <%= stud.getDepartment() %>	<br>
		학점 :	<%= stud.getGrade() %>
</body>
</html>