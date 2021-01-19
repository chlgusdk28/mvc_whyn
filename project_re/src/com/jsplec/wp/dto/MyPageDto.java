package com.jsplec.wp.dto;

public class MyPageDto {
	
	//user info
	private String usertel;
	private String useraddress1;
	private String useraddress2;
	private String useraddress3;
	private String usergender;
	private String userjoindate;
	private String userbday;
	private int usersubscribe;
	
	//review
	private int reno;
	private String reuserid;
	private String retitle;
	private int rescore;
	private String reinsertdate;
	private int reviewcount;
	
	//subscribe
	private int ssubno;
	private String speriod;
	private String sbottle;
	private String senddate;
	private int suserno;
	private String startdate;
	private String enddate;
	private String sprice;
	
	
	//delivery
	private String dtel;
	private String daddress1;
	private String daddress2;
	private String daddress3;
	private String dusername;
	private String dmsg;
	
	
	
	//---------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	//user info Dto
	public MyPageDto(String usertel, String useraddress1, String usergender, String userjoindate, String userbday,
			int usersubscribe) {
		super();
		this.usertel = usertel;
		this.useraddress1 = useraddress1;
		this.usergender = usergender;
		this.userjoindate = userjoindate;
		this.userbday = userbday;
		this.usersubscribe = usersubscribe;
	}

	public MyPageDto(String dtel, String daddress1, String daddress2, String daddress3, String dusername, String dmsg) {
		super();
		this.dtel = dtel;
		this.daddress1 = daddress1;
		this.daddress2 = daddress2;
		this.daddress3 = daddress3;
		this.dusername = dusername;
		this.dmsg = dmsg;
	}

	public String getDtel() {
		return dtel;
	}

	public void setDtel(String dtel) {
		this.dtel = dtel;
	}

	public String getDaddress1() {
		return daddress1;
	}

	public void setDaddress1(String daddress1) {
		this.daddress1 = daddress1;
	}

	public String getDaddress2() {
		return daddress2;
	}

	public void setDaddress2(String daddress2) {
		this.daddress2 = daddress2;
	}

	public String getDaddress3() {
		return daddress3;
	}

	public void setDaddress3(String daddress3) {
		this.daddress3 = daddress3;
	}

	public String getDusername() {
		return dusername;
	}

	public void setDusername(String dusername) {
		this.dusername = dusername;
	}

	public String getDmsg() {
		return dmsg;
	}

	public void setDmsg(String dmsg) {
		this.dmsg = dmsg;
	}

	public MyPageDto(String usertel, String useraddress1, String useraddress2, String useraddress3, String usergender,
			String userjoindate, String userbday, int usersubscribe) {
		super();
		this.usertel = usertel;
		this.useraddress1 = useraddress1;
		this.useraddress2 = useraddress2;
		this.useraddress3 = useraddress3;
		this.usergender = usergender;
		this.userjoindate = userjoindate;
		this.userbday = userbday;
		this.usersubscribe = usersubscribe;
	}

	public String getUseraddress1() {
		return useraddress1;
	}

	public void setUseraddress1(String useraddress1) {
		this.useraddress1 = useraddress1;
	}

	public String getUseraddress2() {
		return useraddress2;
	}

	public void setUseraddress2(String useraddress2) {
		this.useraddress2 = useraddress2;
	}

	public String getUseraddress3() {
		return useraddress3;
	}

	public void setUseraddress3(String useraddress3) {
		this.useraddress3 = useraddress3;
	}

	//review Dto
	public MyPageDto(int reno, String reuserid, String retitle, int rescore, String reinsertdate, int reviewcount) {
		super();
		this.reno = reno;
		this.reuserid = reuserid;
		this.retitle = retitle;
		this.rescore = rescore;
		this.reinsertdate = reinsertdate;
		this.reviewcount = reviewcount;
	}

	//subscribe Dto
	public MyPageDto(int ssubno, String speriod, String sbottle, String senddate, int suserno, String startdate,
			String enddate, String sprice) {
		super();
		this.ssubno = ssubno;
		this.speriod = speriod;
		this.sbottle = sbottle;
		this.senddate = senddate;
		this.suserno = suserno;
		this.startdate = startdate;
		this.enddate = enddate;
		this.sprice = sprice;
	}

	
	
	
	
	
	//--------------------------------------------------------getter setter-------------------------------------------------
	public String getUsertel() {
		return usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public String getUseraddress() {
		return useraddress1;
	}

	public void setUseraddress(String useraddress1) {
		this.useraddress1 = useraddress1;
	}

	public String getUsergender() {
		return usergender;
	}

	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}

	public String getUserjoindate() {
		return userjoindate;
	}

	public void setUserjoindate(String userjoindate) {
		this.userjoindate = userjoindate;
	}

	public String getUserbday() {
		return userbday;
	}

	public void setUserbday(String userbday) {
		this.userbday = userbday;
	}

	public int getUsersubscribe() {
		return usersubscribe;
	}

	public void setUsersubscribe(int usersubscribe) {
		this.usersubscribe = usersubscribe;
	}

	public int getReno() {
		return reno;
	}

	public void setReno(int reno) {
		this.reno = reno;
	}

	public String getReuserid() {
		return reuserid;
	}

	public void setReuserid(String reuserid) {
		this.reuserid = reuserid;
	}

	public String getRetitle() {
		return retitle;
	}

	public void setRetitle(String retitle) {
		this.retitle = retitle;
	}

	public int getRescore() {
		return rescore;
	}

	public void setRescore(int rescore) {
		this.rescore = rescore;
	}

	public String getReinsertdate() {
		return reinsertdate;
	}

	public void setReinsertdate(String reinsertdate) {
		this.reinsertdate = reinsertdate;
	}

	public int getReviewcount() {
		return reviewcount;
	}

	public void setReviewcount(int reviewcount) {
		this.reviewcount = reviewcount;
	}

	public int getSsubno() {
		return ssubno;
	}

	public void setSsubno(int ssubno) {
		this.ssubno = ssubno;
	}

	public String getSperiod() {
		return speriod;
	}

	public void setSperiod(String speriod) {
		this.speriod = speriod;
	}

	public String getSbottle() {
		return sbottle;
	}

	public void setSbottle(String sbottle) {
		this.sbottle = sbottle;
	}

	public String getSenddate() {
		return senddate;
	}

	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}

	public int getSuserno() {
		return suserno;
	}

	public void setSuserno(int suserno) {
		this.suserno = suserno;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getSprice() {
		return sprice;
	}

	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
