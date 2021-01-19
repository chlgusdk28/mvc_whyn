<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head></head>
<meta charset="UTF-8">

<%
	String username = (String)session.getAttribute("USERNAME");
	if(username.length()>0){
		out.println("<script>");
		out.println("alert('"+ username +" 님 반갑습니다.')");
		out.println("location.href='index.jsp'");
		out.println("</script>");
	}
%>



</html>
