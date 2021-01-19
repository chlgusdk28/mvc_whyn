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
	int subjud = (Integer)session.getAttribute("subjud");
	if(subjud>0){	
		out.println("<script>");
		out.println("alert('고객님께서는 구독중이십니다. 추가구독을 할 수 없습니다.')");
		out.println("location.href='index.jsp'");
		out.println("</script>");
		
	}else{
		out.println("<script>");
		out.println("location.href='subscribe.jsp'");
		out.println("</script>");	
		
	}
%>
</body>
</html>