package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ACLDao;

public class ACounselingDeleteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ACLDao cdao = new ACLDao();
				
				String[] deleteCheck = request.getParameterValues("deleteCheck");
			      //AUserLDao userdao = new AUserLDao();
			      for(int i=0;i<deleteCheck.length;i++) {
			    	  cdao.counselingDelete(deleteCheck[i]);
			    	  
			    	  System.out.println(deleteCheck[i]);
			    	  
			    	 
	}
			      

}
}//---------------------------------