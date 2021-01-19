package com.jsplec.wp.dto;

import java.sql.Timestamp;

public class AUserLDto {

	int userno;
	String username;
	String userid;
	String userpw;
	String usertel;
	String useraddress1;
	String useraddress2;
	String useraddress3;
	String usergender;
	int usersubscribe;
	Timestamp userjoindate;
	Timestamp userbday;
	String admincomment;

	
	
	
	
	String userSelectBox;
	


	public AUserLDto(int userno, String username, String userid, String usertel, String useraddress1, String useraddress2, String useraddress3, 
			String usergender,
			int usersubscribe, Timestamp userjoindate, Timestamp userbday, String admincomment) {
		super();
		this.userno = userno;
		this.username = username;
		this.userid = userid;
		this.usertel = usertel;
		this.useraddress1 = useraddress1;
		this.useraddress2 = useraddress2;
		this.useraddress3 = useraddress3;
		this.usergender = usergender;
		this.usersubscribe = usersubscribe;
		this.userjoindate = userjoindate;
		this.userbday = userbday;
		this.admincomment = admincomment;
	}




















	public AUserLDto( String username, String userid, String usertel, int usersubscribe,
			Timestamp userjoindate) {
		super();
		this.username = username;
		this.userid = userid;
		this.usertel = usertel;
		this.usersubscribe = usersubscribe;
		this.userjoindate = userjoindate;
	}




















	public AUserLDto(int userno, String username, String userid, String usertel, String useraddress1, String usergender,
			int usersubscribe, Timestamp userjoindate, String admincomment) {
		super();
		this.userno = userno;
		this.username = username;
		this.userid = userid;
		this.usertel = usertel;
		this.useraddress1 = useraddress1;
		this.usergender = usergender;
		this.userjoindate = userjoindate;
		this.admincomment = admincomment;
		this.usersubscribe = usersubscribe;
	}




















	public AUserLDto(int userno, String username, String userid, String usertel, int usersubscribe,
			Timestamp userjoindate) {
		super();
		this.userno = userno;
		this.username = username;
		this.userid = userid;
		this.usertel = usertel;
		this.userjoindate = userjoindate;
		this.usersubscribe = usersubscribe;
	}




















	public int getUsersubscribe() {
		return usersubscribe;
	}




















	public void setUsersubscribe(int usersubscribe) {
		this.usersubscribe = usersubscribe;
	}




















	public AUserLDto(int userno, String username, String userid, String userpw, String usertel, String useraddress1,
			String usergender, Timestamp userjoindate, Timestamp userbday, String admincomment, String userSelectBox,
			int usersubscribe, String userSearchBar) {
		super();
		this.userno = userno;
		this.username = username;
		this.userid = userid;
		this.userpw = userpw;
		this.usertel = usertel;
		this.useraddress1 = useraddress1;
		this.usergender = usergender;
		this.userjoindate = userjoindate;
		this.userbday = userbday;
		this.admincomment = admincomment;
		this.userSelectBox = userSelectBox;
		this.usersubscribe = usersubscribe;
		this.userSearchBar = userSearchBar;
	}




















	public AUserLDto(int userno, String username, String userid, String usertel, Timestamp userjoindate,
			Timestamp userbday) {
		super();
		this.userno = userno;
		this.username = username;
		this.userid = userid;
		this.usertel = usertel;
		this.userjoindate = userjoindate;
		this.userbday = userbday;
	}




















	public AUserLDto(int userno, String username, String userid, String usertel, String useraddress1, String usergender,
			 Timestamp userjoindate, Timestamp userbday, String admincomment) {
		super();
		this.userno = userno;
		this.username = username;
		this.userid = userid;
		this.usertel = usertel;
		this.useraddress1 = useraddress1;
		this.usergender = usergender;
		this.userjoindate = userjoindate;
		this.userbday = userbday;
		this.admincomment = admincomment;
	}















	public String getUserSelectBox() {
		return userSelectBox;
	}















	public void setUserSelectBox(String userSelectBox) {
		this.userSelectBox = userSelectBox;
	}















	public String getUserSearchBar() {
		return userSearchBar;
	}















	public void setUserSearchBar(String userSearchBar) {
		this.userSearchBar = userSearchBar;
	}















	public AUserLDto(String userSelectBox, String userSearchBar) {
		super();
		this.userSelectBox = userSelectBox;
		this.userSearchBar = userSearchBar;
	}















	String userSearchBar;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public AUserLDto(int userno) {
		super();
		this.userno = userno;
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















	public String getUsertel() {
		return usertel;
	}















	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}















	public String getUseraddress() {
		return useraddress1;
	}















	public void setUseraddress(String useraddress1) {
		this.useraddress1 = useraddress1;
	}















	public String getUsergender() {
		return usergender;
	}















	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}


















	public Timestamp getUserjoindate() {
		return userjoindate;
	}















	public void setUserjoindate(Timestamp userjoindate) {
		this.userjoindate = userjoindate;
	}















	public Timestamp getUserbday() {
		return userbday;
	}















	public void setUserbday(Timestamp userbday) {
		this.userbday = userbday;
	}















	












	public String getAdmincomment() {
		return admincomment;
	}















	public String getUseraddress1() {
		return useraddress1;
	}




















	public void setUseraddress1(String useraddress1) {
		this.useraddress1 = useraddress1;
	}




















	public String getUseraddress2() {
		return useraddress2;
	}




















	public void setUseraddress2(String useraddress2) {
		this.useraddress2 = useraddress2;
	}




















	public String getUseraddress3() {
		return useraddress3;
	}




















	public void setUseraddress3(String useraddress3) {
		this.useraddress3 = useraddress3;
	}




















	public void setAdmincomment(String admincomment) {
		this.admincomment = admincomment;
	}















	public AUserLDto(int userno, String username, String userid, String userpw, String usertel, String useraddress1,
			String usergender,  Timestamp userjoindate, Timestamp userbday,
			String admincomment) {
		super();
		this.userno = userno;
		this.username = username;
		this.userid = userid;
		this.userpw = userpw;
		this.usertel = usertel;
		this.useraddress1 = useraddress1;
		this.usergender = usergender;
		this.userjoindate = userjoindate;
		this.userbday = userbday;
		this.admincomment = admincomment;
	}





















	
	
	
	
}
