package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ANLDao;
import com.jsplec.wp.dao.NoticeDao;
import com.jsplec.wp.dto.ANLDto;
import com.jsplec.wp.dto.NoticeDto;

public class NoticeViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String nno = request.getParameter("nno");
		
		NoticeDao NoticeDao = new NoticeDao();
		
		NoticeDto NoticeDto = NoticeDao.noticeContentView(nno);
		
		NoticeDao.nviewcount(nno);
		
		int viewCount = NoticeDao.nviewSelect(nno);
		
		String beforenotice = NoticeDao.beforeNotice(nno);
		String afternotice = NoticeDao.afterNotice(nno);
				
//		if (afternotice == null) {
//			afternotice ="이전글이 없습니다.";
//		}else {
//			afternotice = "이전글 : "+afternotice;
//		}
//		
//		if (beforenotice == null) {
//			beforenotice ="다음글이 없습니다.";
//		}else {
//			beforenotice = "다음글 : "+beforenotice;
//		}		

		
		String beforenoticeno = NoticeDao.beforeNoticeno(nno);
		String afternoticeno = NoticeDao.afterNoticeno(nno);
		
		
		request.setAttribute("noticeContentView", NoticeDto);
		request.setAttribute("viewCount",viewCount);
		request.setAttribute("beforenotice", beforenotice);
		request.setAttribute("afternotice", afternotice);
		request.setAttribute("beforenoticeno", beforenoticeno);
		request.setAttribute("afternoticeno", afternoticeno);
		
	}

}
