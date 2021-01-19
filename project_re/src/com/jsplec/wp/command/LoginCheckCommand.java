package com.jsplec.wp.command;

import java.util.regex.Pattern;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jsplec.wp.dao.UloginDao;
import com.jsplec.wp.dto.LoginDto;

public class LoginCheckCommand implements ACommand {
	


	
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");	
		String loginFiloginFieldCheckMessage;
		String idPattern="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";;
		LoginDto dto = null;
		loginFiloginFieldCheckMessage = "회원정보를 확인해주세요.";
		
		
		if(userpw.length()==0) {
			loginFiloginFieldCheckMessage = "비밀번호를 입력해주세요.";
			
		}
		if(userid.length()==0) {
			loginFiloginFieldCheckMessage = "아이디를 입력해주세요.";
			
		} 
		if(userid.length()==0&&userpw.length()==0) {
			loginFiloginFieldCheckMessage = "아이디와 비밀번호를 입력해주세요.";
			
		}
		
		if(userid.length()>0) {
			if(Pattern.matches(idPattern, userid)){}else {
				loginFiloginFieldCheckMessage = "올바른 아이디(이메일)가 아닙니다.";
				
			}
		}
		
		dto = new LoginDto(loginFiloginFieldCheckMessage,userid,userpw);
		
		
		
		request.setAttribute("user", dto);
		// TODO Auto-generated method stub
		
	}

}
