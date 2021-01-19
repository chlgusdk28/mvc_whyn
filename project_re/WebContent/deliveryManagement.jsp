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
<title>배송 관리</title>
</head>
<body>
<%@include file="adminCategory.jsp" %>

	<h2 align="center">배송 관리</h2>
	<br>
	
	

<!-- ----------------------매달 5일 배송 테이블--------------------------- -->

<table border="0" class="noticeTable">
	<tr><td style="color: #5a5a5a; font-weight: bold;">매달 5일</td></tr>
	<tr style="padding: 5px;" >
		<th width="100" >수취인 이름</th>
		<th width="150" >아이디 </th>
		<th width="90">수취인 전화번호</th>
		<th>병 수</th>
		<th width="100">구독개월수</th>
	</tr>
	
<c:forEach items = "${fivedate }" var = "dto" >
	<tr>
		<td align="center"  ><a href="fiveContentView.do?duserid=${dto.duserid }">${dto.dusername } </a></td>
		<td  align="center"><a href="fiveContentView.do?duserid=${dto.duserid }">${dto.duserid }</a> </td>
		<td  align="center" width="180"><a href="fiveContentView.do?duserid=${dto.duserid }">${dto.dtel }</a></td>
		<td  align="center" width="40"><a href="fiveContentView.do?duserid=${dto.duserid }">${dto.sbottle}</a></td>
		<td  align="center" width="40"><a href="fiveContentView.do?duserid=${dto.duserid }">${dto.speriod}</a></td>
	</tr>
	
	<!--  <form action="ANoticeDeleteCommand.do"> -->
	</c:forEach>
	
</table>
<br><br>

<center style="color: rgba(223,190,106,0.7);">───────────────────────────────────────────────────────────────</center>

<br><br><br>
<!-- ------------------------매달 10일 배송 테이블---------------------------- -->

<table border="0" class="noticeTable">
	<tr><td style="color: #5a5a5a; font-weight: bold;">매달 10일</td></tr>
	<tr style="padding: 5px;" >
		<th width="100" >수취인 이름</th>
		<th width="150" >아이디 </th>
		<th width="90">수취인 전화번호</th>
		<th>병 수</th>
		<th width="100">구독개월수</th>
	</tr>
	
<c:forEach items = "${tendate }" var = "dtos" >
	<tr>
		<td align="center" ><a href="tenContentView.do?duserid=${dtos.duserid }">${dtos.dusername }</a> </td>
		<td  align="center"><a href="tenContentView.do?duserid=${dtos.duserid }">${dtos.duserid }</a> </td>
		<td  align="center" width="180"> <a href="tenContentView.do?duserid=${dtos.duserid }">${dtos.dtel }</a></td>
		<td  align="center" width="40"><a href="tenContentView.do?duserid=${dtos.duserid }">${dtos.sbottle}</a></td>
		<td  align="center" width="40"> <a href="tenContentView.do?duserid=${dtos.duserid }">${dtos.speriod}</a></td>
	</tr>
	
	</c:forEach>
</table>
<br><br>
   <center style="color: rgba(223,190,106,0.7);">───────────────────────────────────────────────────────────────</center>

<br><br><br>
<!-- ------------------------매달 15일 배송 테이블---------------------------- -->
<table border="0" class="noticeTable">
	<tr><td style="color: #5a5a5a; font-weight: bold;">매달 15일</td></tr>
	<tr style="padding: 5px;" >
		<th width="100" >수취인 이름</th>
		<th width="150" >아이디 </th>
		<th width="90">수취인 전화번호</th>
		<th>병 수</th>
		<th width="100">구독개월수</th>
	</tr>
	
<c:forEach items = "${fifteen }" var = "dtod" >
	<tr>
		<td align="center" ><a href="fifteenContentView.do?duserid=${dtod.duserid }">${dtod.dusername }</a> </td>
		<td  align="center"><a href="fifteenContentView.do?duserid=${dtod.duserid }">${dtod.duserid }</a> </td>
		<td  align="center" width="180"><a href="fifteenContentView.do?duserid=${dtod.duserid }">${dtod.dtel }</a></td>
		<td  align="center" width="40"><a href="fifteenContentView.do?duserid=${dtod.duserid }">${dtod.sbottle}</a></td>
		<td  align="center" width="40"><a href="fifteenContentView.do?duserid=${dtod.duserid }">${dtod.speriod}</a></td>
	</tr>
	
	</c:forEach>
	
</table>

<br><br><br>


	
</body>
</html>