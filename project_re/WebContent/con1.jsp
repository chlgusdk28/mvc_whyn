<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<style type="text/css">

.con_list{background: rgba(0,0,0,0.7); width: 100%; padding:50px 0; position:fixed; bottom:0; left:0; color:#fff; }
.con_list form{margin:0 auto; color:#fff;}
.con_list input{color:#fff; padding:5px; margin:5px;}
.form_text{font-size:13px; color:#fff; padding:5px;}
.i_01{color:#333;}
.form_allbox{width:500px; margin:0 auto; clear: both;}
.box_1{width:340px; float: left;}
.bb{text-align:center; border:0; width:100px; height:25px;color:#333; font-weight: bold; margin-top:15px;padding:20px; background: transparent;}
.box_2{float:left; box-shadow: 2px 2px #333; text-align:center; width:110px;
border-radius:10px; margin-top:15px; background:#997f49; height:30px; padding:20px;}
.box_2:hover{box-shadow: 4px 4px 4px #333 inset;}
</style>
<meta charset="UTF-8">
<title></title>
</head>
<body>


<div class="con_list">
	<form action="con.do" method="get">
		<div class="form_allbox">
			<div class="box_1">
				<p class="form_text">전화번호 혹은 카톡 아이디를 입력해 주세요.</p>
				<input type="radio" id="kakao" name="c_no" value="kakao" checked>카카오톡 상담
				<input type="radio" id="tel" name="c_no" value="tel">전화상담<br><br>
				<input type="text" placeholder="전화번호 or 카톡아이디" 
				size="34" class="i_01" name="con_info" id ="con_text" style="color:#333;">
			</div>
				<div class="box_2">
					<input type="submit" value="상담요청하기" class="bb" id="con_button" style="color:#333;">
				</div>
			
		</div>
	</form>
</div>

</body>
</html>