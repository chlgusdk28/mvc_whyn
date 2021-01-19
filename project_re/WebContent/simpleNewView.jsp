<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="adminCategory.jsp" %>
<title>새로운 간편문의 확인</title>
</head>
<body>

<!-- ㅣ  조회수 :${cviewCount } -->

<form action="ASimpleNewListCommand.do" method="post">

	<table  class="ctable" >
		<tr><td>${sviewcount }</td></tr>
		<tr> <td>문의번호 : <input type="text" readonly="readonly" value="${simpleContentView.scno }" name="scno" style="width: 20px; border: none;" > </td></tr>
		<tr> <td><input type="text" value="${simpleContentView.sctype}" readonly="readonly" name="sctype" > </td> </tr>
		<tr> <td><input type="text" value="${simpleContentView.scuserinfo }" readonly="readonly" name="scuserinfo"></td> </tr>
		<tr> <td><input type="text" value="${simpleContentView.sdate}" readonly="readonly" name="sdate" ></td> </tr>
	</table>
	<table class="ctable">
	 	<tr><td> 
	
	
	
	<tr><td> <input type="submit"  value='돌아가기'/> </td> </tr> <!-- 누르면 꺼지게 해야됨. -->
	</table>

</form>	
</body>
</html>