<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="counselingWrite.do" method="post">
<table>
<tr>
<td>
제목
</td>
<td>
<input type="text" name = "ctitle">
</td>
</tr>
<tr>
<td>
내용
</td>
<td>
<textarea rows="10" cols="10" name ="ccontent"></textarea>
</td>
</tr>
<tr><td><input type="submit" value="작성"></td></tr>
</table>

</form>
</body>
</html>