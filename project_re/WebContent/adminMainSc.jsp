<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
h4 {color: #5a5a5a;  margin: 0 auto; padding: 30px;}
th{ color : #5a5a5a; background-color: #FFE4B5;}
td{color: #5a5a5a;}
a{ color:#5a5a5a;}
.todaySituation{width: 53%; text-align: center; float: left; padding: 40px; text-decoration: none;}
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
    
<title>간편 문의</title>
</head>
<body>


<table class="todaySituation" >
<tr><td><h4> 오늘 현황은 </h4></td></tr>
<tr><td><a href="ASubscribeTodayListCommand.do"> 구독<font color="#B91A4D"> ${STODAYCOUNT} </font> 명 ㅣ</a> 
<a href="counselingTodayList.do"> 문의<font color="#B91A4D" > ${CTODAYCOUNT}</font> 건 ㅣ</a>
<a href="reviewTodayList.do">후기<font color="#B91A4D">${RETODAYCOUNT }</font> 건</a></td></tr>
<tr><td><font size="2" color="#ccc">클릭 시 해당 페이지로 이동됩니다.</font></td></tr>

</table>



</body>
</html>