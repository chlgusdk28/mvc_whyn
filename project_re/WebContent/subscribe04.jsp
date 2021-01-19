<%@page import="java.util.Random"%>
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
<%
	Random random = new Random();
	int row = (int)request.getAttribute("rowcount");
	int ran = random.nextInt(row);
	
%>

<%@ include file="header.jsp" %>
<style>
body{background-image:url("img/woodbg.jpg"); color:#997f49; width:100%; }
.wine_box1{background:#fff; width:400px; padding:50px; border:double 5px #997f49; margin:50px auto; text-align: center;}
.wine_bbb{margin:20px auto;color:#333; width:80px; font-size:12px; padding:10px; border:1px #333 solid;}
.wine_bbb:hover{transition:0.3s; color:#997f49; border:1px #997f49 solid;}
</style>


<div class="wine_box1">
	<table>
	<p style="padding:20px; text-align:center; "><%=session.getAttribute("USERNAME")%> 님이 구독 받으실 와인 정보입니다.</p>
	<p style="font-size:12px;">해당 와인에 대해서 더 문의하실 사항이 있으시면,<br>하단의 상담하기 버튼이나 문의게시판을 이용해주세요.</p>
	
	<c:forEach items="${productItem}" var="SubDto" begin="<%=ran %>" end="<%=ran %>" >
		<tr>
			<td><img src="${pageContext.request.contextPath}/upload/${SubDto.pimage}" width="100"></td>
		</tr>
<%-- 		<tr>
			<td>제품 번호 : ${SubDto.pno}</td>
		</tr>  --%>
		
		<tr>
			<td style="font-family: serif; font-size:18px; font-weight: bold; letter-spacing: -1px;">" ${SubDto.pname } "</td>
		</tr>
		
		<tr>
			<td style="font-family: serif; padding-top:20px;">${SubDto.pcountry }</td>
		</tr>
		
		<tr>
			<td style="font-family: serif;">${SubDto.pcolor }</td>
		</tr>
		
		<tr>
			<td style="font-family: serif; font-size:12px; padding-top:10px;">${SubDto.ptext }</td>
		</tr>
		
		<tr>
			<td style="padding-top:10px;"> ALCOLE LEVEL : ${SubDto.pcontent }</td>
		</tr>
		<tr>
			<td>
				<a href="SubCommand3.do?pno=${SubDto.pno}"><div class="wine_bbb">와인 구독 완료</div></a>
			</td>
			
		</tr>
		</c:forEach>
	
		
	</table>
</div>	
	<%@ include file="footer.jsp" %>
</body>
</html>