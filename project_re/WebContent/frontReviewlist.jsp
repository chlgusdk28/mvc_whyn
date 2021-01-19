<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객님들의 생생 리뷰를 소개해드립니다.</title>
</head>
<body>
<%@ include file="header.jsp" %>

<!-- <script>
$(document).ready(function(){
	
	$(".low").click(function(){
		var i = $(this).index(); 
		$(".low2").eq(i-1).fadeIn();
		$(".b_bg").fadeIn();
	});
	
	$(".b_bg").click(function(){
		$(this).fadeOut();
		$(".low2").fadeOut();
	});
		
	
});

</script> -->

<style type="text/css">
.container{width:100%; background:#fff; text-align:center; font-size:13px; color:#333;}
.container .title{font-size:20px; text-align: center; padding:20px;}
.tablebg{background-image: url("img/tablebg.jpg");background-repeat:repeat; background-position: center 20%; background-size: 1920px; width:100%; height:300px;}
.low_box{width:850px; margin:20px auto; padding-bottom:100px;}
.low{width:260px;overflow: hidden; margin:10px; float:left; height:420px; box-shadow: 5px 5px 5px #999; border:1px #997f49 solid; border-radius: 20px;}
.low p{padding:5px;}
.low p:nth-child(1){background:#997f49; height:200px;}
.low p:nth-child(2){font-size:15px; color:#997f49; font-weight: bold;}
</style>

<div class="container">

	<div class="tablebg"></div>
		<div class="low_box">
		<div style="clear:both; padding:10px; border:1px #997f49 solid; width:70px; height:20px; font-weight: bold; margin:20px auto;">
			<a href="frontReviewAlert.jsp" style="color: #997f49;">글쓰기 클릭</a>
		</div>
				<c:forEach items="${list}" varStatus="status" var="frontReviewListDto">
				
				<%-- <input id="test" value="${status.count}"> --%>
				
					<a href="frontReviewView.do?reno=${frontReviewListDto.reno}">
						<div class="low">
					
						<p>이미지 자리 ~~</p>
						<p style="height:50px;">"${frontReviewListDto.retitle}"</p>	
						<c:forEach begin="1" end="${frontReviewListDto.rescore}" ><font color="#FFD700">★</font> </c:forEach>
						<c:forEach begin="${frontReviewListDto.rescore+1}" end="5"><font color="#ccc">☆</font></c:forEach>
						<p style="color:#999;font-weight: bold;">${frontReviewListDto.reinsertdate}</p>
						<p style="padding:2px; padding-top:10px; color:#999;">와인 품질 : ${frontReviewListDto.rq1}</p>	
						<p style="padding:2px; color:#999;">서비스 품질 : ${frontReviewListDto.rq2}</p>	
						<p style="padding:2px; color:#999;">배송 일정 : ${frontReviewListDto.rq3}</p>	
						<!-- 좋아요 출력해야 하는 부분 -->
						<%-- <p style=" text-align: right; padding-right:20px; color:#ff0067;">LIKE ${frontReviewListDto.reviewcount}</p>	 --%>

	
					<%-- <td><a href="noticeContent.do?nno=${NoticeDto.nno}">${NoticeDto.ntitle}</a></td> --%>
					</div>	
				</a>

			</c:forEach>
	</div>
	

<%-- 	<p style="padding:20px;"></p>
		<c:forEach begin="1" end="${totalPage}" varStatus="status">
			<a href="NoticeLPagingCommand.do?page=${status.count}">[${status.count}]</a>	
		</c:forEach>
	<p style="padding:20px;"></p> --%>
	</div>
	
<style>
.like{text-align: right; padding-right:20px; font-size:20px;}
.like a{color:#ff0067; font-size:15px;}
#nempty{_display:none;}
</style>



<style>
	.low2{width:800px;overflow: hidden; float:left; border:1px #fff solid;}
	.low2{display:none; position: fixed; top:30%; left:30%; z-index: 999;}
	.b_bg{background: rgba(0,0,0,0.7); position:fixed; top:0; left:0; height: 100%; width:100%; z-index: 1; display: none;}
	.low2 .box:nth-child(1){background:#997f49; height:350px; width:400px; float:left;}
	.low2 .box:nth-child(2){background: #fff; height:330px; width:380px; padding:10px; float:left; overflow: scroll;}
</style>
<!-- <script type="text/javascript">
$(document).ready(function(){
	if($("#nempty").css("display") == "none"){
		$("#empty").click(function(){
			$(this).hide();
			$("#nempty").show();
		});
	}else{
		$("#nempty").click(function(){
			$(this).hide();
			$("#empty").show();
		});
	}
});
</script> -->
<%-- <% 

		String aa = (String)session.getAttribute("check");

		if(aa == "a"){
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("$('.b_bg').fadeIn();");
			out.println("});");
	
			out.println("</script>");
			
		}

		String check = "b"; 
		session.setAttribute("check", check);	
%>		 --%>
		
			<c:forEach items="${list}" var="frontReviewListDto" varStatus="status">
				
					<div class="low2">
						<div class="box">이미지 자리 ~~</div>
						<div class="box">
							<div class="like">
							<%-- ${status.count} --%>
								<div id="empty"><a href="likeAlert.jsp?reno=${frontReviewListDto.reno}&num=1" class="aaa">좋아요</a></div>
								<div id="nempty"><a href="likeAlert.jsp?reno=${frontReviewListDto.reno}&num=0" class="aaa">싫어요</a></div>
								${frontReviewListDto.reno}
							</div>
							<p style="height:50px;">"${frontReviewListDto.retitle}"</p>	
							<c:forEach begin="1" end="${frontReviewListDto.rescore}" ><font color="#FFD700">★</font> </c:forEach>
							<c:forEach begin="${frontReviewListDto.rescore+1}" end="5"><font color="#ccc">☆</font></c:forEach>
							<p style="color:#999;font-weight: bold;">${frontReviewListDto.reinsertdate}</p>
							<p style="padding:2px; padding-top:10px; color:#999; font-size:13px;">와인 품질 : ${frontReviewListDto.rq1} / 서비스 품질 : ${frontReviewListDto.rq2} / 배송 일정 : ${frontReviewListDto.rq3}</p>	
							<p style="padding-top: 20px;">
								<%-- ${frontReviewListDto.reuserid} 님의 후기입니다.<br> --%>
								${frontReviewListDto.recontent}<br>
							</p>
						</div>
					</div>	
					
			</c:forEach>
			
<div class="b_bg"></div>			
			
<%@ include file="footer.jsp" %>
</body>
</html>