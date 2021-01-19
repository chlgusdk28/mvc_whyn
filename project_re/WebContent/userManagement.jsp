<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.userTable{width: 200px; margin: 0 auto; border: none;}
.userTableView{width: 1000px; margin: 0 auto; border: none;}
h2 {color:#5a5a5a; margin: 0 auto; padding: 30px;}
th {color:#5a5a5a; background-color: #FFE4B5;}
td{ color:#5a5a5a;}
a{ color:#5a5a5a;}
</style>
<%@ include file="adminCategory.jsp"%>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
      $( document ).ready( function() {
        $( '.check-all' ).click( function() {
          $( '.ab' ).prop( 'checked', this.checked );
        } );
      } );


    </script>
    
    
<title>회원관리 페이지</title>
</head>
<body>
<h2 align="center">회원관리</h2><br>
<!-- 검색 SelectBox -->
<form action="AUserSearchCommand.do" method="post">
<table border="0" class="userTable">
<tr><td><select name="userSelectBox" >
	<option value="username" >회원이름 </option>
	<option value="userid" >아이디 </option>
	<option value="usertel" >전화번호 </option>
	<option value="usersubscribe">구독여부  </option>
	<option value="userjoindate">가입날짜 </option>
</select></td>
<td><input type="text" placeholder="회원이름/아이디/전화번호/구독여부/가입날짜를 입력해 주세요." name="userSearchBar" value="${setSearch.userSearchBar }" size="30"></td>
<td><input type="submit"value="검색"></td></tr>
</table>
</form>
<br><br><br>


<!--Table에 보여질 제목들 -->
<table border="0" class="userTableView">
<tr>
<th >번호</th>
<th >회원이름</th>
<th >아이디</th>
<th >전화번호 </th>
<th>구독여부</th>
<th>가입날짜</th>
<th width="40"><input type="checkbox" name="all" class="check-all"> </th>

</tr>${dto.usersubscribe}


<!-- Table안에 보여질 내용들 (이름을 눌렀을때 안에 내용들이 보여져야함. dialog로 해야됨 . go to !!userContentView!! ) -->

	<c:forEach items = "${userManagementList }" var = "dto" >
	<tr>
		<td align="center" style="width: 85px;"> <a href="userContentView.do?userno=${dto.userno }"> ${dto.userno } </a> </td>
		<td align="center" style="width: 85px;"> <a href="userContentView.do?userno=${dto.userno }"> ${dto.userid }</a> </td>
		<td  align="center" style="width: 200px;"> <a href="userContentView.do?userno=${dto.userno }">${dto.username }</a></td>
		<td  align="center" style="width: 180px;"> <a href="userContentView.do?userno=${dto.userno }">${dto.usertel}</a></td>
		<td  align="center"> <a href="userContentView.do?userno=${dto.userno }"><c:if test="${dto.usersubscribe eq '1'}">구독중</c:if><c:if test="${dto.usersubscribe eq '0'}"></c:if>    </a></td>
		<td  align="center"> <a href="userContentView.do?userno=${dto.userno }">${dto.userjoindate }</a></td>
		
		<td  align="center"> <form action="AUserDeleteCommand.do"> <input type="checkbox" name ="deleteCheck" class="ab" value="${dto.userno }" > </td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="7" align="right" >
	<input type="submit" value="삭제"  onclick="if(!confirm('삭제 하시겠습니까?')){return false;}" style= color: #505050;"></form></td>
	</tr>
	
</table>
<!-- --------------페이지 넘김---------------- -->	
	
	<center>
<c:forEach begin="1" end="${totalPage}" varStatus="status">
<a href="AUserLPagingCommand.do?page=${status.count}">[${status.count}]</a>	

</c:forEach>
	
	
</body>


</html>