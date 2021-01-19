<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">


.newSituation{width: 30%; text-align: center; float: left; padding: 40px;}
h4{color:#505050;}
a {color :#505050; }
</style>
<%@include file="adminCategory.jsp" %>
<%@include file="adminMainSc.jsp" %>
<title>관리자 페이지</title>
</head>
<body>

<table class="newSituation" >
<tr><td><h4> 새로운 현황은 </h4></td></tr>
<tr><td><a href="ASubscribeNewListCommand.do"> 구독<font color="#B91A4D"> ${SCOUNT} </font> 명 ㅣ</a> 
<a href="ACounselingNewListCommand.do"> 문의<font color="#B91A4D" > ${CCOUNT }</font> 건 ㅣ</a>
<a href="ASimpleNewListCommand.do">간편 문의<font color="#B91A4D" > ${SIMCOUNT }</font> 건 ㅣ</a>
<a href="AReviewNewListCommand.do">후기<font color="#B91A4D">${RECOUNT }</font> 건</a></td></tr>
<tr><td><font size="2" color="#ccc">클릭 시 해당 페이지로 이동됩니다.</font></td></tr>

</table>




</body>
</html>
