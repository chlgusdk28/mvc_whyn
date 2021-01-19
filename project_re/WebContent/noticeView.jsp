	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>


<style type="text/css">
.contentText{width: 450px; height: 300px; }
.title{width:448px;}
.updateTable{width: 800px; margin: 0 auto;}

</style>

<script type="text/javascript">

/* 퀵메뉴 창닫기 기능 */ 



function update(){
	alert('수정이 완료 되었습니다..');
}

</script>
<meta charset="UTF-8">

<%@ include file="adminCategory.jsp"%>
<title>공지 확인 </title>
</head>
<body>
	
	
	<form action="ANoticeUpdateCommand.do" method="post">
	
	<table style="padding: 30px;" class="updateTable" >
	
		
		<tr> <td>   공지 번호 :<input type="text" readonly="readonly" value="${noticeContentView.nno }" name="nno" style="width: 30px; border: none;" > ㅣ  조회수 : ${ viewCount}  </td></tr>
		<tr> <td> 제목 : <input type="text" value="${noticeContentView.ntitle }" name="ntitle" class="title" style="width: 200px;"> </td> </tr>&nbsp;&nbsp;&nbsp;
		<tr> <td><textarea  class="contentText" name="ncontent">${noticeContentView.ncontent }</textarea></td> </tr>
		<tr> <td>작성날짜 : <input type="text" value="${noticeContentView.ninsertdate }" readonly="readonly"></td> </tr>
		<tr><td> <input type="submit" value="수정"  onclick="update()" ></form> <form action="ANoticeLCommand.do"><input type="submit" value="뒤로가기"  > </form>  </td> </tr>
	
	
	
	</table>
	
	</form>
</body>
</html>