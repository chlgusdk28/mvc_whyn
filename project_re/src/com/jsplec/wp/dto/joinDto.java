package com.jsplec.wp.dto;

public class joinDto {
	private String username;
	private String userid;
	private String userpw;
	private String userpwCheck;
	private String useremail;
	private String usergender;
	private String userage;
	private String usertel;
	private String useraddress;
	private String userbday;
	
	private String fieldCheckmessage;
	public joinDto() { 
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

	




	public joinDto(String username, String userid, String userpw, String userpwCheck, String usergender, String userage,
			String usertel, String useraddress, String fieldCheckmessage) {
		super();
		this.username = username;
		this.userid = userid;
		this.userpw = userpw;
		this.userpwCheck = userpwCheck;
		this.usergender = usergender;
		this.userage = userage;
		this.usertel = usertel;
		this.useraddress = useraddress;
		this.fieldCheckmessage = fieldCheckmessage;
	}












	public joinDto(String username, String userid, String userpw, String userpwCheck, String useremail,
			String fieldCheckmessage) {
		super();
		this.username = username;
		this.userid = userid;
		this.userpw = userpw;
		this.userpwCheck = userpwCheck;
		this.useremail = useremail;
		this.fieldCheckmessage = fieldCheckmessage;
	}

	public String getUsergender() {
		return usergender;
	}




	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}




	public String getUserage() {
		return userage;
	}




	public void setUserage(String userage) {
		this.userage = userage;
	}




	public String getUsertel() {
		return usertel;
	}




	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}




	public String getUseraddress() {
		return useraddress;
	}




	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}




	public String getUserbday() {
		return userbday;
	}




	public void setUserbday(String userbday) {
		this.userbday = userbday;
	}




	public String getFieldCheckmessage() {
		return fieldCheckmessage;
	}



	public void setFieldCheckmessage(String fieldCheckmessage) {
		this.fieldCheckmessage = fieldCheckmessage;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getUserpwCheck() {
		return userpwCheck;
	}

	public void setUserpwCheck(String userpwCheck) {
		this.userpwCheck = userpwCheck;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	} 
	
	
	
	
}
