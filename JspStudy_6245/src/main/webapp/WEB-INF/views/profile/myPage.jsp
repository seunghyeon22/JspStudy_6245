<%@page import="repository.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	User principalUser = (User)session.getAttribute("principalUser"); 
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
			<table>
				<tr>
					<td>사용자 이름</td>
					<td><%= principalUser.getUsername() %></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><%=  principalUser.getName() %></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><%=  principalUser.getEmail()  %></td>
				</tr>

			</table>

		</div>
		<div>
			<button type="button" class="profile-update-btn">회원 정보 수정</button>
			<button type="button" class = "password-update-btn">비밀번호 변경</button>
			<button type="button" class = "membership-withrawal">회원탈퇴</button>
			<button type="button" class = "logout-btn">로그아웃</button>
		</div>
		</div>
		<script type="text/javascript">
			const profileUpdateBtn = document.querySelector(".profile-update-btn");
			const passwordUpdateBtn = document.querySelector(".password-update-btn");
			const membershipWithrawal = document.querySelector(".membership-withrawal");
			const logoutBtn = document.querySelector(".logout-btn")
			
			profileUpdateBtn.onclick = () =>{
				location.href = "/JspStudy_6245/profile/update";
			}
			passwordUpdateBtn.onclick = () =>{
				location.href = "/JspStudy_6245/profile/update/password";
			}
			membershipWithrawal.onclick=()=>{
				let flag = confirm("정말로 회원탈퇴 하시겠습니까?");
				if(flag==true){
					location.href ="/JspStudy_6245/profile/delete";
				}
			}
			logoutBtn.onclick =() => {
				location.href ="/JspStudy_6245/auth/logout";
			}
			
		</script>
</body>
</html>