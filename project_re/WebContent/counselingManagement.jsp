<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 디자인 css --> 
<style type="text/css">
h2 {color: #5a5a5a;  margin: 0 auto; padding: 30px;}
.counselingSearchTable{width: 200px; margin: 0 auto; }
.counselingTable{width: 1000px; margin: 0 auto; border: none;}
th{ color : #5a5a5a; background-color: #FFE4B5;}
td{color: #5a5a5a;}
a{ color:#5a5a5a;}
tr{padding: 5px;}
.counseling {color: #FFE4B5;}
</style>

<!-- ------------------------------------- -->


<!-- 체크박스 전체선택 -->
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
    
    
    
      $( document ).ready( function() {
        $( '.check-all' ).click( function() {
          $( '.ab' ).prop( 'checked', this.checked );
        } );
      } );

    </script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
      $( document ).ready( function() {
        $( '.check-all1' ).click( function() {
          $( '.ab1' ).prop( 'checked', this.checked );
        } );
      } );

    </script>
    
<title>문의 관리</title>
</head>
<body>
<!-- --------------------------------------- -->



<!-- include 카테고리  -->
<%@include file="adminCategory.jsp" %>
<h2 align="center">문의 관리 </h2>
<br>

<!-- 검색 버튼 눌렀을때, 검색command로 이동  -->
<form action="ACounselingSearchCommand.do" method="post">
	<table class="counselingSearchTable" >
	
	<!-- 검색  콤보박스 -->
	<tr><td><select name="counselingSearchBox"  >
		<option value="cno">번호</option>
		<option value="cusername">이름</option>
		<option value="cuserid">아이디 </option>
		<option value="ctitle">제목 </option>
		<option value="ccontent">내용</option>
		<option value="cdate">문의날짜 </option>
	</select></td>

<!-- 검색 텍스트 바 -->
<td><input type="text" placeholder="번호/이름/아이디/제목/내용/문의날짜를 입력 해주세요." name="counselingSearchBar" value="${setCounselingSearch.counselingSearchBar }" size="50"></td>
<td><input type="submit"value="검색"></td></tr>
</table>
</form>
<!-- ------------------------------- -->


<br><br><br>


<!-- ------------------------------- -->

<!-- table 메인 바 --><h4 align="center">문의 게시판</h4>
<table class="counselingTable">
	<tr>
		<th width="41">번호</th>
		<th  width="82">이름</th>
		<th  width="200">아이디</th>
		<th >제목</th>
		<th >내용 </th>
		<th width="230">문의날짜</th>
		<th style="width: 40px;"><input type="checkbox" name="all" class="check-all"> </th>
	</tr>



<!-- ---------------------------------- -->



<c:forEach items = "${counselingManagementList}" var = "dto" begin="${beginNum }" end="${endNum }"  varStatus = "status" >
	<tr>
		<td align="center"> <a href="counselingContentView.do?cno=${dto.cno }"> ${dto.cno} </a> </td>
		<td  align="center"><a href="counselingContentView.do?cno=${dto.cno }">${dto.cusername }</a></td>
		<td  align="center"><a href="counselingContentView.do?cno=${dto.cno }">${dto.cuserid}</a></td>
		<td  align="center"><a href="counselingContentView.do?cno=${dto.cno }">${dto.ctitle}</a></td>
		<td  align="center"><a href="counselingContentView.do?cno=${dto.cno }">${dto.ccontent}</a></td>
		<td  align="center"><a href="counselingContentView.do?cno=${dto.cno }">${dto.cdate}</a></td>
		
		<td  align="center"> <form action="ACounselingDeleteCommand.do"> <input type="checkbox" name ="deleteCheck" class="ab" value="${dto.cno }" > </td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="7" align="right" >
	<input type="submit" value="삭제" onclick="if(!confirm('삭제 하시겠습니까?')){return false;}" style="text-decoration: none; color: #505050;"></form></td>
	</tr>
	
	
</table>


<!-- ---------------페이지 넘김 ---------------- -->
<center>
<c:forEach begin="1" end="${totalPage}" varStatus="status" >
<a href="ACounselingLPagingCommand.do?page=${status.count}">[${status.count}]</a>	

</c:forEach>



<h4 align="center">간편 상담 리스트</h4>
<table  class="counselingTable">
	<tr>
		<th width="41">번호</th>
		<th  width="82">경로</th>
		<th  width="200">유저인포</th>
		<th width="230">문의날짜</th>
		<th style="width: 40px;"><input type="checkbox" name="all1" class="check-all1"> </th>
	</tr>



 
<c:forEach items = "${simpleConList}" var = "dto">
	<tr>
		<td align="center"> <a href="simpleConList.do?scno=${dto.scno }">${dto.scno }</a> </td>
		<td  align="center"><a href="simpleConList.do?scno=${dto.scno }">${dto.sctype}</a></td>
		<td  align="center"><a href="simpleConList.do?scno=${dto.scno }">${dto.scuserinfo}</a></td>
		<td  align="center"><a href="simpleConList.do?scno=${dto.scno }">${dto.sdate}</a></td>
	<td  align="center"> <form action="deleteSimple.do"> <input type="checkbox" name ="deleteCheck1" class="ab1" value="${dto.scno }" > </td>
		
		</tr>
		
		</c:forEach>
		<tr>
	<td colspan="5" align="right" >
	<input type="submit" value="삭제" onclick="if(!confirm('삭제 하시겠습니까?')){return false;}" style="text-decoration: none; color: #505050;"></form></td>
	</tr>
		
		</table>
<br><br>
</body>
</html>