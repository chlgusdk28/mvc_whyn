<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="findUserId.do" method="post">
	 <table>
	<tr>
	<td colspan="2">id 찾기</td>
</tr>
<tr>
	<td>
		<input type="text" name="usertel1" value="" > - 


		<input type="text" name="usertel2" value="" > -


		<input type="text" name="usertel3" value="" >
	<td>
	
</tr>
<tr>
	<td>
		<input type="text" name="userbday" value="" style="width:80px;height:40px;font-size:18px;">
		&nbsp;&nbsp;년 &nbsp;&nbsp;&nbsp;
				<!----------- 월  ----- ------>
				<select name="month" style="width:80px;height:40px;font-size:18px;">
					<c:forEach begin="1" end="12" varStatus="status">
					<option value="${status.current}">${status.current}</option>
					</c:forEach>
				</select>
				&nbsp;&nbsp;월
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<!----------- 월  ----- ------>
				
				
				<!----------- 월  ----- ------>
				<select name = "date" style="width:80px;height:40px;font-size:18px;">
					<c:forEach begin="1" end="31" varStatus="status">
						<option value="${status.current}">${status.current}</option>
					</c:forEach>			
				
				</select>
				&nbsp;&nbsp;일				
				<!-- 일 -->
		
		
	</td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="찾기"></td>
</tr>
<tr>
	<td>${findUserId }</td>
</tr>
	</table>
	<a href="login.jsp">로그인 창으로 이동</a>
	<a href="findPw.jsp">비밀번호찾기</a>
	
</form>
</body>
</html>