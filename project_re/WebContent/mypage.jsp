<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
</script>
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
                document.getElementById('useraddress1').value = data.zonecode;
                document.getElementById("useraddress2").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
          
                
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

<!-- 배송지 정보  -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode1() {
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
                document.getElementById('daddress1').value = data.zonecode;
                document.getElementById("daddress2").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
          
                
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
<title>my page</title>
 

</head>
<body>

<%@ include file="header.jsp" %>
<style>
body{background: linear-gradient(#fffaef, #999); text-align:center; color:#997f49;}
.u_info{width:470px; margin:0 auto; text-align: center;}
.u_info .title{border-bottom:2px #997f49 dotted; font-weight:bold; color:#997f49; font-size:30px; margin:20px auto; text-align:center; padding-top:40px;}
.u_info .subtitle{font-size:12px; color:#666;}
.u_info table{text-align: left; margin:30px auto; border:4px #997f49 double; padding:50px; background:rgba(255,255,255,0.5)}
.u_info table td{padding:10px;}
.u_info table th{color:#666;}
.u_info table td input{border:1px #997f49 solid; background: #fff; color:#997f49;}

</style>

<section class="u_info">
<div class="title" style="padding-bottom:10px;">My Page information</div>
<p class="subtitle"><%=session.getAttribute("USERNAME")%>님의 정보를 안내해 드립니다. 
수정버튼을 눌러 수정하실 수 있습니다.</p>
<form action="mypageUpdate.do" method="post">
<table>
	<tr>
		<th>ID</th>
		<td><%=session.getAttribute("USERID")%></td>
	</tr>
	<tr>
		<th>NAME</th>
		<td> <input type="text" value="<%=session.getAttribute("USERNAME")%>" name="username" id="username"></td>
	
	</tr>
	<tr>
		<th>TEL</th>
		<td><input type="text" value="${userinfo.usertel}" name="usertel" id="usertel"></td>

	</tr>
	<tr>
		<th>우편번호</th>
		<td> <input type="text" value="${userinfo.useraddress}" name="useraddress1" id="useraddress1"></td>
		<td><input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"></td>
	
	</tr>
	<tr>
		<th>도로명주소</th>
		<td><input type="text" value="${userinfo.useraddress2}" name="useraddress2" id="useraddress2"></td>

		
	</tr>
	<tr>
		<th>상세주소</th>
		<td><input type="text" value="${userinfo.useraddress3}" name="useraddress3" id="useraddress3"></td>

	</tr>
	<!-- -------------------------배송지 정보-------------------------- -->
	<tr class="title"><td colspan="3" style="padding-top:50px; font-size:20px;">배송지 정보</td></tr>
	
	<tr> 
		<th>수령인</th>
		<td><input type="text" name="dusername"  value="${deliveryView.dusername }"></td></tr>
	<tr> 
		<th>TEL</th>
		<td><input type="text" name="dtel" value="${deliveryView.dtel }" > </td></tr>
	
	<tr>
		<th>우편번호</th>
		<td><input type="text" value="${deliveryView.daddress1}" name="daddress1" id="daddress1"></td>
		<td><input type="button" onclick="sample4_execDaumPostcode1()" value="우편번호 찾기"></td>
	
	</tr>
	<tr>
		<th>도로명주소</th>
		<td><input type="text" value="${deliveryView.daddress2}" name="daddress2" id="daddress2"></td>

		
	</tr>
	<tr>
		<th>상세주소</th>
		<td><input type="text" value="${deliveryView.daddress3}" name="daddress3" id="daddress3"></td>

		<td></td>


	</tr>
	
	<tr>
		<th>배송메세지</th>
		<td><input type="text" value="${deliveryView.dmsg }" name="dmsg"></td></tr>
		
	<tr class="title"><td colspan="3" style="padding-top:50px; font-size:20px;">기타정보</td></tr>
	<tr>
		<th>성별</th>
		<td>${userinfo.usergender}</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>${userinfo.userjoindate}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td><input type="text" value="${userinfo.userbday}" name="userbday" ></td>
	</tr>
	<tr>
		<th>구독여부</th>
		<td><input type="text" value="<c:if test="${userinfo.usersubscribe eq '1'}">구독중</c:if>
		<c:if test="${userinfo.usersubscribe eq '0'}"></c:if>" name="usersubscribe" readonly="readonly" style="border:0; background: transparent;"></td>
	</tr>
	<tr>
		<td colspan="3" style="text-align: center;">
			<input type="submit" value="수정하기" onclick="alert('수정이 완료되었습니다.')" style="padding:10px;">
		</td>
	</tr>
	
	</table>
	</form>
	
<style>
.table2 {text-align: center; width:470px; margin:0 auto; font-size:12px;}
.table2 th{background: #cfcfcf; padding:10px; color:#fff; text-align: center;}
.table2 td{text-align: center;}
</style>	
		<!--  구독정보 -->
	<table class="table2">
		<tr class="title"><td colspan="3" style="font-size:20px;">나의 구독정보</td></tr>
		<tr>
			<th>기간</th>
			<th>병수</th>
			<th>받는날짜</th>


		</tr>
		<tr>
			<td>${subscribe.speriod }</td>
			<td>${subscribe.sbottle }</td>
			<td>${subscribe.senddate }</td>

		</tr>
		<tr>
			<th>구독시작</th>
			<th>구독종료</th>
			<th>가격</th>
		</tr>
		
		<tr>
			<td>${subscribe.startdate }</td>
			<td>${subscribe.enddate }</td>
			<td>${subscribe.sprice }</td>
		</tr>
		
	</table>
	
<style>
.table3 {text-align: center; width:470px; margin:0 auto; font-size:12px;}
.table3 th{background: #cfcfcf; padding:10px; color:#fff; text-align: center;}
.table3 td{text-align: center;}
</style>
	<!--  리뷰 출력  -->
	<table class="table3">
		<tr class="title"><td colspan="4" style="font-size:20px;">내가쓴후기</td></tr>
	<tr>
		<th>제목</th>
		<th>평점</th>
		<th>입력날짜</th>
		<th>조회수</th>
	</tr>
	
	<c:forEach items = "${review }" var = "dto">
	<tr>
		<td><a href="">${dto.retitle}</a></td>
		<td>${dto.rescore }</td>
		<td>${dto.reinsertdate }</td>
		<td>${dto.reviewcount }</td>
	</tr>
	</c:forEach>
	</table>
	

	
	




</form>

</section>
<%@ include file="footer.jsp" %>
</body>

</html>