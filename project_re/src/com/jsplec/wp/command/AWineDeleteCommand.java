package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AWLDao;

public class AWineDeleteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		AWLDao cdao = new AWLDao();
		
		String[] deleteCheck = request.getParameterValues("deleteCheck");
	      //AUserLDao userdao = new AUserLDao();
	      for(int i=0;i<deleteCheck.length;i++) {
	    	  cdao.wineDelete(deleteCheck[i]);
	    	  
	    	  System.out.println(deleteCheck[i]);
	}

}
}//----------------------------