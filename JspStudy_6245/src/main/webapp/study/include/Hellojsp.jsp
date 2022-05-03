<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%! 
   	private String name = "송승현";
   	private String phone = "01034996245";
   	private String email = "tmdgus7983@daum.net";
   	
   	public void show(){
   		System.out.println(name);
   		System.out.println(phone);
   		System.out.println(email);
   	}  			
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=name %></title>
</head>
<body>
	<%
		for(int i =0; i<5; i++){
			show();
	%>
	<p><%=this.name %></p>
	<%
	}
	%>
	<h1>Hello, jsp</h1>
	
</body>
</html>