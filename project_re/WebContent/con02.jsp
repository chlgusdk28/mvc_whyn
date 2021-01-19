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
String c_no = (String)request.getParameter("c_no");
String con_info = (String)request.getParameter("con_info");

if(con_info.length()==0){
	out.println("<script>alert('상담 내용을 입력해주세요.'); location.href='index.jsp';</script>");
}else{
out.println("<script>alert('상담 내용이 전달 되었습니다.'); location.href='index.jsp';</script>");
}
%>


</body>
</html>