<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="student.Student" %>
    <% 
		Student students = Student.builder()
			.schoolName(request.getParameter("school-name"))
			.name(request.getParameter("student-name"))
			.studentYear(request.getParameter("student-year"))
			.department(request.getParameter("school-department"))
			.grade(request.getParameter("grade"))
			.build();
		
    	request.setAttribute("stud", students);
   	%>
<jsp:forward page="../view/student_info_view.jsp"></jsp:forward>