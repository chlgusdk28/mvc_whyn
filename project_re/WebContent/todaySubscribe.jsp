<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

.userTableView{width: 1000px; margin: 0 auto; padding: 30px;}
th {color:#5a5a5a; background-color: #FFE4B5;}
td{ color:#5a5a5a;}
a{ color:#5a5a5a;}
</style>
<%@ include file="adminCategory.jsp"%>
<title>새로운 구독정보</title>
</head>
<body>

<table border="0" class="userTableView">
<tr>
<th >회원이름</th>
<th >아이디</th>
<th >전화번호 </th>
<th>구독여부</th>
<th>가입날짜</th>

</tr>

<!-- Table안에 보여질 내용들 (이름을 눌렀을때 안에 내용들이 보여져야함. dialog로 해야됨 . go to !!userContentView!! ) -->
<c:forEach items = "${userTodayList }" var = "dto">
	<tr>
		
		<td align="center" style="width: 85px;"> <a href="userTodayContentView.do?userno=${dto.userno }"> ${dto.userid }</a> </td>
		<td  align="center" style="width: 200px;"> <a href="userTodayContentView.do?userno=${dto.userno }">${dto.username }</a></td>
		<td  align="center" style="width: 180px;"> <a href="userTodayContentView.do?userno=${dto.userno }">${dto.usertel}</a></td>
		<td  align="center"> <a href="userTodayContentView.do?userno=${dto.userno }"><c:if test="${dto.usersubscribe eq '1'}">구독중</c:if><c:if test="${dto.usersubscribe eq '0'}"></c:if></a></td>
		<td  align="center"> <a href="userTodayContentView.do?userno=${dto.userno }">${dto.userjoindate }</a></td>
		
	</tr>
	</c:forEach>
	
</table>


	



</body>
</html>