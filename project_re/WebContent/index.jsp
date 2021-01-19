<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.movie_back{background: #000; z-index:-1; margin:0px auto; width:110%; height:850px; overflow:hidden; text-align:ceneter;position:relative; top:-250px; left:-10%;}
.empty_box{width:100%; height:850px; position:absolute; left:0; top:0; background:rgba(0,0,0,0.7);}
.movie_back iframe{text-align:ceneter; }
.m_textBox{position:absolute; top:350px; left:30%; z-index:333; color:#fff;}
.m_textBox .b_box{font-size:50px; border:1px #997f49 solid; padding:20px; margin:20px 0;}
.m_textBox .b_box:hover{background:#997f49;border:1px #fff solid; color:#fff;}
.con_box{width:1280px; margin:-200px auto;}
.con_box div{width:400px; height:300px; margin:10px; background:#997f49; float:left; }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>당신이 와인을 먹는 N가지 이유 WHYN</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="movie_back">
	<div class="m_textBox">
		<p style="color:#997f49;">당신이 와인을 좋아하는 N가지 이유</p>
		<div class="b_box">당신의 퍼스널<br>
			와인구독 서비스 <span style="color:#997f49;">WHYN</span></div>
		<p style="line-height:30px;">당신의 소믈리에가 당신만을 기다리고 있습니다.<br>
			알기어려운 와인을 쉽게 즐길 수 있도록 준비되어있습니다.</p>
	</div>
	<div class="empty_box"></div>
	<iframe width="2400" height="1100" src="https://www.youtube.com/embed/PaAjkVs-c0s?rel=0&modestbranding=1&autoplay=1&loop=1&playlist=PaAjkVs-c0s&rel=0&mute=1"
	frameborder="0" allow="accelerometer; autoplay; clipboard-write;  encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
	</iframe>
</div>

<div class="con_box">

	<div>컨텐츠 1</div>
	<div>컨텐츠 2</div>
	<div>컨텐츠 3</div>
	
</div>

<%@ include file="footer.jsp" %>
</body>
</html>