package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jsplec.wp.dao.NoticeDao;
import com.jsplec.wp.dto.NoticeDto;

public class NoticeLPagingCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		NoticeDao NoticeDao = new NoticeDao();
		ArrayList<NoticeDto> NoticeDtos = NoticeDao.list();	
		
		System.out.println(NoticeDao.list());
		
		int noticeViewRowCount = NoticeDao.noticeViewRowCount();
		int RowCount = noticeViewRowCount;
		
		int nowPage = Integer.parseInt(request.getParameter("page"));
		
		
		int pageRow=10;
		int beginNum=(nowPage*pageRow)-pageRow;
		int endNum=(nowPage*pageRow)-1;
		int totalPage=(RowCount/pageRow);
		if(RowCount%10!=0) {
			totalPage++;
		}
		
//---------------------오늘 쓴글, 총쓴글 확인
		
		int todaycount = NoticeDao.todayCount();
		int todaycount2 = todaycount;
		request.setAttribute("todaycount", todaycount2);

		
		int allcount = NoticeDao.allCount();
		int allcount2 = allcount;
		request.setAttribute("allcount", allcount2);
		
//----------------------
		System.out.println("bNUM = "+beginNum);
		System.out.println("nNum = "+endNum);
		
		// 리스트
		request.setAttribute("list", NoticeDtos);
		//페이지
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);

	}

}
