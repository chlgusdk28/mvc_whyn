<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="adminCategory.jsp"%>

<style type="text/css">
h2 {color: #5a5a5a;  margin: 0 auto; padding: 30px;}
.counselingTable{width: 1000px; margin: 0 auto; padding: 40px;}
th{ color : #5a5a5a; background-color: #FFE4B5;}
td{color: #5a5a5a;}
a{ color:#5a5a5a;}
</style>

<title>새로운 문의목록</title>
</head>
<body>



<!-- 검색  콤보박스 -->
<table border="0" class="counselingTable">
	<tr>
		<th width="41">번호</th>
		<th  width="82">이름</th>
		<th  width="200">아이디</th>
		<th >제목</th>
		<th >내용 </th>
		<th width="230">문의날짜</th>
	</tr>



 
<c:forEach items = "${newcounseling}" var = "dto">
	<tr>
		<td align="center"> <a href="newcounseling.do?cno=${dto.cno }" >${dto.cno }</a> </td>
		<td  align="center"><a href="newcounseling.do?cno=${dto.cno }">${dto.cusername }</a></td>
		<td  align="center"><a href="newcounseling.do?cno=${dto.cno }">${dto.cuserid}</a></td>
		<td  align="center"><a href="newcounseling.do?cno=${dto.cno }">${dto.ctitle}</a></td>
		<td  align="center"><a href="newcounseling.do?cno=${dto.cno }">${dto.ccontent}</a></td>
		<td  align="center"><a href="newcounseling.do?cno=${dto.cno }">${dto.cdate}</a></td>
		</tr>
		
		</c:forEach>
</table>
</body>
</html>