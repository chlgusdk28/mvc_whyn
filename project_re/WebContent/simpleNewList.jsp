<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
h2 {color: #5a5a5a;  margin: 0 auto; padding: 30px;}
.counselingTable{width: 1000px; margin: 0 auto; padding: 40px;}
th{ color : #5a5a5a; background-color: #FFE4B5;}
td{color: #5a5a5a;}
a{ color:#5a5a5a;}
</style>
<%@ include file="adminCategory.jsp"%>
<title>간편 상담문의 목록</title>
</head>
<body>


<table border="0" class="counselingTable">
	<tr>
		<th width="41">번호</th>
		<th  width="82">경로</th>
		<th  width="200">유저인포</th>
		<th width="230">문의날짜</th>
	</tr>



 
<c:forEach items = "${newSimpleList}" var = "dto">
	<tr>
	
		<td align="center"> <a href="simpleContentView.do?scno=${dto.scno }"> ${dto.scno }</a> </td>
		<td  align="center"><a href="simpleContentView.do?scno=${dto.scno }">${dto.sctype}</a></td>
		<td  align="center"><a href="simpleContentView.do?scno=${dto.scno }">${dto.scuserinfo}</a></td>
		<td  align="center"><a href="simpleContentView.do?scno=${dto.scno }">${dto.sdate}</a></td>
		</tr>
		
		</c:forEach>

</body>
</html>