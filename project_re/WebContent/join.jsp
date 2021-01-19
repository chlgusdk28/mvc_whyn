<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<meta charset="utf-8">
<style type="text/css">

<%
	request.setCharacterEncoding("utf-8");
%>
</style>
<script language="javascript">
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
		
		document.form.roadAddrPart1.value = roadAddrPart1;
		
		document.form.addrDetail.value = addrDetail;
		
		document.form.zipNo.value = zipNo;				
}


</script>

<title>Insert title here</title>
</head>
<%@ include file="header.jsp" %>
<body class="join_us">
<style>
body{background: linear-gradient(#fffaef, #999); text-align:center;}
.join_us .l_title{text-align:center; color:#997f49; padding: 40px; font-size:55px; letter-spacing: -2px;}
.join_us .j_table{margin:0 auto; width:380px;}
.join_us .j_table td{text-align: center; padding:5px; width:305px; }
.join_us .j_table th{_border-bottom: 2px #999 dotted; width:30px; color:#997f49; text-align:left; padding:5px;}
.join_us .j_table td input{width:210px;}
</style>



<c:set var="fieldCheck" value="${joinfield.fieldCheckmessage}"></c:set>
<h1 class="l_title">JOIN_US</h1>
<form action="joincheck.do" method="post">
	<table class="j_table">
		<!--  아이디 입력창       -->
		<tr>
			<th>ID</th>
			<td><input type="text" name="userid" value="${joinfield.userid}" placeholder="아이디를 입력해주세요."></td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${fieldCheck eq '아이디를 입력해 주세요.'||fieldCheck eq '중복된 아이디 입니다.' ||fieldCheck eq '올바른 아이디(이메일)가 아닙니다.'}" ><font size="2" color="red"><c:out value="${fieldCheck }"></c:out></font></c:if>
				<font size="2" color="green">${IDC}</font>
			</td>
		</tr>
		<!--  아이디 입력창       -->
		
		
		<!--  비밀번호 입력창       -->
		<tr>
			<th>PW</th>
			<td>
			<input type="password" name="userpw" value="${joinfield.userpw}" placeholder="비밀번호를 입력해주세요."></td>
		</tr>
		<tr>
			<td colspan="2"><c:if test="${fieldCheck eq '비밀번호를 입력해 주세요.'}" ><font size="2" color="red"><c:out value="${fieldCheck}"></c:out></font></c:if></td>
		</tr>
		<!--  비밀번호 입력창       -->
			
		<!--  비밀번호 확인창       -->

		<tr>
			<th>PW 확인</th>
			<td><input type="password" name="userpwCheck" value="${PWCFIELD}" placeholder="비밀번호 확인."></td>
		</tr>
		<tr>
			<td colspan="2"><font size="2" color="red">${PWCMSG}</font>
			<font size="2" color="green">${PWC}</font>
			
			</td>
		</tr>
		
		<!--  비밀번호 확인창       -->
		
		<!--  이름입력       -->
		
		<tr>
			<th>NAME</th>
			<td><input type="text" name="username" value="${joinfield.username }" placeholder="이름을 입력해주세요."></td>
		</tr>
		<tr>
			<td colspan="2"><c:if test="${fieldCheck eq '이름을 입력해 주세요.'}" ><font size="2" color="red"><c:out value="${fieldCheck }"></c:out></font></c:if></td>		
		</tr>
		
		<!--  이름입력       -->

		<!--  성별 체크       -->
		<tr>
		<th>GENDER</th>
			<td>
				<select name="usergender" style="text-align:center;  width:225px; height: 29px;">
					<option value="" >선택안함</option>
					<option value="남자" >남자</option>
					<option value="여자" >여자</option>
				</select>

			</td>
		</tr>
		<!--  성별 체크       -->
		
		<!--  생년월일 입력  -->

		<tr>
			<th style="padding-top: 15px;">BIRTHDAY</th>
			<td style="padding-top: 10px;">
				<input type="text" name = "birthYear" placeholder="년도"
				value="${joinfield.userage}" maxlength="4" 
				onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" style="width:70px;">

				<!----------- 월  ----- ------>
				<select name="month" style="width:50px; height: 29px">
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<c:forEach begin="10" end="12" varStatus="status">
					<option value="${status.current}">${status.current}</option>
					</c:forEach>							
				</select>
				<span style="font-size: 13px; color:#666;"> 월</span>	
				
				<!----------- 월  ----- ------>
				
				
				<!----------- 월  ----- ------>
				<select name = "date" style="width:50px; height: 29px">
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<c:forEach begin="10" end="31" varStatus="status">
						<option value="${status.current}">${status.current}</option>
					</c:forEach>			
				
				</select><span style="font-size: 13px; color:#666;"> 일</span>				
				<!-- 일 -->
			</td>
		
		</tr>
	
		<tr>
			<td colspan="2"><font size="2" color="red">${ageCheck}${birthYearMsg }</font></td>
		</tr>
		
		<!--  생년월일 입력  -->
		
		<!-- 전화번호 입력 -->
		
		<tr>
			<th>TEL</th>
			<td>
				<input type="text" placeholder="- 포함해서 적어주세요." name="usertel" value="${joinfield.usertel}" maxlength="14">
			</td>
		</tr>
		<tr>
			<td colspan="2"><font size="2" color="red">${telMsg}</font><font size="2">${telMsgEx }</font></td>
		</tr>
		
		<!-- 전화번호 입력 -->
		
		<!-- 주소 입력 -->
	</table>	
<style>
.join_us .in1{background: #fff; border:1px #997f49 solid; color:#997f49;}
.join_us .bbb {margin:0 auto; width:400px; height: 250px; padding-bottom:10px; border-bottom:1px #999 dotted; border-top:1px #999 dotted;}
.join_us .bbb input{margin: 5px;}
.join_us #sample4_roadAddress{width:247px;}
.join_us #sample4_detailAddress{width:247px;}
.join_us #sample4_roadAddress2{width:247px;}
.join_us #sample4_detailAddress2{width:247px;}
</style>
<script>
$(document).ready(function(){
	$("#asd").click(function(){
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
	});
})
</script>
<div class="bbb" style="padding-bottom:0;">	
<p style="padding:30px; color:#997f49; font-weight: bold;">ADDRESS</p>	
<input type="text" id="sample4_postcode" placeholder="우편번호" name="address1">
<input type="button" class="in1" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address2"><br>

<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address3">
<p style="color:#666; font-size:12px; padding-top:10px;"><input type="checkbox" id="asd" name="d_check">주소와 배송지가 일치하면 체크해주세요</p>

</div>


<div class="bbb" style="border-top:0; margin-bottom:20px;">	
<p style="padding:30px; color:#997f49; font-weight: bold;">D_ADDRESS</p>	
<input type="text" id="sample4_postcode2" placeholder="우편번호" name="daddress1">
<input type="button" class="in1" onclick="sample4_execDaumPostcode2()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress2" placeholder="도로명주소" name="daddress2"><br>

<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="sample4_detailAddress2" placeholder="상세주소" name="daddress3">

</div>

	<div style="padding:20px; margin-bottom:30px;">
		<input class="in1" type="submit" value="회원가입" id="test0101" style="padding:10px;">
	</div>


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
</form>		


	
<%@ include file="footer.jsp" %>	

</body>
</html>