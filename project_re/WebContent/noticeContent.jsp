<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container{width:100%; background:#fff; text-align:center; font-size:13px; color:#333;}
.container .title{font-size:20px; text-align: center; padding:20px;}
.tablebg{background-image: url("img/tablebg.jpg");background-repeat:repeat; background-position: center 20%; background-size: 1920px; width:100%; height:300px;}
.common_table{width:850px; margin:3px auto; box-shadow: 10px 10px 10px #999; background:#f9f8f8;}
.common_table td {padding: 5px;}
.common_table td a{color:#333;}
.common_table td a:hover{text-decoration: underline;}
.common_table tr th {background:#997f49; padding:10px; color:#fff;}
.common_table tr th:nth-child(1){width:40px;}
.common_table tr th:nth-child(2){width:600px;}
.common_table tr th:nth-child(3){width:150px;}
.common_table tr th:nth-child(4){width:60px;}
.common_table .low{border:1px solid #333; padding:15px; overflow: scroll;}
.container .b{float:left;}
.container .innerTable{width:850px; margin:0 auto;}
</style>
</head>
<body>
<%@ include file="header.jsp" %>

<%

String afternotice = (String)request.getAttribute("afternotice");
String beforenotice = (String)request.getAttribute("beforenotice");
String afternoticeno = (String)request.getAttribute("afternoticeno");
String beforenoticeno = (String)request.getAttribute("beforenoticeno");

if(afternoticeno==null){
	out.println("<script>");
	//out.println("alert('')");
	out.println("$(document).ready(function(){$('#test').hide(); $('.test02').text('이전글이 없습니다.')})");

	out.println("</script>");
}
if(beforenoticeno==null){
	out.println("<script>");
	//out.println("alert('')");
	out.println("$(document).ready(function(){$('#test1').hide(); $('.test02_1').text('다음글이 없습니다.')})");

	out.println("</script>");
}


%>




<div class="container">
	<div class="tablebg"></div>
	
	<div class="innerTable">
	<div style="padding:20px 0;">
		<p class="b">공지사항 입니다.</p>
		
	</div>
		<table class="common_table">
			<tr>
	
				<th>${noticeContentView.ntitle}</th>
				
			</tr>
			
			
				<tr class="low">
					<td colspan="2">${noticeContentView.ncontent}</td>	
				</tr>		
			
			<tr>
				<td colspan="2" style="border-top:1px solid #ccc;"><span class="test02"></span><a href="noticeContent.do?nno=<%=afternoticeno%>" id="test">이전글 : <%=afternotice%></a></td>
			</tr>
			<tr>
				<td colspan="2" style="border-top:1px solid #ccc;"><span class="test02_1"></span><a href="noticeContent.do?nno=<%=beforenoticeno%>" id="test1">다음글 : <%=beforenotice%></a></td>
			</tr>
		</table>

	</div>

	<div style="padding:20px;"><a href="notice.do">목록으로</a></div>
	
</div>

	<%@ include file="footer.jsp" %>
</body>
</html>