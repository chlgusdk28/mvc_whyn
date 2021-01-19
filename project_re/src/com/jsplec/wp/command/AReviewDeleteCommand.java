package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ARLDao;

public class AReviewDeleteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ARLDao reviewdao = new ARLDao();
		
		String[] deleteCheck = request.getParameterValues("deleteCheck");
	      //AUserLDao userdao = new AUserLDao();
	      for(int i=0;i<deleteCheck.length;i++) {
	    	  reviewdao.reviewDelete(deleteCheck[i]);
	    	  
	    	  System.out.println(deleteCheck[i]);
	}
	}

}
