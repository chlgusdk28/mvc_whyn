<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<style>
body{background-image:url("img/woodbg.jpg"); color:#997f49; width:100%; }
.guinfo p{width:60%; border-bottom:1px #997f49 dotted; margin: 0 auto; padding:10px;}
.guinfo{width:700px; padding:50px;  margin:50px auto; text-align: left; background: rgba(255,255,255,0.8);display:none; font-size: 13px;}
.w_box{width:100%; height:500px; overflow:hidden; margin:0 auto;}
.w_boximg{width:2000px; text-align: center; float:left; overflow: hidden; position: absolute; left:0; top:200px;}
.find_w{display:none; position:absolute; left:20%; bottom: 0;}
</style>

<script>
$(document).ready(function(){
	$('.w_boximg').animate({
	    left:-350
	},2000,function(){
		 $('.aa12').toggle(function() { 
		       $(".aa12").animate({top: '-=200px'}, 500);
		     }, function() {
		       $(".aa12").animate({top: '+=100px'}, 500,function(){
		    	   $(".guinfo").fadeIn();
		    	   $(".w_box").fadeOut();
		    	  
		    	   
		       });
		     });
		
	});
	
})

</script>

<div class="find_w">
	<img src="img/wine.png" width="200px;">
</div>
<div class="w_box">
	<P class="w_boximg">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa1313">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">
		<img src="img/wine.png" width="100px;" class="aa12">						
	</P>
</div>
<div class="guinfo">
	<div style="font-weight: bold;"><%=session.getAttribute("USERNAME")%>님의 구독 정보입니다.</div>
	<p>구독기간 : <%=session.getAttribute("PERIOD")%></p>
	<p>구독 시작일 : <%=session.getAttribute("STARTDATE")%></p>
	<p>구독 종료일 : <%=session.getAttribute("ENDDATE")%></p>
	<p>결제금액 : <%=session.getAttribute("PRICE")%></p>
	<p>매달 받는 병수 : <%=session.getAttribute("BOTTLE")%></p>
	<p>매달 받길 원하는 날짜 : <%=session.getAttribute("CAL")%></p>
	
	<div style="padding-top:50px; padding-bottom:20px; font-weight: bold;">결제 완료하면 당신에게 구독될 와인에 대한 정보를 안내해 드립니다 </div>
	<p>와인 경험여부 : <%=session.getAttribute("sq1a")%></p>
	<p>좋아하는 산지 : <%=session.getAttribute("sq2a")%></p>
	<p>좋아하는 와인 종류 : <%=session.getAttribute("sq3a")%></p>
	<p>선호하는 바디감 : <%=session.getAttribute("sq4a")%></p>
	<p>선호하는 당도 : <%=session.getAttribute("sq5a")%></p>
	<p>선호하는 산도 : <%=session.getAttribute("sq6a")%></p>
	<p>선호하는 탄닌감 : <%=session.getAttribute("sq7a")%></p>
	
	<br>
	<!-- <p>결제 완료하면 당신에게 구독될 와인에 대한 정보를 안내해 드립니다.</p> -->
	
	<div style="font-weight: bold; padding:30px 0;">수령인 정보 (배송지 수정이 가능합니다)</div>
	
	<style>
	.a9999 p input{border:1px #997f49 solid; color:#997f49;}
	.a9999 .in1{margin-left:10px;}
	.aff{width:210px; margin:50px auto; text-align:center; padding-bottom:70px;}
	.a99 input{border:0; background: transparent; color:#997f49; font-weight: bold;}
	.a99 {float:left;width:78px; padding:10px; border:1px #997f49 solid; color:#997f49; background: #fff; font-weight: bold;}

	</style>
	<form action="subscribe03.do" method="post">
	<input type="hidden" value="${list.duserid}" name="duserid">
	<div class="a9999">
		<p> 이름 : <%=session.getAttribute("USERNAME")%></p>
		<p> 수령자  : <input type="text" value="${list.dusername}" name="dusername"></p>
		<p> 전화번호 : <input type="text" value="${list.dtel}" name="dtel"></p>
		<p> 우편번호 : <input type="text" id="sample4_postcode2" value="${list.daddress1}" name="daddress1"><input type="button" class="in1" onclick="sample4_execDaumPostcode2()" value="우편번호 찾기"></p>
		<p> 주소 : <input type="text" id="sample4_roadAddress2" value="${list.daddress2}" name="daddress2"> 
			<input type="text" id="sample4_detailAddress2" value="${list.daddress3}" name="daddress3"></p> 
	</div>
	
	<div class="aff">
		<div class="a99" style="padding:5px;  margin-right:10px;"><input type="submit" value="결제하기"></div>
		<a href="priceCheck.jsp"><div class="a99">메인화면으로</div></a>
	</div>
	</form>
	
	
</div>
<%@ include file="footer.jsp" %>
</body>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                
            	if($("input[name='d_check']").prop('checked')==true){
            		var a1 = $("#sample4_postcode").val();
            		var a2 = $("#sample4_roadAddress").val();
            		var a3 = $("#sample4_detailAddress").val();

            	    $("#sample4_postcode2").val(a1);
            	    $("#sample4_roadAddress2").val(a2);
            	   	$("#sample4_detailAddress2").val(a3);
            	}else{
            		 $("#sample4_postcode2").val('');
            		 $("#sample4_roadAddress2").val('');
            	    $("#sample4_detailAddress2").val('');
            	}
            	
                //document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>

<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode2() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode2').value = data.zonecode;
                document.getElementById("sample4_roadAddress2").value = roadAddr;
            	if($("input[name='d_check']").prop('checked')==true){
            		var a1 = $("#sample4_postcode").val();
            		var a2 = $("#sample4_roadAddress").val();
            		var a3 = $("#sample4_detailAddress").val();

            	    $("#sample4_postcode2").val(a1);
            	    $("#sample4_roadAddress2").val(a2);
            	   	$("#sample4_detailAddress2").val(a3);
            	}else{
            		/*  $("#sample4_postcode2").val('');
            		 $("#sample4_roadAddress2").val('');
            	   	 $("#sample4_detailAddress2").val(''); */
            	}
                //document.getElementById("sample4_jibunAddress2").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress2").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress2").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</html>