package com.jsplec.wp.command;

import java.io.File;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.DeliveryUpdateDao;
import com.jsplec.wp.dao.SubscribeDao;
import com.jsplec.wp.dto.NoticeDto;
import com.jsplec.wp.dto.SubDto;

public class SubCommand implements ACommand {



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		String sprice = (String)session.getAttribute("PRICE");
		String speriod = (String)session.getAttribute("PERIOD");
		String sbottle = (String)session.getAttribute("BOTTLE"); 
		String senddate = (String)session.getAttribute("CAL");
		String sq1 = (String)session.getAttribute("sq1");
		String sq2 = (String)session.getAttribute("sq2"); 
		String sq3 = (String)session.getAttribute("sq3");
		String sq4 = (String)session.getAttribute("sq4");
		String sq5 = (String)session.getAttribute("sq5");
		String sq6 = (String)session.getAttribute("sq6");
		String sq7 = (String)session.getAttribute("sq7");
		
		
		
		
		String startdate = (String)session.getAttribute("STARTDATE");
		String enddate = (String)session.getAttribute("ENDDATE");
		int userno1 = (int)session.getAttribute("USERNO");
		String userno = Integer.toString(userno1);
		session.setAttribute("userno", userno);
		
		String duserid = request.getParameter("duserid");
		String dusername = request.getParameter("dusername");
		String dtel = request.getParameter("dtel");
		String daddress1 = request.getParameter("daddress1");
		String daddress2 = request.getParameter("daddress2");
		String daddress3 = request.getParameter("daddress3");
		
		System.out.println("duserid"+duserid);
		System.out.println("dusername"+dusername);
		System.out.println("dtel"+dtel);
		System.out.println("daddress1"+daddress1);
		System.out.println("daddress2"+daddress2);
		System.out.println("daddress3"+daddress3);
		
		SubscribeDao SubscribeDao = new SubscribeDao();
		SubscribeDao.Subscribe(speriod,sbottle,senddate,sq1,sq2,sq3,sq4,sq5,sq6,sq7,sprice,startdate,enddate,userno1);
		SubscribeDao.Subscribe2(userno1);
		
//		ArrayList<SubDto> SubDtoDtos = SubscribeDao.list(userno1);
//		request.setAttribute("list", SubDtoDtos);
		
		String directory = request.getServletContext().getRealPath("classification/");
		File file = new File(directory);
		System.out.println(file);
		knn knn1 = new knn();
		System.out.println("knn");
		knn1.knn(file+"/knn_train.txt",file+"/knn_test.txt",1,2);
		
		DeliveryUpdateDao dao = new DeliveryUpdateDao();
		dao.deliveryUpdate(duserid, dusername, dtel, daddress1, daddress2, daddress3);
		System.out.println("duserid"+duserid);
		System.out.println("dusername"+dusername);
		System.out.println("dtel"+dtel);
		System.out.println("daddress1"+daddress1);
		System.out.println("daddress2"+daddress2);
		System.out.println("daddress3"+daddress3);
		
	}

}
