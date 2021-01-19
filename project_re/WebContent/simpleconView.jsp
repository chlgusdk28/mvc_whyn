<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="adminCategory.jsp"%>
<title> 간편문의 확인 </title>
</head>
<body>
	
	
	<form action="ASimpleConLCommand.do" method="post">
	
	<table style="padding: 30px;" >
	
		
		<tr> <td>   문의 번호 <input type="text" readonly="readonly" value="${simpleConList.scno }" style="width: 30px; border: none;" > ㅣ  조회수 : ${ viewCount}  </td></tr>
		<tr> <td> 경로  <input type="text" value="${simpleConList.sctype }"class="title" style="width: 100px;" readonly="readonly"> </td> </tr>&nbsp;&nbsp;&nbsp;
		<tr> <td> 유저인포  <input type="text" value="${simpleConList.scuserinfo }" readonly="readonly"></td> </tr>
		<tr> <td> 문의날짜 : <input type="text" value="${simpleConList.sdate }" readonly="readonly"></td> </tr>
		<tr><td> <input type="submit" value="뒤로가기"  >  </td> </tr>
	
	
	
	</table>
	
	</form>
</body>
</html>