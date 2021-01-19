package com.jsplec.wp.dto;

public class LoginDto {
	private String loginFieldCheckMessage;
	private int userno;
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	
	
	public LoginDto() {
		// TODO Auto-generated constructor stub
	}

	public LoginDto(String userid, String userpw) {
		super();
		this.userid = userid;
		this.userpw = userpw;
	}

	public LoginDto(String loginFieldCheckMessage, String userid, String userpw) {
		super();
		this.loginFieldCheckMessage = loginFieldCheckMessage;
		this.userid = userid;
		this.userpw = userpw;
	}
	
	

	public LoginDto(int userno, String userid, String username, String useremail) {
		super();
		this.userno = userno;
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
	}
	

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public void setLoginFieldCheckMessage(String loginFieldCheckMessage) {
		this.loginFieldCheckMessage = loginFieldCheckMessage;
	}

	public String getLoginFieldCheckMessage() {
		return loginFieldCheckMessage;
	}

	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	
}
