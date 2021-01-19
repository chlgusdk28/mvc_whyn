package com.jsplec.wp.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.MyPageDao;
import com.jsplec.wp.dto.MyPageDto;



public class MyPageViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int userno = (int)session.getAttribute("USERNO");
		String userid = (String)session.getAttribute("USERID");
		MyPageDao dao = new MyPageDao();
		
		
		
		
		
		//user info 정보
		MyPageDto userinfoDto = dao.myPageUserinfoView(userno);
		request.setAttribute("userinfo", userinfoDto);
	
	
		//delivery 정보
		String duserid = (String)session.getAttribute("USERID");
		MyPageDao dao1 = new MyPageDao();
		MyPageDto deliverydto = dao1.deliveryUserinfoView(duserid);
		
		request.setAttribute("deliveryView",deliverydto );
		
		
		//review 정보
		ArrayList<MyPageDto> dtos = dao.myPageReviewView(userid);
		request.setAttribute("review", dtos);
		System.out.println("----------------");
		System.out.println(userid);
		System.out.println(dtos);
		
		
		//subscribe 정보
		MyPageDto subscribeDto = dao.myPageSubscribeView(userno);
		request.setAttribute("subscribe", subscribeDto);
		
		
		
		
		

	}

}
