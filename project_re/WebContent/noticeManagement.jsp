<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
h2{color: #5a5a5a;  margin: 0 auto; padding: 30px; }
.noticeSearchTable{width: 200;  margin: 0 auto;}
.noticeTable{width:1000px; margin: 0 auto; border: none; }
th{color : #5a5a5a; background-color: #FFE4B5;}
td{color: #5a5a5a;}
.write{margin: 0 auto; text-align: right;}
a{color: #5a5a5a;  }
.title{width: 300px;}

    .ellipsis{
    
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    } 

</style>

<!-- 체크박스 맨위에 거만 누르면 전체 선택 할 수 있게 만든 script source  -->
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
      $( document ).ready( function() {
        $( '.check-all' ).click( function() {
          $( '.ab' ).prop( 'checked', this.checked );
        } );
      } );

    </script>
<title>공지사항</title>
</head>
<body>
<%@include file="adminCategory.jsp" %>

	<h2 align="center">공지사항</h2>
	<br>
	
	
	
	
	<!-- ------------------------------------------ -->
	
	<form action="ANoticeSearchCommand.do" method="post">
<table class="noticeSearchTable">


<!-- 검색 콤보박스 -->
<tr><td><select name="nSearchBox" >
	<option value="nno" >번호</option>
	<option value="ntitle">제목 </option>
	<option value="ncontent">내용</option>
	<option value="ninsertdate">작성날짜 </option>
</select></td>
<td><input type="text" placeholder="번호/제목/내용/작성날짜를 입력 해주세요." name="nSearchBar" value="${setNoticeSearch.nSearchBox }" size="50"></td>
<td><input type="submit"value="검색"></td></tr>
</table>
</form>
<!-- ------------------------------- -->


<br><br><br>





<!-- ------------------------------- -->
<table border="0" class="noticeTable">
	<tr>  <form action="noticeWrite.jsp" method="post">

	<td  colspan="6" align="left"><input type="submit" value="글쓰기" class="write" ></td>
</form>
</tr>
	<tr style="padding: 5px;" >
		<th width="41">번호</th>
		<th class="title" >제목 </th>
		<th>작성날짜</th>
		<th>조회수</th>
		<th width="40"><input type="checkbox" name="all" class="check-all"> </th>
	</tr>
	
<c:forEach items = "${noticeManagementList }" var = "dto" begin="${beginNum }" end="${ endNum}">
	<tr>
		<td align="center" ><a href="noticeContentView.do?nno=${dto.nno }"> ${dto.nno }</a> </td>
		<td  align="center" class="title">
			<a href="noticeContentView.do?nno=${dto.nno }">${dto.ntitle }</a>
		 </td>
		<td  align="center" width="180"><a href="noticeContentView.do?nno=${dto.nno }">${dto.ninsertdate }</a></td>
		<td  align="center" width="40"><a href="noticeContentView.do?nno=${dto.nno }">${dto.nviewcount}</a></td>
		
		<td   align="center">  <form action="ANoticeDeleteCommand.do"> <input type="checkbox" name ="deleteCheck" class="ab" value="${dto.nno }" > </td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="6" align="right" >
	
	<input type="submit" value="삭제"  onclick="if(!confirm('삭제 하시겠습니까?')){return false;}" style="color: #505050; width: 45px;"></form></td>
	</tr>

</table>
<!-- ------------------------페이지 넘김---------------------------- -->
<center>
<c:forEach begin="1" end="${totalPage}" varStatus="status">
<a href="ANoticeLPagingCommand.do?page=${status.count}">[${status.count}]</a>	

</c:forEach>

	
</body>
</html>