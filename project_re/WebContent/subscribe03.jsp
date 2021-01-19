<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.removeAttribute("PRICE");
session.removeAttribute("PERIOD");
session.removeAttribute("BOTTLE");
session.removeAttribute("CAL");
session.removeAttribute("FIRSTQ");
session.removeAttribute("SECONDQ");
session.removeAttribute("THIRDQ");
session.removeAttribute("FOURTHQ");
session.removeAttribute("FIFTHQ");
session.removeAttribute("FNUM");
session.removeAttribute("SNUM");
session.removeAttribute("TNUM");
session.removeAttribute("FFNUM");
session.removeAttribute("FFFNUM");



String userno = (String)session.getAttribute("userno");

String sitem = null;
String directory = request.getServletContext().getRealPath("classification/");
FileReader fr = new FileReader
		(directory+"knn_prediction.txt"); //파일읽기객체생성
BufferedReader br = new BufferedReader(fr); //버퍼리더객체생성

sitem=br.readLine();

session.setAttribute("sitem", sitem);
session.setAttribute("userno", userno);

%>

<script>
location.href = "subscribe04.do?items<%=userno%>"
</script>
<h3>당신이 구독한 와인 <%=sitem%></h3>

	<form action="subscribe04.do">
	<table>
	
		<tr>
			<td><input type="text" name="items" value="<%=userno%>">userno</td>
		</tr>
		<input type="submit" value="확인">
		
	</table>
</form>
</body>
</html>