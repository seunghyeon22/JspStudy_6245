<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%// model1 =스크립틀릿과 태그가 같이 쓰여지는 model형태
		//model1 -> model2 -> MVC 패턴으로 진화
		// MVC = model view controller
	int num = 90;
	if (num > 89) {
	%>
	<p>A학점</p>
	<%
	} else if (num > 79) {
	%>
	<p>B학점</p>
	<%
	}
	else if (num > 69) {
		%>
	<p>C학점</p>
	<%
		}
	%>


</body>
</html>