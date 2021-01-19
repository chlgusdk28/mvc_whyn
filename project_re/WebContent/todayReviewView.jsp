<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="adminCategory.jsp" %>
<title>오늘의 리뷰 </title>
</head>
<body>

	<form action="reviewTodayList.do" method="post">
			<table  >
				<tr> <td><input type="text" readonly="readonly" value="${reviewContentView.reno }"  > </td></tr>
				<tr> <td><input type="text" value="${reviewContentView.reuserid }"></td> </tr>
				<tr> <td><input type="text" value="${reviewContentView.retitle }"></td> </tr>
				<tr> <td><input type="text" value="${reviewContentView.recontent }"></td> </tr>
				<tr> <td><c:forEach begin="1" end="${reviewContentView.rescore}" ><font color="#FFD700	">★</font> </c:forEach>
				<c:forEach begin="${reviewContentView.rescore+1 }" end="5"><font color="#ccc">☆</font></c:forEach></td> </tr>
				<tr> <td><input type="text" value="${reviewContentView.reinsertdate}"></td> </tr>
				<tr><td> <input type="submit" value="돌아가기 "> </td> </tr>
			
	
	
			</table>
		</form>

</body>
</html>