package com.jsplec.wp.dto;

import java.sql.Timestamp;

public class ASCDto {
	
	
	
	int scno;
	String sctype;
	String scuserinfo;
	Timestamp sdate;
	int sviewcount;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getScno() {
		return scno;
	}





















	public void setScno(int scno) {
		this.scno = scno;
	}





















	public String getSctype() {
		return sctype;
	}





















	public void setSctype(String sctype) {
		this.sctype = sctype;
	}





















	public String getScuserinfo() {
		return scuserinfo;
	}





















	public void setScuserinfo(String scuserinfo) {
		this.scuserinfo = scuserinfo;
	}





















	public Timestamp getSdate() {
		return sdate;
	}





















	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}





















	public int getSviewcount() {
		return sviewcount;
	}





















	public void setSviewcount(int sviewcount) {
		this.sviewcount = sviewcount;
	}





















	public ASCDto(int scno, String sctype, String scuserinfo, Timestamp sdate) {
		super();
		this.scno = scno;
		this.sctype = sctype;
		this.scuserinfo = scuserinfo;
		this.sdate = sdate;
	}





















	public ASCDto(int scno, String sctype, String scuserinfo, Timestamp sdate, int sviewcount) {
		super();
		this.scno = scno;
		this.sctype = sctype;
		this.scuserinfo = scuserinfo;
		this.sdate = sdate;
		this.sviewcount = sviewcount;
	}
	
	
	
	
	
	

}
