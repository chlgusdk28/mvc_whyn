package com.jsplec.wp.dto;

public class DeliveryDto {
	
	private String dtel;
	private String daddress1;
	private String daddress2;
	private String daddress3;
	private String dusername;
	private String dmsg;
	private String duserid;
	
	
	

	private String speriod;
	private String sbottle;
	private String senddate;
	private String startdate;
	private String enddate;
	private String sprice;
	
	
	
	
	
	
	
	
	
	public DeliveryDto(String dtel, String daddress1, String daddress2, String daddress3, String dusername,
			String duserid, String speriod, String sbottle, String startdate, String enddate, String sprice) {
		super();
		this.dtel = dtel;
		this.daddress1 = daddress1;
		this.daddress2 = daddress2;
		this.daddress3 = daddress3;
		this.dusername = dusername;
		this.duserid = duserid;
		this.speriod = speriod;
		this.sbottle = sbottle;
		this.startdate = startdate;
		this.enddate = enddate;
		this.sprice = sprice;
	}
	public DeliveryDto(String dtel, String daddress1, String daddress2, String daddress3, String dusername, String dmsg,
			String duserid, String speriod, String sbottle, String senddate, String startdate, String enddate,
			String sprice) {
		super();
		this.dtel = dtel;
		this.daddress1 = daddress1;
		this.daddress2 = daddress2;
		this.daddress3 = daddress3;
		this.dusername = dusername;
		this.dmsg = dmsg;
		this.duserid = duserid;
		this.speriod = speriod;
		this.sbottle = sbottle;
		this.senddate = senddate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.sprice = sprice;
	}
	public String getDuserid() {
		return duserid;
	}
	public void setDuserid(String duserid) {
		this.duserid = duserid;
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
	public DeliveryDto(String dtel, String daddress1, String daddress2, String daddress3, String dusername,
			String dmsg) {
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
	
	
	
	
}
