package com.karthik.vo;

public class UserVo {
	public String  profileId;
    public int loginType;
    public String accountId;
    public String fbTokenId;
    public String googleTokenId;
   	public String name;
	public String userName;
    public String profilePicUrl;
    
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getFbTokenId() {
		return fbTokenId;
	}
	public void setFbTokenId(String fbTokenId) {
		this.fbTokenId = fbTokenId;
	}
	public String getGoogleTokenId() {
		return googleTokenId;
	}
	public void setGoogleTokenId(String googleTokenId) {
		this.googleTokenId = googleTokenId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProfilePicUrl() {
		return profilePicUrl;
	}
	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

}
