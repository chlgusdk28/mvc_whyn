<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.noticewrite{width: 200px; margin: 0 auto; padding: 40px; }
.contentText{width: 400px; height: 400px; }


</style>


<%@ include file="adminCategory.jsp"%>

<title>공지 글쓰기</title>
</head>
<body>
<form action="noticeWrite.do" method="post">
	<table class="noticewrite" >
		
		<tr> <td> 제목 : <input type="text" name="ntitle" class="title" style="width: 350px;"> </td> </tr>
		<tr> <td> 내용<textarea name="ncontent" class="contentText" ></textarea></td> </tr>
		<tr><td> <input type="submit" value="입력하기"> </td> </tr>
	</form>
		 <tr><td><form action="ANoticeLCommand.do"><input type="submit" value="뒤로가기"  > </form></td></tr>
	
	
	</table>



</body>
</html>