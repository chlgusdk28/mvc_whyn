package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ACLDao;
import com.jsplec.wp.dao.ASCDao;
import com.jsplec.wp.dto.ACLDto;
import com.jsplec.wp.dto.ASCDto;

public class ACounselingLCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ACLDao cdao = new ACLDao();
		ArrayList<ACLDto> dtos = cdao.counselingManagementList();
		int counselingViewRowCount = cdao.counselingViewRowCount();
		int RowCount = counselingViewRowCount;

		ASCDao dao = new ASCDao();
		ArrayList<ASCDto> dtos1 = dao.simpleConList();
		request.setAttribute("simpleConList", dtos);
		
		//페이징
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
		request.setAttribute("counselingManagementList", dtos);
		request.setAttribute("simpleConList", dtos1);
		
	}

}
