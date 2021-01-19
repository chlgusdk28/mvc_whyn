<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="adminCategory.jsp"%>

<style type="text/css">
.usertable {width:300px; margin:0 auto; padding: 30px;}


</style>


<title>회원 구독 확인 </title>
</head>
<body>
	<form action="ASubscribeTodayListCommand.do" method="post">
	
	<table class="usertable" >
		
		<tr> <td> 번호 <input type="text" readonly="readonly" value="${userContentView.userno }"  name="userno"  style="width: 20px; border: none;" > ${viewCount }</td></tr>
		<tr> <td>이름<input type="text" value="${userContentView.username }" name="username" readonly="readonly" > </td> </tr>
		<tr> <td>아이디<input type="text" readonly="readonly" value="${userContentView.userid }" name="userid"> </td> </tr>
		<tr> <td>전번<input type="text" value="${userContentView.usertel }" name="usertel" readonly="readonly"> </td> </tr>
		<tr> <td>주소<input type="text" value="${userContentView.useraddress}" name="useraddress" readonly="readonly" > </td> </tr>
		<tr> <td>가입일<input type="text" value="${userContentView.userjoindate}" readonly="readonly"></td> </tr>
		<tr> <td>성별<input type="text" value="${userContentView.usergender}" readonly="readonly"></td> </tr>
		<tr> <td>생일<input type="text" value="${userContentView.userbday}" name="userbday" readonly="readonly"></td> </tr>
		<tr> <td>구독정보<input type="text" value="<c:if test="${userContentView.usersubscribe eq '1'}">구독중</c:if><c:if test="${userContentView.usersubscribe eq '0'}"></c:if>" readonly="readonly"></td> </tr>
		<tr> <td> <input type="submit" value="돌아가기 "> </td></tr>
	
	
	
	</table>
	
	</form>
</body>
</html>