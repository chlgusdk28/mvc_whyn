<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 메인 카테고리 jsp include -->
<%@ include file="adminCategory.jsp"%>

<style type="text/css">
.usertable {width:1000px; margin:0 auto; padding: 30px;}
.usertable td {padding: 5px;  width: 120px;}

h4{color: #5a5a5a;}
</style>

<title>배송 관리</title>
</head>
<body>
<br><br>

<h4 align="center"> 매달 15일 회원 정보 </h4>

	
	<form action="ADeliveryLCommand.do" method="post">
	<table class="usertable" >
		
		
		<tr><td> <input type="hidden" value="${fiveContentView.duserid }"  name="duserid" ></td></tr>
		
		
	<tr>
		 <td  align="right">아이디 : </td>
		 <td> <input type="text" readonly="readonly" value="${fiveContentView.duserid }" name="duserid"> </td> 
	 </tr>
		 
		 
	<tr>
		 <td  align="right" > 수취인 이름 : </td>
		<td ><input type="text" value="${fiveContentView.dusername }" name="dusername" readonly="readonly" > </td>
	 </tr>
	 
	<tr> 
			<td align="right">수취인 전화번호 : </td>
			<td><input type="text" value="${fiveContentView.dtel }" name="dtel" readonly="readonly"> </td>
	 </tr>
	<tr> 
			<td align="right"> 구독기간 :  </td>
			<td><input type="text" value="${fiveContentView.speriod }" name="speriod" readonly="readonly"> </td>
	</tr>
	<tr>
			<td align="right"> 병 수 :  </td>
			<td><input type="text" value="${fiveContentView.sbottle }" name="sbottle" readonly="readonly"> </td>
	</tr>
	<tr>
		<td align="right"> 결제 금액 : </td>
		<td><input type="text" value="${fiveContentView.sprice}" name="sprice"  readonly="readonly"> </td> 
	</tr>
	<tr>
		<td align="right">우편번호 : </td>
		<td><input type="text" value="${fiveContentView.daddress1}" name="daddress1"  readonly="readonly"> </td> 
	</tr>
	<tr>
		 <td align="right">도로명 주소 : </td>
		 <td><input type="text" value="${fiveContentView.daddress2}" name="daddress2" readonly="readonly" > </td> 
	 </tr>
	<tr> 
		<td align="right">상세 주소 : </td>
		<td><input type="text" value="${fiveContentView.daddress3}" name="daddress3"  readonly="readonly"> </td>
	 </tr>
	<tr>
	 	<td align="right">구독 시작일  : </td>
		<td> <input type="text" value="${fiveContentView.startdate}" name="startdate" readonly="readonly"></td>
	 </tr>
	<tr>
	 	<td align="right">구독 종료일  : </td>
		<td> <input type="text" value="${fiveContentView.enddate}" name="enddate" readonly="readonly"></td>
	 </tr>
	<tr>
		<td colspan="2" align="right"> <input type="submit" value="뒤로가기"  class="button" >  </td> 
	</tr>
	</table>
	</form>
	
	
	
	
	
	
</body>
</html>