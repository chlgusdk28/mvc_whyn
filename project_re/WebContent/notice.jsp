<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WHYN 공지사항</title>
</head>
<body>
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
.common_table .low{border:1px solid #333; }
.container .b{float:left;}
.container .b:nth-child(1){width:200px; text-align: left;}
.container .b:nth-child(2){width:650px; text-align: right;}
.container .b:nth-child(2) input{padding:3px;}
.container .b:nth-child(2) select{height:25px;}
.container .innerTable{width:850px; margin:0 auto;}
</style>


<%@ include file="header.jsp" %>

<div class="container">
	<div class="tablebg"></div>
	
	<div class="innerTable">
	<div style="padding:20px 0;">
			<p class="b"> 총 <%=request.getAttribute("allcount")%>건 / 금일 : <%=request.getAttribute("todaycount")%>건</p>
			
			<form class="b" action="NoticeSearchCommand.do" method="post">
		
			<select name="nSearchBox">
				<option value="nno" >번호</option>
				<option value="ntitle">제목 </option>
				<option value="ncontent">내용</option>
				<option value="ninsertdate">작성날짜 </option>
			</select>
			
			<input type="text" placeholder="번호/제목/내용/작성날짜를 입력 해주세요." name="nSearchBar" value="${setNSearch.nSearchBox }" size="32">
			<input type="submit"value="검색" class="bbb">
			

			</form>
	
	</div>
		<table class="common_table">
			<tr>
				<th>NO</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
			
			<c:forEach items="${list}" var="NoticeDto" begin="${beginNum }" end="${endNum}">
				<tr class="low">
					<td>${NoticeDto.nno}</td>	
					<td><a href="noticeContent.do?nno=${NoticeDto.nno}">${NoticeDto.ntitle}</a></td>
					<td>${NoticeDto.ninsertdate}</td>
					<td>${NoticeDto.nviewcount}</td>
				</tr>		
			</c:forEach>
			<tr>
				<td colspan="5"></td>
				
			</tr>
		</table>
	<p style="padding:20px;"></p>
		<c:forEach begin="1" end="${totalPage}" varStatus="status">
			<a href="NoticeLPagingCommand.do?page=${status.count}">[${status.count}]</a>	
		</c:forEach>
	<p style="padding:20px;"></p>
	</div>
	
</div>
<%@ include file="footer.jsp" %>
</body>
</html>