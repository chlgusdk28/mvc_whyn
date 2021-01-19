package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AWLDao;
import com.jsplec.wp.dto.AWLDto;

public class AWineLPagingCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		AWLDao wdao = new AWLDao();
		ArrayList<AWLDto> dtos = wdao.wineListShow();
		int wineViewRowCount = wdao.wineViewRowCount();
		int RowCount = wineViewRowCount;
		
		// paging start
		
		
		int nowPage = Integer.parseInt(request.getParameter("page"));
		int pageRow=10;
		int beginNum=(nowPage*pageRow)-pageRow;
		int endNum=(nowPage*pageRow)-1;
		int totalPage=(RowCount/pageRow);
		if(RowCount%10!=0) {
			totalPage++;
		}
		
		
		
		System.out.println("bNUM = "+beginNum);
		System.out.println("nNum = "+endNum);
		System.out.println(totalPage);
		// 리스트
		request.setAttribute("wineListShow", dtos);
		//페이지
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);

	}

}
