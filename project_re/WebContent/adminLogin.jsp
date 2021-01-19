	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<style type="text/css">
	
	
	</style>
	<title>관리자 페이지</title>
	</head>
	<body>
	<h1 align="center"><a href="adminLogin.jsp" ><img src="img/logo.png" width="205px"></a></h1>
	
	<%request.setCharacterEncoding("utf-8"); %>
		<c:set var="fieldCheck" value="${user.loginFieldCheckMessage}"></c:set>
		<center>
		<form action="adminlogin.do" method="post">
		<table>
		<tr>
			<td colspan = "3"><center><h1>관리자 로그인</h1></center></td></tr>
	<tr>
		<td>ID : </td>
		<td><input type="text" name="userid" value="${user.userid }"></td>
		
	</tr>
	<tr>
		<td>PW : </td>
		<td><input type="password" name="userpw" value=""></td>
	</tr>
	<tr>
	<td colspan="2"><font size="2" color="red"><c:out value="${fieldCheck }"></c:out></font></td>
	</tr>
	<tr>
		<td><input type="submit" value="로그인"></td>
	</tr>
	
		</table>
		</form>
	
	
	
	
	
	
	</body>
	</html>