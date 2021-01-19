package com.jsplec.wp.dto;

import java.sql.Timestamp;

public class NoticeDto {

	public NoticeDto() {
		
	}
	
	int nno;
	String ntitle;
	String ncontent;
	String ninsertdate;
	int nviewcount;
	int todaycount;
	int allcount;
	String beforeNoticeTitle;
	int beforeNoticeNo;
	
	String afterNoticeTitle;
	int afterNoticeNo;
	int i;

	
	public NoticeDto(String beforeNoticeTitle, int beforeNoticeNo) {
		super();
		this.beforeNoticeTitle = beforeNoticeTitle;
		this.beforeNoticeNo = beforeNoticeNo;
	}


	public NoticeDto(String afterNoticeTitle, int afterNoticeNo, int i) {
		super();
		this.afterNoticeTitle = afterNoticeTitle;
		this.afterNoticeNo = afterNoticeNo;
		this.i = i;
	}


	
	
	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}


	public String getBeforeNoticeTitle() {
		return beforeNoticeTitle;
	}



	public void setBeforeNoticeTitle(String beforeNoticeTitle) {
		this.beforeNoticeTitle = beforeNoticeTitle;
	}



	public int getBeforeNoticeNo() {
		return beforeNoticeNo;
	}



	public void setBeforeNoticeNo(int beforeNoticeNo) {
		this.beforeNoticeNo = beforeNoticeNo;
	}



	public String getAfterNoticeTitle() {
		return afterNoticeTitle;
	}



	public void setAfterNoticeTitle(String afterNoticeTitle) {
		this.afterNoticeTitle = afterNoticeTitle;
	}



	public int getAfterNoticeNo() {
		return afterNoticeNo;
	}



	public void setAfterNoticeNo(int afterNoticeNo) {
		this.afterNoticeNo = afterNoticeNo;
	}



	public NoticeDto(int nno, String ntitle, String ncontent, String ninsertdate, int nviewcount) {
		super();
		this.nno = nno;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.ninsertdate = ninsertdate;
		this.nviewcount = nviewcount;
	}
	
	

	public int getTodaycount() {
		return todaycount;
	}

	public void setTodaycount(int todaycount) {
		this.todaycount = todaycount;
	}

	public int getAllcount() {
		return allcount;
	}

	public void setAllcount(int allcount) {
		this.allcount = allcount;
	}

	public NoticeDto(int nno) {
		super();
		this.nno = nno;
	}

	
	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNinsertdate() {
		return ninsertdate;
	}

	public void setNinsertdate(String ninsertdate) {
		this.ninsertdate = ninsertdate;
	}

	public int getNviewcount() {
		return nviewcount;
	}

	public void setNviewcount(int nviewcount) {
		this.nviewcount = nviewcount;
	}



	
	
	

	
	

}
