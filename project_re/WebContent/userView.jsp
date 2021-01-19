<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 메인 카테고리 jsp include -->
<%@ include file="adminCategory.jsp"%>

<style type="text/css">
.usertable {width:400px; margin:0 auto; padding: 30px;}
.usertable td {padding: 5px; }
.usertable input {width: 300px;}
h3{color: #5a5a5a;}
textarea {resize: none; width: 200px; height: 200px; }
</style>
<script type="text/javascript">
function update(){
	alert('수정이 완료 되었습니다.')
}
</script>
<title>회원 확인 및 수정</title>
</head>
<body>
	<form action="AUserUpdateCommand.do" method="post">
	
	
	<h3 align="center">회원 확인 및 수정</h3>
	<table class="usertable" >
		
		
		<tr><td> <input type="hidden" value="${userContentView.userno }"  name="userno" ></td></tr>
		
		
	<tr>
		 <td align="right" >이름</td>
		<td ><input type="text" value="${userContentView.username }" name="username" > </td>
	 </tr>
		 
		 
	<tr>
		 <td align="right">아이디</td>
		 <td> <input type="text" readonly="readonly" value="${userContentView.userid }" name="userid"> </td> 
	 </tr>
	 
	<tr> 
			<td align="right">전번</td>
			<td><input type="text" value="${userContentView.usertel }" name="usertel"> </td>
	 </tr>
	<tr> 
		<td align="right">우편번호</td>
		<td><input type="text" value="${userContentView.useraddress1}" name="useraddress1" > </td> 
	</tr>
	<tr>
		 <td align="right">도로명 주소</td>
		 <td><input type="text" value="${userContentView.useraddress2}" name="useraddress2" > </td> 
	 </tr>
	<tr> 
		<td align="right">상세 주소</td>
		<td><input type="text" value="${userContentView.useraddress3}" name="useraddress3" > </td>
	 </tr>
	<tr>
	 	<td align="right">가입일</td>
		<td> <input type="text" value="${userContentView.userjoindate}" readonly="readonly"></td>
	 </tr>
	<tr>
		 <td align="right">성별</td>
		 <td><input type="text" value="${userContentView.usergender}" readonly="readonly"></td> 
	 </tr>
	<tr>
		 <td align="right">생일</td>
		<td><input type="text" value="${userContentView.userbday}" name="userbday" readonly="readonly"></td> 
	</tr>
	<tr>
		 <td align="right">구독정보</td>
		 <td> <input type="text" value="<c:if test="${userContentView.usersubscribe eq '1'}">구독중</c:if><c:if test="${userContentView.usersubscribe eq '0'}"></c:if>" name="usersubscribe"></td>
	</tr>
	<tr> 
		<td align="right">관리자커멘트</td>
		<td> <textarea  name="admincomment">${userContentView.admincomment }</textarea></td>
	 </tr>
	<tr>
		<td> <input type="submit" value="수정"  onclick="update()"  ></form> <form action="AUserLCommand.do"><input type="submit" value="뒤로가기"  class="button" > </form>  </td> 
	</tr>
	</table>
	</form>
		 <font size="2" color="#ccc" class="comment" >여기서 수정이 가능합니다. 수정 후 수정버튼을 눌러주세요. </font>
	
	
	
	
	
	
</body>
</html>