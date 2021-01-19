<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.ctable{width: 300px; margin: 0 auto; padding: 30px;}


</style>

<%@include file="adminCategory.jsp" %>
<title>문의확인</title>
</head>
<body>

<h3 align="center" style=" color:#5a5a5a; padding: 40px;" >문의 확인</h3>
<form action="ACounselingLCommand.do" method="post">

	<table  class="ctable" >
		
		<tr> <td><input type="text" value="${counselingContentView.cusername}" readonly="readonly" > </td> </tr>
		<tr> <td><input type="text" value="${counselingContentView.cuserid }" readonly="readonly" ></td> </tr>
		<tr> <td><input type="text" value="${counselingContentView.ccontent}" readonly="readonly" > </td> </tr>
		<tr> <td><input type="text" value="${counselingContentView.cdate}" readonly="readonly"></td> </tr>
		<tr> <td><textarea name="counselingAnswer" readonly="readonly" style="resize: none; "> <%=request.getAttribute("answer") %> </textarea></td></tr>
		<tr><td> <input type="submit"  value='돌아가기'/> </td> </tr> 
	</table>
</form>

	
	
	
	
</body>
</html>