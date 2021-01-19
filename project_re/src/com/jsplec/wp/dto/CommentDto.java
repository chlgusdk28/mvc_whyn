package com.jsplec.wp.dto;

public class CommentDto {
	int seq;
	String userid;
	String content;
	public CommentDto(int seq, String userid, String content) {
		super();
		this.seq = seq;
		this.userid = userid;
		this.content = content;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
