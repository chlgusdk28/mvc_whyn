<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head></head>
<meta charset="UTF-8">

<%
	String userid = (String)session.getAttribute("ADMINUSERNO");
	if(userid.length()>0){
		out.println("<script>");
		out.println("alert('반갑습니다. 관리자님.');");
		out.println("location.href='AdmainCountCommand.do'");
		out.println("</script>");
	}
%>



</html>
