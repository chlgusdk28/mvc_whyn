<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글내용보기</title>
</head>
<body>
	<table>
		
		<form action="modify.do" method="post" enctype="multipart/form-data">
			<tr>
				<td>번호</td>
				<td><input type="text" name="pno" size="10" value="${wineContent_View.pno }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="pname" size="30" value="${wineContent_View.pname }"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="text" name="pcount" size="50" value="${wineContent_View.pcount}"></td>
			</tr>
			<tr>
				<td>나라</td>
				<td><input type="text" name="pcountry" size="50" value="${wineContent_View.pcountry}"></td>
			</tr>
			<tr>
				<td>색상</td>
				<td><input type="text" name="pcolor" size="50" value="${wineContent_View.pcolor}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="ptext">${wineContent_View.ptext}</textarea></td>
			</tr>
			<tr>
				<td>도수</td>
				<td><input type="text" name="pcontent" size="10" value="${wineContent_View.pcontent }"></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="file"></td>
				<%-- <td><img src="${pageContext.request.contextPath}/upload/${wineContent_View.pimage}" width="100" height="100"></td> --%>
			</tr>
			
			<tr>
				<!-- <form action="modifyScript.jsp" method="post"> -->
				<td colspan="2"><input type="submit" value="수정"></td>
			<!-- 	</form> -->
			</tr>
			
			<tr>
				<td><a href="wineList.do">목록보기</a>&nbsp;&nbsp;<a href = "delete.do?bId=${content_view.bId}">삭제</a></td>
				
			</tr>
		</form>
	</table>
</body>
</html>