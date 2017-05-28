package com.karthik.vo;

public class LoginVo {
	
	private String emailId;
	private String password;
	
	
	public LoginVo()
	{
	}
	public LoginVo(String emailid,String password)
	{
		this.emailId=emailid;
		this.password=password;
		}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
