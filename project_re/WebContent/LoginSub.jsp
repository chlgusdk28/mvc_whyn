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


if (userid == null){
	out.println("<script>");
	out.println("alert('로그인을 해야 구독서비스를 신청할 수 있습니다.')");
	out.println("location.href='login.jsp'");
	out.println("</script>");
}

else{
	out.println("<script>");
	out.println("location.href='LoginSubCommand.do'");
	out.println("</script>");	
}

%>


</body>
</html>