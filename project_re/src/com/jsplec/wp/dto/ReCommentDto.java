package com.jsplec.wp.dto;

public class ReCommentDto {
	int seq;
	int pseq;
	String userid;
	String content;
	public ReCommentDto(int seq, int pseq, String userid, String content) {
		super();
		this.seq = seq;
		this.pseq = pseq;
		this.userid = userid;
		this.content = content;
	}
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
