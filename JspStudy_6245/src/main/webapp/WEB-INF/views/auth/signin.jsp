<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#container{
	margin : 0px auto; 
	display :flex;
	flex-direction :column;
	justify-content: center;
	align-items: center;
	width: 500px;
	height: 500px
	
}


</style>
</head>
<body>
	<div id="container">
		<div>
			<h1>로그인</h1>
		</div>
		<form action="/JspStudy_6245/auth/signin" method="POST">
			<div>
				<div class="item-input">
					<label class="item-label">사용자 이름</label> <input type="text"
						name="username">
				</div>
				<div class="item-input">
					<label class="item-label">비밀번호</label> <input type="password"
						name="password">
				</div>
			</div>
			<button type ="submit">로그인</button>
		</form>
	</div>
</body>
</html>