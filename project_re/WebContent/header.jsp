<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<link rel="stylesheet" href="common.css">
<title>당신이 와인을 먹는 N가지 이유 WHYN</title>
</head>
<body>

<script type="text/javascript">
	
    document.addEventListener('scroll', function() {
        var currentScrollValue = document.documentElement.scrollTop;
        //console.log('currentScrollValue is ' + currentScrollValue);
        
        if(currentScrollValue == 0){
        	$(".con_list").fadeIn();
        	$('.header_menu').css('position', 'static');
        	
        }else if (currentScrollValue > 100){
        	$(".con_list").fadeOut();
        	$('.header_menu').css('position', 'fixed');
        	$('.header_menu').css('top', '0');
        }
    });
    
   $(document).ready(function(){
	   
	   $(".s_button").mouseenter(function(){
		   $(this).stop().animate({padding : "15px"})
	   })
	   $(".s_button").mouseleave(function(){
		   $(this).stop().animate({padding : "10px"})
	   })
	   
		$(".aaaa").click(function(){
		   $(".mypage_pop").slideToggle();
	   })
	   
		$(".xxx").click(function(){
		   $(".mypage_pop").hide();
	   })	   
	   
   });

</script>

<style>
.mypage_pop{display:none; background: #fff; position: fixed; top:0; right:0; width: 200px; height:100%;}
</style>


<div class="mypage_pop">
		<p class="xxx">X</p>
</div>


<div class="header">
	<div class="logo"><a href="index.jsp"><img src="img/m_logo.png" width="120px"></a></div>
	<div class="user_info">
			<ul class="user_list">
				
				<li>
					<a href="LoginSub.jsp"><div class="s_button">구독신청하기</div></a>
				</li>
				<%
					String userid = (String)session.getAttribute("USERID");
					if(userid == null || userid == ""){
						out.println("<li id = 'logout' style='display:none;'><a href='logout.do'>Loout</a></li><li id = 'login'><a href='login.jsp'>Login</a></li>");
					}else{
						out.println("<li id = 'logout' ><a href='logout.do'>Loout</a></li><li id = 'login' style='display:none;'><a href='login.jsp'>Login</a></li>");
					}
				%>
			
				
				<li>|</li>
				<li><a href="join.jsp">JoinUs</a></li>
				<li>|</li>
				<li><a href="mypage_login.jsp" class="test111">MyPage</a></li>
			</ul>
	</div>
	
<!-- 	<div class="logo">
		<a href="index.jsp" style="color:#ffc213;"><img src="img/logo2.png?"></a>
	</div> -->
	
	
	<div class="header_menu">
		<ul class="menu_list">
			<a href="brand.jsp"><li style="color:#997f49; font-weight: bold;">BRAND</li></a>
			<li>|</li>
			<a href="service.jsp"><li>서비스소개</li></a>
			<li>|</li>
			<a href="counseling.jsp"><li>고객문의</li></a>
			<li>|</li>
			<a href="notice.do"><li>공지사항</li></a>
			<li>|</li>
			<a href="frontReviewlist.do"><li>REVIEW</li></a>
			
		</ul>
	</div>
</div>

<%@ include file="con1.jsp" %>
</body>
</html>