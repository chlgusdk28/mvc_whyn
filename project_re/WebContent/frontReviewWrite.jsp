<%@page import="javax.crypto.AEADBadTagException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰쓰기</title>
<style>
.aa radio{width:30px; height:30px; font-size:20px;}
.container{border:2px #997f49 solid; width:500px; height:1000px; margin:50px auto; padding:30px;}
.qList01{width:360px; height:130px; margin:20px auto; text-align: center; clear:both; border-bottom:1px #997f49 dotted;}
.qList01 .q1{width:100px; padding:10px; margin-bottom:20px; float:left; font-size:12px;}
.q1t{font-size:40px; color:#997f49; font-weight:bold;}
.qList01 .tt{ color:#997f49; text-align: left; }
#star_grade{text-align: center; padding:10px;}
#star_grade a{text-decoration: none; color: gray; text-align: center; font-size:35px;}
#star_grade a.on{color:#997f49;}
</style>
</head>
<body>
<%@ include file="header.jsp" %>

<script>
$(document).ready(function(){
	$('#star_grade a').click(function(){
	    $(this).parent().children("a").removeClass("on");  /* 별점의 on 클래스 전부 제거 */ 
	    $(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
	    return false;
	});
	
	var star_grade = document.getElementById('star_grade'),
    a = star_grade.getElementsByTagName('a');
	for (var i = 0; i < a.length; i++) {
    (function(idx) {
        a[idx].onclick = function() {
        	$("#starScore").val(idx+1);
        }
    })(i);
}
/* 	const browseBtn = document.querySelector('.browse-btn');
	const realInput = document.querySelector('#real-input');

	browseBtn.addEventListener('click',()=>{
		realInput.click();
	}); */
	
});
</script>

<div class="container">
	<form action="frontReviewWrite.do" method="post" enctype="multipart/form-data">
		<p style="color:#997f49; text-align: center; font-size:25px; padding-top:20px; font-weight: bold" >구독서비스를 추천하시겠습니까?</p>
		<p id="star_grade">
	        <a href="#">★</a>
	        <a href="#">★</a>
	        <a href="#">★</a>
	        <a href="#">★</a>
	        <a href="#">★</a>
		</p>
		<input type="hidden" id="starScore" name="starScore">
		<div class="qList01">
			<p class="tt"><span class="q1t">Q1</span> 와인이 맘에 드시나요?</p>
				<p class="q1">
					<input type="radio" name="q1" value="맘에안들어요"  style="width:30px; height:30px; font-size:20px;">
					<br><span>맘에안들어요</span>
				</p> 
				<p class="q1">
					<input type="radio" name="q1" value="괜찮아요" style="width:30px; height:30px; font-size:20px;">
					<br><span>괜찮아요</span>
				</p> 
				<p class="q1">
					<input type="radio" name="q1" value="매우좋아요" checked style="width:30px; height:30px; font-size:20px;">
					<br><span>매우좋아요</span>
				</p>
		</div>	
	
		<div class="qList01">
		<p class="tt"><span class="q1t">Q2</span> 서비스에 만족하시나요?</p>
			<p class="q1">
				<input type="radio" name="q2" value="별로에요"  style="width:30px; height:30px; font-size:20px;">
				<br><span>별로에요</span>
			</p> 
			<p class="q1">
				<input type="radio" name="q2" value="괜찮아요" style="width:30px; height:30px; font-size:20px;">
				<br><span>괜찮아요</span>
			</p> 
			<p class="q1">
				<input type="radio" name="q2" value="매우만족해요" checked style="width:30px; height:30px; font-size:20px;">
				<br><span>매우만족해요</span>
			</p>
		</div>	
		<div class="qList01">
		<p class="tt"><span class="q1t">Q3</span> 원하는 날짜에 배송이 되었나요?</p>
			<p class="q1">
				<input type="radio" name="q3" value="늦게왔어요" style="width:30px; height:30px; font-size:20px;">
				<br><span>늦게왔어요</span>
			</p> 
			<p class="q1">
				<input type="radio" name="q3" value="제 날짜에 왔어요" style="width:30px; height:30px; font-size:20px;">
				<br><span>제 날짜에 왔어요</span>
			</p> 
			<p class="q1">
				<input type="radio" name="q3" value="예상보다 일찍왔어요" checked style="width:30px; height:30px; font-size:20px;">
				<br><span>예상보다 일찍왔어요</span>
			</p>
		</div>
		<div style="margin:0 auto; text-align:center;">
			<p style="color:#997f49; font-size:25px; padding:20px; font-weight: bold" >후기를 작성해주세요</p>
			<input type="text" name="retitle" placeholder="제목을 입력해주세요." style="margin: 20px; width:380px; padding:10px;">
			<textarea style="resize:none; text-align:left; width:360px; height:130px; padding:20px; clear:both;" placeholder="후기내용을 입력해주세요." name="rcontent"></textarea>
		</div>		
		<p style="text-align: center; padding:10px;">
			<input type="submit" value="확인" style="width:50px; height:30px; color:#997f49; border:1px #997f49 solid; background: #fff;">		
		</p>
		<p>
		이미지 : <input type="file" name="file">
		</p>
		
	</form>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>