package com.jsplec.wp.dto;


public class SubscribeDto {

	
	
	private String speriod;
	private String sbottle;
	private String senddate;
	private String s1stq;
	private String s2ndq; 
	private String s3rdq; 
	private String s4thq; 
	private String s5thq; 

	
	public SubscribeDto() {
		
		
	}


	public SubscribeDto(String speriod, String sbottle, String senddate, String s1stq, String s2ndq,
			String s3rdq, String s4thq, String s5thq) {
		super();

		this.speriod = speriod;
		this.sbottle = sbottle;
		this.senddate = senddate;
		this.s1stq = s1stq;
		this.s2ndq = s2ndq;
		this.s3rdq = s3rdq;
		this.s4thq = s4thq;
		this.s5thq = s5thq;
		
	}


	public String getSenddate() {
		return senddate;
	}


	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}


	public String getSperiod() {
		return speriod;
	}

	public void setSperiod(String speriod) {
		this.speriod = speriod;
	}

	public String getSbottle() {
		return sbottle;
	}

	public void setSbottle(String sbottle) {
		this.sbottle = sbottle;
	}


	public String getS1stq() {
		return s1stq;
	}

	public void setS1stq(String s1stq) {
		this.s1stq = s1stq;
	}

	public String getS2ndq() {
		return s2ndq;
	}

	public void setS2ndq(String s2ndq) {
		this.s2ndq = s2ndq;
	}

	public String getS3rdq() {
		return s3rdq;
	}

	public void setS3rdq(String s3rdq) {
		this.s3rdq = s3rdq;
	}

	public String getS4thq() {
		return s4thq;
	}

	public void setS4thq(String s4thq) {
		this.s4thq = s4thq;
	}

	public String getS5thq() {
		return s5thq;
	}

	public void setS5thq(String s5thq) {
		this.s5thq = s5thq;
	}


	
	
}
