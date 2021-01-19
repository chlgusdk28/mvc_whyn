package com.jsplec.wp.dto;

import java.sql.Timestamp;

public class ARLDto {

	
	int reno;
	String reuserid;
	String retitle;
	String recontent;
	int rescore;
	Timestamp reinsertdate;
	int reviewcount;
	
	String reviewSearchBox;
	String reviewSearchBar;
	
	
	
	

	
	
	
	
	
	
	














	public ARLDto(int reno, String reuserid, String retitle, String recontent, Timestamp reinsertdate,
			int reviewcount) {
		super();
		this.reno = reno;
		this.reuserid = reuserid;
		this.retitle = retitle;
		this.recontent = recontent;
		this.reinsertdate = reinsertdate;
		this.reviewcount = reviewcount;
	}















	public int getReviewcount() {
		return reviewcount;
	}















	public void setReviewcount(int reviewcount) {
		this.reviewcount = reviewcount;
	}















	public String getReviewSearchBar() {
		return reviewSearchBar;
	}















	public void setReviewSearchBar(String reviewSearchBar) {
		this.reviewSearchBar = reviewSearchBar;
	}















	public ARLDto(String reviewSearchBox, String reviewSearchBar) {
		super();
		this.reviewSearchBox = reviewSearchBox;
		this.reviewSearchBar = reviewSearchBar;
	}















	public String getReviewSearchBox() {
		return reviewSearchBox;
	}















	public void setReviewSearchBox(String reviewSearchBox) {
		this.reviewSearchBox = reviewSearchBox;
	}















	public ARLDto(int reno, String reuserid, String retitle, String recontent, int rescore, Timestamp reinsertdate,
			String reviewSearchBox) {
		super();
		this.reno = reno;
		this.reuserid = reuserid;
		this.retitle = retitle;
		this.recontent = recontent;
		this.rescore = rescore;
		this.reinsertdate = reinsertdate;
		this.reviewSearchBox = reviewSearchBox;
	}















	public ARLDto(int reno, String reuserid, String retitle, String recontent, Timestamp reinsertdate) {
		super();
		this.reno = reno;
		this.reuserid = reuserid;
		this.retitle = retitle;
		this.recontent = recontent;
		this.reinsertdate = reinsertdate;
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















	public Timestamp getReinsertdate() {
		return reinsertdate;
	}















	public void setReinsertdate(Timestamp reinsertdate) {
		this.reinsertdate = reinsertdate;
	}















	public ARLDto(int reno, String reuserid, String retitle, String recontent, int rescore, Timestamp reinsertdate) {
		super();
		this.reno = reno;
		this.reuserid = reuserid;
		this.retitle = retitle;
		this.recontent = recontent;
		this.rescore = rescore;
		this.reinsertdate = reinsertdate;
	}
	
	
	
}
