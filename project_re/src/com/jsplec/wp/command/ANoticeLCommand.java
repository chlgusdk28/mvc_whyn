package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ANLDao;
import com.jsplec.wp.dto.ANLDto;

public class ANoticeLCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ANLDao ndao = new ANLDao();
		ArrayList<ANLDto> dtos = ndao.noticeManagementList();
		int noticeViewRowCount = ndao.noticeViewRowCount();
		int RowCount = noticeViewRowCount;

		
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
		request.setAttribute("noticeManagementList", dtos);
		
	}

}
