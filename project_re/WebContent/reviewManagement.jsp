<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!--화면 출력 할 디자인들 색이나 위치 조정!-->
<style type="text/css">

.reviewTable{width: 1000px; margin: 0 auto; border: none;}
h2 {color: #5a5a5a;margin: 0 auto; padding: 30px;}
.reviewSearchTable{width: 200px; margin: 0 auto;}
th {color:#5a5a5a; background-color:#FFE4B5;}	
td{ color:#5a5a5a;}
tr{color: #828282;}
a{ color:#5a5a5a;}
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
<title>후기관리</title>
</head>
<body>

<!-- 메인 화면 카테고리 include -->
<%@include file="adminCategory.jsp" %>
<h2 align="center">후기관리 </h2>

<br>




<!-- --------------------------------- -->
<!--검색 눌렀을 경우 검색판단해주는 command로 이동 -->
<form action="AReviewSearchCommand.do" method="post">
<table class="reviewSearchTable">


<!-- 검색 콤보박스  -->
<tr><td><select name="reviewSearchBox" >
	<option value="reno">번호 </option>
	<option value="reuserid">아이디 </option>
	<option value="retitle">제목 </option>
	<option value="recontent">내용 </option>
	<option value="reinsertdate">작성일 </option>
</select></td>

<!-- 검색 텍스트 바  -->
<td><input type="text" placeholder="번호 /아이디/제목/내용/작성일을 입력 해주세요." name="reviewSearchBar" value="${setReviewSearch.reviewSearchBar }" size="50"></td>
<td><input type="submit"value="검색"></td></tr>
</table>
</form>
<!-- ---------form 및 검색 table 끝-------------- -->



<br><br><br>

<!----------------- table board 시작------------>
<table border="0" class="reviewTable">
	<tr >
		<th style="width: 50px;  " >번호</th>
		<th style="width: 180px;">아이디</th>
		<th style="width: 145px;">제목</th>
		<th>내용</th>
		<th style="width: 200px; ">작성일</th>
		<th style="width: 40px;"><input type="checkbox" name="all" class="check-all"> </th>
	</tr>
	
<!-- ---------------------------------------- -->	
	
<c:forEach items = "${reviewManagementList }" var = "dto" >
	<tr>
		<td align="center"><a href="reviewContentView.do?reno=${dto.reno }">  ${dto.reno} </a></td>
		<td  align="center"><a href="reviewContentView.do?reno=${dto.reno }">${dto.reuserid }</a></td>
		<td  align="center"><a href="reviewContentView.do?reno=${dto.reno }">${dto.retitle}</a></td>
		<td  align="center"><a href="reviewContentView.do?reno=${dto.reno }">${dto.recontent }</a></td>
		<td  align="center"><a href="reviewContentView.do?reno=${dto.reno }">${dto.reinsertdate }</a></td>
		
		<td  align="center"> <form action="AReviewDeleteCommand.do"> <input type="checkbox" name ="deleteCheck" class="ab" value="${dto.reno }" > </td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="6" align="right" >
	<input type="submit" value="삭제"  onclick="if(!confirm('삭제 하시겠습니까?')){return false;}" style="text-decoration: none; color: #505050;"></form></td>
	</tr>

	
</table>


<!-- ------------------------페이지 넘김---------------------------- -->
<center>
<c:forEach begin="1" end="${totalPage}" varStatus="status">
<a href="AReviewLPagingCommand.do?page=${status.count}">[${status.count}]</a>	

</c:forEach>


</body>
</html>