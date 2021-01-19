<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<style type="text/css">

.reviewTable{width: 1000px; margin: 0 auto;}
h2 {color: #5a5a5a;margin: 0 auto; padding: 30px;}
.reviewSearchTable{width: 200px; margin: 0 auto;}
th {color:#5a5a5a; background-color:#FFE4B5;}	
td{ color:#5a5a5a;}
tr{color: #828282;}
a{ color:#5a5a5a;}
</style>

    
<title>새로운 후기목록 </title>


<%@include file="adminCategory.jsp" %>
<h2 align="center">후기관리 </h2>
</head>
<body>





<table border="1" class="reviewTable">
	<tr >
		<th style="width: 50px;  " >번호</th>
		<th style="width: 180px;">아이디</th>
		<th style="width: 145px;">제목</th>
		<th>내용</th>
		<th style="width: 200px; ">작성일</th>
		<th style="width: 40px;"><input type="checkbox" name="all" class="check-all"> </th>
	</tr>
	
<c:forEach items = "${newReview }" var = "dto">
	<tr>
		<td align="center"><a href="reviewContentView.do?reno=${dto.reno }"> ${dto.reno } </a></td>
		<td  align="center"><a href="reviewContentView.do?reno=${dto.reno }">${dto.reuserid }</a></td>
		<td  align="center"><a href="reviewContentView.do?reno=${dto.reno }">${dto.retitle}</a></td>
		<td  align="center"><a href="reviewContentView.do?reno=${dto.reno }">${dto.recontent }</a></td>
		<td  align="center"><a href="reviewContentView.do?reno=${dto.reno }">${dto.reinsertdate }</a></td>
		
	</tr>
	</c:forEach>

	
</table>


<!-- ------------------------페이지 넘김---------------------------- -->
<center>
<c:forEach begin="1" end="${totalPage}" varStatus="status">
<a href="AReviewLPagingCommand.do?page=${status.count}">[${status.count}]</a>	

</c:forEach>


</body>
</html>