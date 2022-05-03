<%@page import="repository.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User principalUser = (User) session.getAttribute("principalUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<link rel="stylesheet" href="/JspStudy_6245/static/css/style.css">
<link rel="stylesheet" href="/JspStudy_6245/static/css/mypage.css">
</head>
<body>
	<div id="container">
		<div class="mypage-items">
			<form action="/JspStudy_6245/profile/update/password" method="post">

				<table>
					<tr>
						<td>이전 비밀번호</td>
						<td><input type="hidden" name="principalUser-password"
							class="password-inputs" value="<%=principalUser.getPassword()%>"></td>
					</tr>
					<tr>
						<td>이전 비밀번호 확인</td>
						<td><input type="password" name="origin-password"
							class="password-inputs"></td>
					</tr>
					<tr>
						<td>새 비밀번호</td>
						<td><input type="password" name="new-password"
							class="password-inputs"></td>
					</tr>
					<tr>
						<td>새 비밀번호 확인</td>
						<td><input type="password" name="new-repassword"
							class="password-inputs"></td>
					</tr>

				</table>
		</div>
		<div>
			<button type="button" class="password-update-btn">비밀번호 변경하기</button>
			<button type="button" class="profile-update-btn">회원정보 수정</button>
		</div>
		</form>
	</div>

	<script type="text/javascript"
		src="/JspStudy_6245/static/js/password-update.js"></script>
</body>
</html>