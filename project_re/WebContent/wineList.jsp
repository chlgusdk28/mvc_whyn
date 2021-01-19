

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
h2{color: #5a5a5a;  margin: 0 auto; padding : 30px;}
.wineSearchTable{width: 200;  margin: 0 auto;}
.wineTable{width: 1000px; margin: 0 auto;}
th{color : #5a5a5a; background-color: #FFE4B5;}
</style>


<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
      $( document ).ready( function() {
        $( '.check-all' ).click( function() {
          $( '.ab' ).prop( 'checked', this.checked );
        } );
      } );

    </script>
<%@ include file="adminCategory.jsp"%>


<title>와인리스트</title>
</head>
<body>


<h2 align="center">와인리스트</h2>
<br>
<table class="wineSearchTable">

<tr><td><select >
	<option>와인이름 </option>
	<option>나라 </option>
	<option>색</option>
	<option>와인특징 </option>
</select></td>
<td><input type="text" placeholder="와인이름/나라/색/와인특징을 입력 해주세요." name="wineSearchBar" size="50"></td>
<td><input type="submit"value="검색"></td></tr>

</table>
<br><br><br>
<table border="1" class="wineTable">
	<tr>
		<th width="41">번호</th>
		<th  width="90">와인이미지</th>
		<th  width="200">와인이름</th>
		<th  width="80">나라</th>
		<th>색</th>
		<th width="400">와인특징</th>
		<th width="40"><input type="checkbox" name="all" class="check-all"> </th>
	</tr>
	
 	<c:forEach items="${wineListShow}" var="dto" begin="${beginNum }" end="${endNum }"> 
		<tr>
			<td><a href="wineContent_View.do?pno=${dto.pno}">${dto.pno}</a></td>
			<td align="center"><img src="${pageContext.request.contextPath}/upload/${dto.pimage}" width="40" ></td>
			<td>${dto.pname}</td>
			<td>${dto.pcountry}</td>
			<td>${dto.pcolor}</td>
			<td >${dto.ptext}</td>
			<td> <form action="AWineDeleteCommand.do"> <input type="checkbox" name ="deleteCheck" class="ab" value="${dto.pno }" > </td>
			
		</tr>
		

	</c:forEach> 
		<tr>
		<td colspan="7" align="right">
		<input type="submit" value="삭제"  onclick="if(!confirm('삭제 하시겠습니까?')){return false;}" style="color: #505050; width: 45px;"></form></td>
		</tr>
			
		
		
		
</table>
					<a href="write_view.jsp" media="post">
					<input type="submit" value="글작성" />
					</a>
	
			
	
	
<center>
<c:forEach begin="1" end="${totalPage}" varStatus="status">
<a href="AWineLPagingCommand.do?page=${status.count}">[${status.count}]</a>	


</c:forEach>
			
<br><br><br><br>

</body>
</html>