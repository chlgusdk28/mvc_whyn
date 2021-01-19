<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
<table>
<form action="findPw.do" method="post">
<tr>
	<td colspan="2">pw 찾기</td>
</tr>
<tr>
	<td>
		<input type="text" name="userid" value="" > @ <input type="text" name = "domain" >
	</td>
</tr>
<tr>
	<td>
		<input type="text" name="usertel1" value="" > - 


		<input type="text" name="usertel2" value="" > -


		<input type="text" name="usertel3" value="" >
		
	</td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="찾기"></td>
</tr>
<tr>
	<td>${findUserPw}</td>
</tr>
</form>
</table>
<a href="login.jsp">로그인 창으로 이동</a>


</body>
</html>