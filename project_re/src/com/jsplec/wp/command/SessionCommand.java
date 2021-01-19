package com.jsplec.wp.command;

import java.io.FileOutputStream;
import java.io.OutputStream;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.jsplec.wp.dao.SubscribeDao;
import com.jsplec.wp.dto.SubDto;

public class SessionCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

	try {
		System.out.println("123123123");
		//1207최현아 추가 
		String userid = (String)session.getAttribute("USERID");
		System.out.println("@");
		SubscribeDao dao = new SubscribeDao();
		System.out.println("@@");
		SubDto SubDtoDtos = dao.list(userid);
		System.out.println("@@@");
		
		request.setAttribute("list", SubDtoDtos);
		
		///
		
		String directory = request.getServletContext().getRealPath("classification/");
		OutputStream output = new FileOutputStream(directory+"knn_test.txt");

		
		String startDate = (String)request.getParameter("startDate");
		session.setAttribute("STARTDATE", startDate);
		
		String endDate = (String)request.getParameter("endDate");
		session.setAttribute("ENDDATE", endDate);
		
		String period = (String)request.getParameter("period");
		session.setAttribute("PERIOD", period);

		String bottle = (String)request.getParameter("bottle");
		
		String price = "";
		
		if(period.equals("6개월")&&bottle.equals("1병")){
			price="120,000원";
		}else if(period.equals("6개월")&&bottle.equals("2병")){
			price="210,000원";
		}else if(period.equals("6개월")&&bottle.equals("3병")){
			price="300,000원";
		}else if(period.equals("1년")&&bottle.equals("1병")){
			price="198,000원";
		}else if(period.equals("1년")&&bottle.equals("2병")){
			price="368,000원";
		}else if(period.equals("1년")&&bottle.equals("3병")){
			price="528,000원";
		}
				
		session.setAttribute("PRICE", price);
		
		session.setAttribute("BOTTLE", bottle);
		String cal = (String)request.getParameter("cal");
		session.setAttribute("CAL", cal);
		String sq1 = (String)request.getParameter("sq1");
		session.setAttribute("sq1", sq1);
			String sq1a;
			if(sq1.equals("1")){
				sq1a="Yes";
			}else{
				sq1a="No";
			}
		session.setAttribute("sq1a", sq1a);
		
		
		String sq2 = (String)request.getParameter("sq2");
		session.setAttribute("sq2", sq2);
		String sq2a;
			if(sq2.equals("1")){
				sq2a="구세계";
			}else{
				sq2a="신세계";
			}
		session.setAttribute("sq2a", sq2a);
		
		
		String sq3 = (String)request.getParameter("sq3");
		session.setAttribute("sq3", sq3);
		String sq3a;
		if(sq3.equals("1")){
			sq3a="Red";
		}else if(sq3.equals("2")){
			sq3a="White";
		}else {
			sq3a="Chapagne";
		}
		session.setAttribute("sq3a", sq3a);
		
		
		String sq4 = (String)request.getParameter("sq4");
		session.setAttribute("sq4", sq4);
		String sq4a;
		if(sq4.equals("1")){
			sq4a="Full";
		}else if(sq4.equals("2")){
			sq4a="Med";
		}else {
			sq4a="Low";
		}
		session.setAttribute("sq4a", sq4a);
		
		String sq5 = (String)request.getParameter("sq5");
		session.setAttribute("sq5",sq5);
	
		String sq5a;
		if(sq5.equals("1")){
			sq5a="달지 않은것";
		}else if(sq5.equals("2")){
			sq5a="조금 단것";
		}else if(sq5.equals("3")){
			sq5a="적당히 단것";
		}else if(sq5.equals("4")){
			sq5a="단 것";
		}else{
			sq5a="매우 단것 ";
		}
		
		session.setAttribute("sq5a", sq5a);
		
		String sq6 = (String)request.getParameter("sq6");
		session.setAttribute("sq6",sq6);
		String sq6a;
		if(sq6.equals("1")){
			sq6a="시지 않은것";
		}else if(sq6.equals("2")){
			sq6a="조금 신것";
		}else if(sq6.equals("3")){
			sq6a="적당히 신것";
		}else if(sq6.equals("4")){
			sq6a="신 것";
		}else{
			sq6a="매우 신것 ";
		}
		session.setAttribute("sq6a", sq6a);
		
		String sq7 = (String)request.getParameter("sq7");
		session.setAttribute("sq7", sq7);
		String sq7a;
		if(sq7.equals("1")){
			sq7a="Soft";
		}else if(sq4.equals("2")){
			sq7a="Med";
		}else {
			sq7a="Tough";
		}
		session.setAttribute("sq7a", sq7a);
		
		String str ="1 6 1\r";
	    String str1 = sq1 + ".000000"+ " " + sq2 + ".000000"+ " " +  sq3 + ".000000"+ " " +  sq4 + ".000000"+ " " +  sq5 + ".000000"+ " " +  sq6 + ".000000"+ " " +  sq7 + ".000000";
	    				
	
		 byte[] by=str.getBytes();
		    byte[] by1=str1.getBytes();
		    output.write(by);
		    output.write(by1);
		    
	}catch (Exception e) {
		// TODO: handle exception
	}
	}

}
