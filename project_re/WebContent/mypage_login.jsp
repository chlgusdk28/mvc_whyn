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
		String userid = (String)session.getAttribute("USERID");

		if(userid == null || userid == ""){
			out.println("<script>");
			out.println("alert('로그인을 해주셔야 마이페이지를 확인하실 수 있습니다.')");
			out.println("location.href='login.jsp'");
			out.println("</script>");

	}else{
		out.println("<script>");
		out.println("location.href='mypage.do'");
		out.println("</script>");
	}
%>

</body>
</html>