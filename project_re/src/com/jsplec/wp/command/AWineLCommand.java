package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AWLDao;
import com.jsplec.wp.dto.AWLDto;

public class AWineLCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		AWLDao wdao = new AWLDao();
		ArrayList<AWLDto> dtos = wdao.wineListShow();
		int wineViewRowCount = wdao.wineViewRowCount();
		int RowCount = wineViewRowCount;

		
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
		request.setAttribute("wineListShow", dtos);
		
	}

}
