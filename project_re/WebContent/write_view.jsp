
<%@page import="javax.crypto.AEADBadTagException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
/* 퀵메뉴 창닫기 기능 */ 

</script>
<title>글작성</title>

<script type="text/javascript">


</script>
</head>
<body>

	<!-- <form action="write.do" method="post" enctype="multipart/form-date"> -->
	<form action="write.do" method="post" enctype="multipart/form-data">
		<table>
		
			<tr>
				<td>이름</td>
				<td><input type="text" name="pname" size="30"></td>
			</tr>
			
			<tr>
				<td>수량</td>
				<td><input type="text" name="pcount" size="10"></td>
			</tr>
			
			<tr>
				<td>나라</td>
				<td><input type="text" name="pcountry" size="50"></td>
			</tr>
			
			<tr>
				<td>색상</td>
				<td><input type="text" name="pcolor" size="50"></td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="ptext"></textarea></td>
			</tr>
			
			<tr>
				<td>알코올 도수</td>
				<td><input type="text" name="pcontent" size="10"></td>
			</tr>
			
			<tr>
				
				<td>파일 첨부 : <input type="file" name="file"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="입력"></td>
			</tr>
			
		</table>
					
			</form>
<br>

			
					
				    	<a href="AWineLCommand.do"><input type="submit" value="돌아가기" /></a>
						
</body>
</html>