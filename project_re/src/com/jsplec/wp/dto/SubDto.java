package com.jsplec.wp.dto;

public class SubDto {
	String duserid;
	int dno;
	int duserno;
	int dsubno;
	String daddress1;
	String daddress2;
	String daddress3;
	String dusername;
	String dtel;
	
	int pno;
	String pname;
	int pcount;
	String pcountry;
	String pcolor;
	String ptext;
	int pcontent;
	String pimage;
	
	
	
	
	
	
	public SubDto(String duserid, int dno, int duserno, int dsubno, String daddress1, String daddress2,
			String daddress3, String dusername, String dtel) {
		super();
		this.duserid = duserid;
		this.dno = dno;
		this.duserno = duserno;
		this.dsubno = dsubno;
		this.daddress1 = daddress1;
		this.daddress2 = daddress2;
		this.daddress3 = daddress3;
		this.dusername = dusername;
		this.dtel = dtel;
	}

	public SubDto(int pno, String pname, int pcount, String pcountry, String pcolor, String ptext, int pcontent,
			String pimage) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pcount = pcount;
		this.pcountry = pcountry;
		this.pcolor = pcolor;
		this.ptext = ptext;
		this.pcontent = pcontent;
		this.pimage = pimage;
	}

	
	
	public String getDuserid() {
		return duserid;
	}

	public void setDuserid(String duserid) {
		this.duserid = duserid;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPcount() {
		return pcount;
	}

	public void setPcount(int pcount) {
		this.pcount = pcount;
	}

	public String getPcountry() {
		return pcountry;
	}

	public void setPcountry(String pcountry) {
		this.pcountry = pcountry;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public String getPtext() {
		return ptext;
	}

	public void setPtext(String ptext) {
		this.ptext = ptext;
	}

	public int getPcontent() {
		return pcontent;
	}

	public void setPcontent(int pcontent) {
		this.pcontent = pcontent;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public SubDto() {

	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public int getDuserno() {
		return duserno;
	}

	public void setDuserno(int duserno) {
		this.duserno = duserno;
	}

	public int getDsubno() {
		return dsubno;
	}

	public void setDsubno(int dsubno) {
		this.dsubno = dsubno;
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

	public String getDtel() {
		return dtel;
	}

	public void setDtel(String dtel) {
		this.dtel = dtel;
	}

	

	


	

}
