package com.jsplec.wp.dto;

import java.sql.Timestamp;

public class ACLDto {
	
	
	int cno;
	String cusername;
	String cuserid;
	String ctitle;
	String ccontent;
	Timestamp cdate;
	String counselingSearchBox;
	String counselingSearchBar;
	int cviewcount;
	String canswer;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ACLDto(int cno, String cusername, String cuserid, String ctitle, String ccontent, Timestamp cdate,
			int cviewcount, String canswer) {
		super();
		this.cno = cno;
		this.cusername = cusername;
		this.cuserid = cuserid;
		this.ctitle = ctitle;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.cviewcount = cviewcount;
		this.canswer = canswer;
	}







	public ACLDto(int cno, String cusername, String cuserid, String ctitle, String ccontent, Timestamp cdate,
			 String canswer) {
		super();
		this.cno = cno;
		this.cusername = cusername;
		this.cuserid = cuserid;
		this.ctitle = ctitle;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.canswer = canswer;
	}







	public String getCanswer() {
		return canswer;
	}







	public void setCanswer(String canswer) {
		this.canswer = canswer;
	}







	public ACLDto(int cno, String cusername, String cuserid, String ctitle, String ccontent, Timestamp cdate,
			int cviewcount) {
		super();
		this.cno = cno;
		this.cusername = cusername;
		this.cuserid = cuserid;
		this.ctitle = ctitle;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.cviewcount = cviewcount;
	}







	public int getCviewcount() {
		return cviewcount;
	}







	public void setCviewcount(int cviewcount) {
		this.cviewcount = cviewcount;
	}







	public String getCounselingSearchBox() {
		return counselingSearchBox;
	}







	public void setCounselingSearchBox(String counselingSearchBox) {
		this.counselingSearchBox = counselingSearchBox;
	}







	public String getCounselingSearchBar() {
		return counselingSearchBar;
	}







	public void setCounselingSearchBar(String counselingSearchBar) {
		this.counselingSearchBar = counselingSearchBar;
	}







	public ACLDto(String counselingSearchBox, String counselingSearchBar) {
		super();
		this.counselingSearchBox = counselingSearchBox;
		this.counselingSearchBar = counselingSearchBar;
	}







	public ACLDto(int cno, String cusername, String cuserid, String ctitle, String ccontent, Timestamp cdate) {
		super();
		this.cno = cno;
		this.cusername = cusername;
		this.cuserid = cuserid;
		this.ctitle = ctitle;
		this.ccontent = ccontent;
		this.cdate = cdate;
	}







	public int getCno() {
		return cno;
	}







	public void setCno(int cno) {
		this.cno = cno;
	}







	public String getCusername() {
		return cusername;
	}







	public void setCusername(String cusername) {
		this.cusername = cusername;
	}







	public String getCuserid() {
		return cuserid;
	}







	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}







	public String getCtitle() {
		return ctitle;
	}







	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}







	public String getCcontent() {
		return ccontent;
	}







	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}







	public Timestamp getCdate() {
		return cdate;
	}







	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}







	
	
	
	

}
