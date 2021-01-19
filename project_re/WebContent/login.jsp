<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<meta charset="utf-8">
<title>로그인 창</title>
<style>
body{background: linear-gradient(#fffaef, #666); text-align:center;}

.l_table{width:210px; margin:0 auto; color:#997f49;}
.l_table input{margin:3px;width:180px;}
.l_table .l_title{text-align:center; color:#997f49; padding: 40px; font-size:55px; letter-spacing: -2px;}
</style>
</head>
<body>

<%@ include file="header.jsp" %>

	<%request.setCharacterEncoding("utf-8"); %>
	<c:set var="fieldCheck" value="${user.loginFieldCheckMessage}"></c:set>

	<table class="l_table">
	<form action="login.do" method="post">
	<tr>
		<td colspan = "2"><h1 class="l_title">LOG_IN</h1></td>
	</tr>
	
	<tr>
		<td style="width:15px;">ID</td>
		<td style="width:180px;"><input type="text" name="userid" value="${user.userid }"></td>
		
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" name="userpw" value=""></td>
	</tr>
	<tr>
	<td colspan="2"><font size="2" color="red"><c:out value="${fieldCheck }"></c:out></font></td>
	</tr>
	</table>
		<div style="margin:0 auto; margin-top:10px; width:245px; background:#997f49; text-align: center; height: 35px;">
			<input type="submit" value="LOGIN" style="width:245px; border:0; background: transparent; margin-top:5px; color:#fff;">
		</div>
		
	</form>
	
		<form action="join.jsp" method="post">
			<div style="margin:0 auto; margin-top:5px; width:245px; background:#666; text-align: center; height: 35px;">
				<input type="submit" value="JOIN US" style="width:245px; border:0; background: transparent; margin-top:5px; color:#fff;">
			</div>
		</form>
	

<style>
.b_de{ width:112px; margin:5px; text-align: center; height: 15px;
padding:10px; float:left; border:2px #fff solid; box-sizing:border-box; font-size:13px; padding-bottom:20px;}
.b_de:hover{transition:0.2s; border:2px #333 solid; color:#333;}
</style>

<div style="width:250px; margin:30px auto; clear:both; height: 100px;">
	<a href="findId.jsp" style="color:#fff;">
		<div class="b_de" style="margin-right:10px;">
					아이디찾기
		</div>
	</a>
	
	<a href="findPw.jsp" style="color:#fff;">
		<div class="b_de">
			비밀번호 찾기
		</div>
	</a>
</div>		

<%@ include file="footer.jsp" %>


</body>
</html>