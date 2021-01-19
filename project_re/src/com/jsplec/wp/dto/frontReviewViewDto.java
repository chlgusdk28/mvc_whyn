package com.jsplec.wp.dto;

public class frontReviewViewDto {
	private int reno;
	private String reuserid;
	private String retitle;
	private String recontent;
	private int rescore;
	private String reinsertdate;
	private String reimage;
	private int reviewcount;
	private String rq1;
	private String rq2;
	private String rq3;
	
	public frontReviewViewDto(int reno, String reuserid, String retitle, String recontent, int rescore,
			String reinsertdate, String reimage, int reviewcount, String rq1, String rq2, String rq3) {
		super();
		this.reno = reno;
		this.reuserid = reuserid;
		this.retitle = retitle;
		this.recontent = recontent;
		this.rescore = rescore;
		this.reinsertdate = reinsertdate;
		this.reimage = reimage;
		this.reviewcount = reviewcount;
		this.rq1 = rq1;
		this.rq2 = rq2;
		this.rq3 = rq3;
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

	public String getRecontent() {
		return recontent;
	}

	public void setRecontent(String recontent) {
		this.recontent = recontent;
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

	public String getReimage() {
		return reimage;
	}

	public void setReimage(String reimage) {
		this.reimage = reimage;
	}

	public int getReviewcount() {
		return reviewcount;
	}

	public void setReviewcount(int reviewcount) {
		this.reviewcount = reviewcount;
	}

	public String getRq1() {
		return rq1;
	}

	public void setRq1(String rq1) {
		this.rq1 = rq1;
	}

	public String getRq2() {
		return rq2;
	}

	public void setRq2(String rq2) {
		this.rq2 = rq2;
	}

	public String getRq3() {
		return rq3;
	}

	public void setRq3(String rq3) {
		this.rq3 = rq3;
	}
	
	
	
	
	
}
