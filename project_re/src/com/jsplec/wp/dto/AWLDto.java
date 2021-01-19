package com.jsplec.wp.dto;

public class AWLDto {
	private int pno;
	private String pname;
	private int pcount;
	private String pcountry;
	private String pcolor;
	private String ptext;
	
	private int pcontent;
	
	String pimage = "";
	String prealiamge = "";
	
	String wineSearchBox;
	String wineSearchBar;
	
	
	// Constructor
	
	public AWLDto() {
		
	}

	
	
	
	
	
	
	



	public String getWineSearchBox() {
		return wineSearchBox;
	}











	public void setWineSearchBox(String wineSearchBox) {
		this.wineSearchBox = wineSearchBox;
	}











	public String getWineSearchBar() {
		return wineSearchBar;
	}











	public void setWineSearchBar(String wineSearchBar) {
		this.wineSearchBar = wineSearchBar;
	}











	public AWLDto(String pimage, String prealiamge) {
		super();
		this.pimage = pimage;
		this.prealiamge = prealiamge;
	}




	public AWLDto(int pno, String pimage, String pname, String pcountry, String pcolor, String ptext) {
		super();
		this.pno = pno;
		this.pimage = pimage;
		this.pname = pname;
		this.pcountry = pcountry;
		this.pcolor = pcolor;
		this.ptext = ptext;
	}




	public AWLDto(String pname, int pcount, String pcountry, String pcolor, String ptext, int pcontent) {
		super();
		this.pname = pname;
		this.pcount = pcount;
		this.pcountry = pcountry;
		this.pcolor = pcolor;
		this.ptext = ptext;
		this.pcontent = pcontent;
	}


	public AWLDto(int pno, String pname, String pcountry, String pcolor, String ptext) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pcountry = pcountry;
		this.pcolor = pcolor;
		this.ptext = ptext;
	
	}


	public AWLDto(int pno, String pname, int pcount, String pcountry, String pcolor, String ptext, int pcontent,
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




	public String getPrealiamge() {
		return prealiamge;
	}




	public void setPrealiamge(String prealiamge) {
		this.prealiamge = prealiamge;
	}


	
	
}
