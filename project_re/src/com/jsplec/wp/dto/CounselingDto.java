package com.jsplec.wp.dto;

public class CounselingDto {
	// 리스트 출력 
	private int cno;
	private String cusername;
	private String cuserid;
	private String ctitle;
	private String ccontent;
	private String cdate;
	private int cviewcount;
	private String canswer;
	private String canswerdate;
	
	//
	
	
	
	public CounselingDto(int cno, String cusername, String cuserid, String ctitle, String ccontent, String cdate,
			int cviewcount, String canswer, String canswerdate) {
		super();
		this.cno = cno;
		this.cusername = cusername;
		this.cuserid = cuserid;
		this.ctitle = ctitle;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.cviewcount = cviewcount;
		this.canswer = canswer;
		this.canswerdate = canswerdate;
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

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public int getCviewcount() {
		return cviewcount;
	}

	public void setCviewcount(int cviewcount) {
		this.cviewcount = cviewcount;
	}

	public String getCanswer() {
		return canswer;
	}

	public void setCanswer(String canswer) {
		this.canswer = canswer;
	}

	public String getCanswerdate() {
		return canswerdate;
	}

	public void setCanswerdate(String canswerdate) {
		this.canswerdate = canswerdate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
