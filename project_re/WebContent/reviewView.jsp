<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.review{width: 400px; margin: 0 auto; padding: 30px; }
textarea {
	resize: none;
}
h3{padding: 30px; color:  #5a5a5a;}
</style>


<%@ include file="adminCategory.jsp"%>
<title>후기확인 및 수정</title>
</head>
<body>

<h3 align="center">후기 확인 </h3>
		<form action="AReviewLCommand.do" method="post">
		
			<table border="0"  class="review">
			<tr><td> 조회수 : ${reviewCount } </td></tr>
				<tr> <td> 아이디 : <input type="text" value="${reviewContentView.reuserid }" readonly="readonly"></td> </tr>
				<tr> <td>제목 : <input type="text" value="${reviewContentView.retitle }" readonly="readonly"></td> </tr>
				<tr> <td>내용 : <textarea  readonly="readonly">${reviewContentView.recontent } </textarea></td> </tr>
				<tr> <td>별점 : <c:forEach begin="1" end="${reviewContentView.rescore }"  ><font color="#FFD700	">★</font> </c:forEach>
				<c:forEach begin="${reviewContentView.rescore+1 }" end="5"><font color="#ccc">☆</font></c:forEach></td> </tr>
				<tr> <td>작성날짜 : <input type="text" value="${reviewContentView.reinsertdate}" readonly="readonly"></td> </tr>
				<tr><td> <input type="submit" value="돌아가기 "> </td> </tr>
			
	
	
			</table>
		</form>


</body>
</html>