package com.jsplec.wp.command;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.UloginDao;
import com.jsplec.wp.dto.joinDto;

public class JoinCheckCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		
		
		String username = request.getParameter("username");
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String userpwCheck = request.getParameter("userpwCheck");
		String usergender = request.getParameter("usergender");
		String usertel = request.getParameter("usertel");
		String useraddress = request.getParameter("useraddress");
		String birthYear = request.getParameter("birthYear");
		String month = request.getParameter("month");
		String date = request.getParameter("date");
		
		//주소 추가 1206 최현아
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");		
		
		//주소2추가 1207 최현아
		//int userno = (int)session.getAttribute("USERNO");
		
		String daddress1 = request.getParameter("daddress1");
		String daddress2 = request.getParameter("daddress2");
		String daddress3 = request.getParameter("daddress3");	
		
		
		String idChkMsg="";//사용가능아이디 일때 (((사용가능 메세지))) 계속출력 
		String pwChkMsg="";// 비밀번호가 일치할때 (((비밀번호일치 메세지))) 계속출력
		String pwCheckmessage=""; // 비밀번호가 불일치할때 (((불일치메세지))) 계속출력
		String pwCheckField="";// 비밀번호가 일치할때 (((비밀번호확인 텍스트필드 값 유지 불일치할땐 공백값))) 
		String fieldCheckmessage="";//필드체크메세지
		String ageCheck="";
		String useremail="";// ?
		String emailP= "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		String telP = "^\\d{3}-\\d{3,4}-\\d{4}$";
		String onlyN="^[0-9]*$";
		String birthYearMsg="";
		String telMsg="";
		String telMsgEx="";
		String joinCheck = "ok";// ok일때 로그인
		String userage=birthYear+month+date;
	
		UloginDao dao = new UloginDao();
		if(birthYear.length()>0) {
			if(Integer.parseInt(birthYear)>2020) {
				
				ageCheck="미래에서 오셧군요 ^^";
			}else if(Integer.parseInt(birthYear)<1920) {
				joinCheck="1";	
				ageCheck="정말인가요?";
			}
		}

//		if(address3.length()==0) {
//			fieldCheckmessage="주소를 입력해 주세요.";
//			joinCheck="1";
//		}
		
		if(usertel.length()==0) {
			fieldCheckmessage="전화번호를 입력해 주세요.";
			joinCheck="1";	
		}
		
		
		if(username.length()==0) {
			fieldCheckmessage="이름을 입력해 주세요.";
			joinCheck="1";		
		}		
		if(userpw.length()==0) {
			fieldCheckmessage="비밀번호를 입력해 주세요.";
			joinCheck="1";			
		}
		if(userpw.length()==0) {
			joinCheck="1";		
		}
		if(userpw.equals(userpwCheck)) {}else {
			pwCheckmessage="비밀번호가 일치하지 않습니다.";
			joinCheck="1";
		}
		
		if(userid.length()==0) {
			fieldCheckmessage="아이디를 입력해 주세요.";
			joinCheck="1";		
		}
		
			if(dao.joinIdCheck(userid)>0) {
					fieldCheckmessage="중복된 아이디 입니다.";
					joinCheck="1";   
				}else if(Pattern.matches(emailP, userid)){
					idChkMsg = "사용가능한 아이디 입니다.";
				
			}else {
				
				fieldCheckmessage="올바른 아이디(이메일)가 아닙니다."; 
				joinCheck="1";	
			}
		
		
		if(userpw.length()>0&&userpw.equals(userpwCheck)) {
			pwChkMsg="비밀번호가 일치합니다.";
			pwCheckField=userpwCheck; // 일치할때만 패스워드텍스트창값 유지
		}
		
		
		if(usertel.length()>0) {
			if(Pattern.matches(telP, usertel)) {}else {
				telMsg="올바른 전화번호가 아닙니다.";
				telMsgEx=" ex)010-1111-2222";
				joinCheck="1";	
			}
		}
		if(birthYear.length()>0) {
			if(Pattern.matches(onlyN, birthYear)) {}else {
				birthYearMsg="숫자만 입력해 주세요!";
				joinCheck="1";	
			}
		}
		
		
		
		if(Pattern.matches(emailP, userid)) {}else {fieldCheckmessage="올바른 아이디(이메일)가 아닙니다."; }
		

		if(joinCheck.equals("ok")) {
			dao.join(username, userid, userpw, usergender, userage, usertel, address1, address2, address3);
			dao.d_join(userid, daddress1, daddress2, daddress3);
		}
		
		request.setAttribute("PWCMSG", pwCheckmessage);//비밀번호불일치 메세지
		request.setAttribute("PWCFIELD", pwCheckField);//비밀번호확인 값이 일치할경우 비밀번호확인값 유지
		request.setAttribute("PWC", pwChkMsg);//비밀번호일치 메세지
		request.setAttribute("IDC",idChkMsg );//사용가능한아이디 메세지
		request.setAttribute("JOIN", joinCheck);//로그인 성공여부
		request.setAttribute("ageCheck", ageCheck);//생년 1920~2021 체크
		request.setAttribute("telMsg", telMsg); //전화번호 정규식
		request.setAttribute("telMsgEx", telMsgEx);// 전화번호 ex
		request.setAttribute("birthYearMsg", birthYearMsg);
	
		joinDto joindto = new joinDto(username,userid,userpw,userpwCheck,usergender,birthYear,usertel,useraddress,fieldCheckmessage);
		request.setAttribute("joinfield", joindto);
		
		
		
	}



}
