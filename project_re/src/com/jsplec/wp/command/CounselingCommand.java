package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.CounselingDao;
import com.jsplec.wp.dto.CounselingDto;

public class CounselingCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String userid = (String)session.getAttribute("USERID");
		
		
		System.out.println(userid);
		CounselingDao dao = new CounselingDao();
		ArrayList<CounselingDto> dtos = dao.counselingList(userid);
		int RowCount = dao.counselingListCount(userid);
		int allcount = dao.allCount(userid);
		int answerCount = dao.answerCount(userid);
		
		int totalPage=(RowCount/10);
		if(RowCount%10!=0) {
			totalPage++;
		}

		int beginNum=0;
		int endNum=9;
		
		
		
		
		request.setAttribute("counselingList", dtos);//내가쓴 문의 리스트
		request.setAttribute("allcount", allcount);//내가쓴 문의 카운트
		request.setAttribute("answerCount", answerCount);//답변받은 문의 카운트
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
	}

}
