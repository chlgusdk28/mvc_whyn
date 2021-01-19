<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="AReviewNewListCommand.do" method="post">
			<table  >
				<tr> <td><input type="text" readonly="readonly" value="${newReview.reno }"  > </td></tr>
				<tr> <td><input type="text" value="${newReview.reuserid }"></td> </tr>
				<tr> <td><input type="text" value="${newReview.retitle }"></td> </tr>
				<tr> <td><input type="text" value="${newReview.recontent }"></td> </tr>
				<tr> <td><c:forEach begin="1" end="${newReview.rescore }" ><font color="#FFD700	">★</font> </c:forEach>
				<c:forEach begin="${newReview.rescore+1 }" end="5"><font color="#ccc">☆</font></c:forEach></td> </tr>
				<tr> <td><input type="text" value="${newReview.reinsertdate}"></td> </tr>
				<tr><td> <input type="submit" value="돌아가기 "> </td> </tr>
			
	
	
			</table>
		</form>

</body>
</html>