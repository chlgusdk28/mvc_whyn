<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

	body{background-image:url("img/woodbg.jpg"); color:#997f49;}
	.s_content{width:800px; margin:100px auto; text-align:center; clear:both; background: rgba(0,0,0,0.7); border: 10px double #997f49;}
	.s_content input {padding:2px;}
	.content{ width:800px; text-align:center; margin:0 auto;}
	.s_content .title{font-size:50px; color:#997f49; padding:20px;}
	.content input{margin:20px;}
	.wine_label{float:left;background: #fcf1da; width:400px; margin:20px auto; height:500px;  border: 7px double #997f49;
	box-shadow: 3px 3px 3px #e7cf9d; box-sizing: border-box;}
	.wine_label img{width:400px;}
	.wine_label input {border:0; background:transparent; font-size:20px; color:#997f49; text-align: center;}
	
	.gudok01{display:none; width:320px; height:300px; padding:100px; margin:20px auto; border:10px #333 double; text-align:left;}
	.gudok01 .gq{font-size:50px; font-weight: bold;}
	#g11 input{border:1px solid #997f49; padding:5px; background:transparent; font-size: 20px; color:#997f49;width:140px; height:60px;}
	#g11{text-align: center;}
	#g11 input:hover{cursor:pointer; background:#997f49; border:1px solid #fff; color:#fff; transition:all 0.3s;}
	
	.a1234{color:#997f49; font-size:40px; position: fixed; right:18%; top:15%; display:none; text-shadow:2px 2px 2px #000;}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
    document.addEventListener('scroll', function() {
        var currentScrollValue = document.documentElement.scrollTop;
        
        if (currentScrollValue > 100){
        	$("#g1").fadeIn();
        	$(".a1234").fadeIn();
        	$(".a1234").text("1/11");
        }if(currentScrollValue > 600){
        	$("#g2").fadeIn()
        	$(".a1234").text("2/11");
        }if(currentScrollValue > 1100){
        	$("#g3").fadeIn()
        	$(".a1234").text("3/11");
        }if(currentScrollValue > 1600){
        	$("#g4").fadeIn()
        	$(".a1234").text("4/11");
        }if(currentScrollValue > 2100){
        	$("#g5").fadeIn()
        	$(".a1234").text("5/11");
        }if(currentScrollValue > 2600){
        	$("#g6").fadeIn()
        	$(".a1234").text("6/11");
        }if(currentScrollValue > 3100){
        	$("#g7").fadeIn()
        	$(".a1234").text("7/11");
        }if(currentScrollValue > 3600){
        	$("#g8").fadeIn()
        	$(".a1234").text("8/11");
        }if(currentScrollValue > 4100){
        	$("#g9").fadeIn()
        	$(".a1234").text("9/11");
        }if(currentScrollValue > 4600){
        	$("#g10").fadeIn()
        	$(".a1234").text("10/11");
        }if(currentScrollValue > 5100){
        	$("#g11").fadeIn()
        	$(".a1234").text("11/11");
        }if(currentScrollValue > 5400){
        	$("#g11").fadeIn()
        }
    });
    
</script>

<title>WHYN 와이엔 구독</title>
</head>
<body>

<%@ include file="header.jsp" %>
<script>

$(document).ready(function() {
 	let today = new Date();   
	let year = today.getFullYear(); // 년도
	let month = today.getMonth() + 1;  // 월
	let date = today.getDate();  // 날짜
	let day = today.getDay();  // 요일
 
	//alert(year+".."+month+".."+date);
	$("#startDate").val(year+'년'+month+'월'+date+'일');
	
	var per = $("#period").val();
	
	if (per == "1년"){
		var ee_year = year+1;
		$("#endDate").val(ee_year+"년"+month+"월"+date+"일");

	}else{
		var e_month = month+6;
		 	if(e_month>12){
				e_month = e_month-12;
				var e_year = year+1;
			} 
	 	$("#endDate").val(e_year+"년"+e_month+"월"+date+"일");
	 	
	}
});
</script>



<div class="s_content">
<div class="a1234">1/11</div>
	<div class="content">
		<div class="tititi">
			<div style="padding:10px;"><img src="img/s_logo.png?" width="400px;"></div>
			<!--p class="title">WHYN 구독서비스 신청하기</p-->
			<p style="color:#666">"WHYN은 고퀄리티의 서비스를 위해 1달 간격으로, 최대 3병으로 제한하고 있습니다"</p>
			<p><img src="img/s_logo02.png" width="400px;"></p>
			<p style="font-size:12px; padding-bottom:50px;">WHYN의 고객 맞춤 서비스를 즐겨보세요</p>	
		</div>
	
		<form action="subscribe02.do" method="post">
		<input type="hidden" id="startDate" name="startDate">
		<input type="hidden" id="endDate" name="endDate">
		
			<div class="gudok01" id="g1">
				<p><span class="gq">Q1.</span> 당신이 구독을 원하는</p>
				<p style="text-align: right;">기간을 선택해주세요.</p>
				<p style="padding:20px;">
					<input type="radio" id="period" name="period" value="6개월" checked>6개월동안 구독하겠습니다.<br>
					<input type="radio" id="period" name="period" value="1년">1년동안 구독하겠습니다. 
				</p>
			</div>	
			
			<div class="gudok01" id="g2">
				<p><span class="gq">Q2.</span> 1달에 받길 원하는</p>
				<p style="text-align: right;">와인 병수를 선택해주세요.</p>
				<p style="padding:20px;">
				
					<input type="radio" id="" name="bottle" value="1병" checked>1병씩 받기를 원합니다.<br> 
					<input type="radio" id="" name="bottle" value="2병">2병씩 받기를 원합니다. <br>
					<input type="radio" id="" name="bottle" value="3병">3병씩 받기를 원합니다. 
				</p>
			</div>				
					
			<div class="gudok01" id="g3">
				<p><span class="gq">Q3.</span> 매달 받길 원하는</p>
				<p style="text-align: right;">날짜를 선택해주세요</p>
				<p style="padding:20px;">
				
					<input type="radio" id="" name="cal" value="매달5일" checked>매달 5일 마다<br>
					<input type="radio" id="" name="cal" value="매달10일">매달 10일 마다<br>
					<input type="radio" id="" name="cal" value="매달20일">매달 20일 마다 
				</p>
			</div>	

					
			<div class="gudok01" id="g4">
				<p><span class="gq">Q4.</span> 당신은 와인을</p>
				<p style="text-align: right;">경험해 본 적이 있습니까?</p>
				<p style="padding:20px;">	
					<input type="radio" name="sq1" value="1" checked>네, 경험해본적이 있습니다.<br>
					<input type="radio" name="sq1" value="2">아니오, 처음입니다.
				</p>
			</div>						
			
			<div class="gudok01" id="g5">
				<p><span class="gq">Q5.</span> 좋아하는 와인 산지가</p>
				<p style="text-align: right;">구세계입니까, 신세계입니까?</p>
				<p style="padding:20px;">	
					<input type="radio" name="sq2" value="1" checked>구세계<br>
					<input type="radio" name="sq2" value="2">신세계
				</p>
			</div>	
					
			<div class="gudok01" id="g6">
				<p><span class="gq">Q6.</span> 만약 당신이 와인을 고른다면</p>
				<p style="text-align: right;">좋아하는 종류는 어떻게 되십니까?</p>
				<p style="padding:20px;">	
					<input type="radio" name="sq3" value="1" checked>Red<br>
					<input type="radio" name="sq3" value="2">White<br>
					<input type="radio" name="sq3" value="3">Chapagne
				</p>
			</div>	
			
			<div class="gudok01" id="g7">
				<p><span class="gq">Q7.</span> 당신의 와인 고르는 기준에서</p>
				<p style="text-align: right;">바디감은 어떤것을 선호합니까?</p>
				<p style="padding:20px;">	
					<input type="radio" name="sq4" value="1" checked>Full<br>
					<input type="radio" name="sq4" value="2">Med<br>
					<input type="radio" name="sq4" value="3">Low
				</p>
			</div>	
			
			<div class="gudok01" id="g8">
				<p><span class="gq">Q8.</span> 당신의 와인 고르는 기준에서</p>
				<p style="text-align: right;">당도는 어떤것을 선호합니까?</p>
				<p style="padding:10px;">	
					<input type="radio" name="sq5" value="1" checked>달지 않은것<br>
					<input type="radio" name="sq5" value="2">조금 단것<br>
					<input type="radio" name="sq5" value="3">적당히 단것<br>
					<input type="radio" name="sq5" value="4">단 것<br>
					<input type="radio" name="sq5" value="5">매우 단것 
				</p>
			</div>		
			<div class="gudok01" id="g9">
				<p><span class="gq">Q9.</span> 당신의 와인 고르는 기준에서</p>
				<p style="text-align: right;">산도는 어떤것을 선호합니까?</p>
				<p style="padding:10px;">	
					<input type="radio" name="sq6" value="1" checked>시지 않은것<br>
					<input type="radio" name="sq6" value="2">조금 신것<br>
					<input type="radio" name="sq6" value="3">적당히 신것<br>
					<input type="radio" name="sq6" value="4">신 것<br>
					<input type="radio" name="sq6" value="5">매우 신것 
				</p>
			</div>
								
			<div class="gudok01" id="g10">
				<p><span class="gq">Q10.</span> 당신의 와인 고르는 기준에서</p>
				<p style="text-align: right;">탄닌감(부드러운정도)은 어떤것을 선호합니까?</p>
				<p style="padding:20px;">	
					<input type="radio" name="sq7" value="1" checked>Soft<br>
					<input type="radio" name="sq7" value="2">Med
					<input type="radio" name="sq7" value="3">Though
				</p>
			</div>
			<div class="gudok01" id="g11">
				<div>구독신청하기를 누르시면,<br>결제하실 수 있는 창으로 안내해드립니다.</div>
				<input type="submit" value="구독신청하기" id ="ss_button">
			</div>
		</form>

	</div>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>