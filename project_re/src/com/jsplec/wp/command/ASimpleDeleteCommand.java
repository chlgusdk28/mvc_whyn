package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ASCDao;

public class ASimpleDeleteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		
		 ASCDao dao = new ASCDao();
			
			String[] deleteCheck1 = request.getParameterValues("deleteCheck1");
		      //AUserLDao userdao = new AUserLDao();
		      for(int j=0;j<deleteCheck1.length;j++) {
		    	  dao.simpleDelete(deleteCheck1[j]);
		      }
	}

}
