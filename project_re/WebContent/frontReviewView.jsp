<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<a href= "ReviewLike.do?reno=${reviewView.reno}&rreno=${reviewView.reno}"></a>
<!-- 댓글접기 채크변수 -->
<!-- ch = index -->
<c:set var = "ch" value="${ch}"/> 
<c:set var = "lch" value="${lch}"/>

<%-- <c:choose>
		<c:when test="${lch == 0}"><a href="ReviewLike.do?rreno=${reviewView.reno}&reno=${reviewView.reno}">좋아요</a></c:when>
		<c:otherwise> <a href="ReviewLike.do?rreno=${reviewView.reno }&reno=${reviewView.reno}">싫어요</a> </c:otherwise>
</c:choose> --%>

<style>
body{background: linear-gradient(#fffaef, #fff);}
.review_section{width:500px;  font-size:14px;text-align: center; margin: 50px auto; border-radius:40px; border:1px solid #997f49; padding:20px;}
.r_table{width:400px; margin:20px auto;}
.r_table2{width:400px; margin:20px auto; font-size:12px;}
.r_table2 input{ background: #fff; color:#997f49; margin:3px; border:1px solid #997f49}
.r_table2 .ddddd {border-top:2px dotted #997f49; padding:5px;}
</style>

<section class="review_section">
	<table class="r_table">
		<tr>
			<td style="color:#997f49">${reviewView.reuserid}님의 후기</td>
		</tr>
		<tr>
			<td style="padding:10px;">제목 : ${reviewView.retitle}</td>
		</tr>
		<tr>
			<td style="padding:10px;">${reviewView.recontent}</td>
		</tr>
		<tr> 
		
			<td>
				<c:forEach begin="1" end="${reviewView.rescore }" ><font color="#FFD700	">★</font> </c:forEach>
				<c:forEach begin="${reviewView.rescore+1 }" end="5"><font color="#ccc">☆</font></c:forEach>
			</td> 
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
	<table class="r_table2">
	<tr>
		<td colspan="3">
			<!-- 댓글입력  -->
			<form action="commentWrite.do?reno=${reviewView.reno }" method="post">
			댓글 입력 :<input type="text" name="commentWrite"><input type="submit" value="입력완료">
			</form>
		</td>
	</tr>
	
	<c:forEach items="${comment}" var="comment"  varStatus="status"> <!-- 댓글 출력 for문 -->
	<!-- for 문 index 번호 변수 선언 -->
	<c:set var = "index" value="${status.index}"/>
	<tr><td colspan="3" class="ddddd"></td></tr>
	<tr>	<!-- 댓글출력 -->
		<td style="width:50px; ">${comment.userid}</td>
		<td style="width:250px; text-align:left;">${comment.content}</td>
		<td>
		<!-------  ch==inex인경우는 대댓글이 펼쳐져있는 상태  -------->
			<c:choose>
				<c:when test="${ch == index}"><a href="frontReviewView.do?reno=${reviewView.reno}" style="font-size:20px; color:#997f49">△</a></c:when>
				<c:otherwise> <a href="frontReviewViewRe.do?index=${status.index}&seq=${comment.seq}&reno=${reviewView.reno}" style="font-size:20px; color:#997f49">▽</a> </c:otherwise>
			</c:choose>
									<!-- 댓글삭제 -->
			&nbsp;&nbsp;&nbsp;<a href="CommentDelete.do?seq=${comment.seq}&reno=${reviewView.reno}" style="font-size:20px; color:#997f49">x</a>
		</td>
	</tr>
	<!-- 부모댓글 seq 변수 선언-->
	<c:set var = "eqcomment" value="${comment.seq}"/> 
		
		<!--  대댓글 출력 for문   -->
		<c:forEach items="${recomment}" var="recomment"> 
			
			<!-- 자식댓글 에 잇는 부모seq -->
			<c:set var = "eqrecomment" value="${recomment.pseq }"/> 
			
			<!-- 부모seq 와 자식댓글에잇는 부모seq 같으면 출력 -->
			<c:if test="${eqcomment eq eqrecomment }"> <!-- 부모seq 와 자식댓글에잇는 부모seq 같으면 출력 -->
			
			<tr>	<!-- 대댓글출력 -->
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ㄴ${recomment.userid}</td>
				<td>${recomment.content}</td>
						<!-- 대댓글삭제 -->
				<td><a href="reCommentDelete.do?seq=${recomment.pseq}&reno=${reviewView.reno}&index=${status.index}&rseq=${recomment.seq}" style="font-size:20px; color:#997f49">x</a></td>
			</tr>
			</c:if>
		</c:forEach>
	<c:if test="${ch eq index }">
	 <tr>
		<td>
			<form action="recommentWrite.do?pCommentNum=${eqcomment}&seq=${comment.seq}&index=${status.index}&reno=${reviewView.reno}" method="post">
						
						<td>대댓글 입력 : <input type="text" name="recomment"></td>
						<td><input type="submit" value="입력완료"></td>
						
			</form>
		</td>
	</tr>
	</c:if>
	</c:forEach>
	<tr>
		<td colspan="3" class="ddddd"></td>
	</tr>
	
	
	</table>
	
	
</section>
<div style="text-align: center; border:1px #997f49 solid; background: #fff; margin:20px auto; width:70px; padding:10px; color:#997f49;"><a href="frontReviewlist.do" style="color:#997f49;">목록으로</a></div>
	
<%@ include file="footer.jsp" %>
	
	
	
</body>
</html>