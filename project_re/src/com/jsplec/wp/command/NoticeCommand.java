package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.NoticeDao;
import com.jsplec.wp.dto.NoticeDto;

public class NoticeCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		NoticeDao NoticeDao = new NoticeDao();
		ArrayList<NoticeDto> NoticeDtos = NoticeDao.list();	
		request.setAttribute("list", NoticeDtos);
	
		int noticeViewRowCount = NoticeDao.noticeViewRowCount();
		int RowCount = noticeViewRowCount;
		int todaycount = NoticeDao.todayCount();
		int todaycount2 = todaycount;
		request.setAttribute("todaycount", todaycount2);

		
		int allcount = NoticeDao.allCount();
		int allcount2 = allcount;
		request.setAttribute("allcount", allcount2);
		
		
		//ArrayList<NoticeDto> NoticeDtos1 = NoticeDao.list1();	
		//int allcount = NoticeDao.noticeTodayContent();
		//NoticeDto = new NoticeDto(allcount, todaycount);
		
		
		
		int totalPage=(RowCount/10);
		if(RowCount%10!=0) {
			totalPage++;
		}

		int beginNum=0;
		int endNum=9;
		
		// 리스트
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);
		
	
	}

}
