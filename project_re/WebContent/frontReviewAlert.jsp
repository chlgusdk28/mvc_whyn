<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String username = (String)session.getAttribute("USERNAME");

	if(username==null){
		out.println("<script>");
		out.println("alert('로그인을 해야 리뷰를 작성할 수 있습니다.')");
		out.println("location.href='login.jsp'");
		out.println("</script>");
	}
	else{
		out.println("<script>");
		out.println("location.href='frontReviewWrite.jsp'");
		out.println("</script>");
	}
%>
</body>
</html>