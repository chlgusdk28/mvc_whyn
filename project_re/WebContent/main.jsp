<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	
	int userno = (int)session.getAttribute("USERNO");
	String userid = (String)session.getAttribute("USERID");
	String username = (String)session.getAttribute("USERNAME");
	
%>

회원 번호 : <%=userno %><br>
회원 아이디 : <%=userid %><br>
회원 이름 : <%=username %><br>


</body>
</html>