<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.ctable{width: 300px; margin: 0 auto; padding: 30px;}


</style>
<script type="text/javascript">
function update(){

		alert("작성이 완료되었습니다.");
	
}



</script>
<%@include file="adminCategory.jsp" %>
<title>새로운 문의 확인</title>
</head>
<body>

<!-- ㅣ  조회수 :${cviewCount } -->

<form action="ACounselingAnswerCommand.do" method="post">

	<table  class="ctable" >
		
		<tr> <td>문의번호 : <input type="text" readonly="readonly" value="${counselingContentView.cno }" style="width: 20px; border: none;" > </td></tr>
		<tr> <td><input type="text" value="${counselingContentView.cusername}" readonly="readonly" > </td> </tr>
		<tr> <td><input type="text" value="${counselingContentView.cuserid }" readonly="readonly" ></td> </tr>
		<tr> <td><input type="text" value="${counselingContentView.ccontent}" readonly="readonly" > </td> </tr>
		<tr> <td><input type="text" value="${counselingContentView.cdate}" readonly="readonly"></td> </tr>
		
		<tr><td><input type="hidden" value="${counselingContentView.cno }" name="cno">
		<tr> <td> <textarea rows="10" cols="30" name="canswer" placeholder="답변을 작성해 주세요. 답변 작성 시 새로운 현황에서 제외됩니다."></textarea>
		<tr><td> <input type="submit"  value='작성하기' onclick="update()"> </td> </tr>
	</table>
	</table>
	<table class="ctable">
	 	<tr><td> 
	
	
	
	<tr><td> <input type="submit"  value='돌아가기'/> </td> </tr> <!-- 누르면 꺼지게 해야됨. -->
	</table>

</form>	

	


	
	
	
</body>
</html>