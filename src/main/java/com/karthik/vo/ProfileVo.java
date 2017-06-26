package com.karthik.vo;

public class ProfileVo {
	
	
	    public UserVo user;
		public String encodedProfilePic;
	    public String coverImageUrl;
	    public String encodedCoverImage;
	    public boolean isFollowedByMe;
	    public String bio;
	    public String email;
	    public String mobileNo;
	    public String gender;
	    public long followersCount;
	    public long followingCount;
	    public UserVo getUser() {
			return user;
		}
		public void setUser(UserVo user) {
			this.user = user;
		}
	    public String getEncodedProfilePic() {
			return encodedProfilePic;
		}
		public void setEncodedProfilePic(String encodedProfilePic) {
			this.encodedProfilePic = encodedProfilePic;
		}
		public String getCoverImageUrl() {
			return coverImageUrl;
		}
		public void setCoverImageUrl(String coverImageUrl) {
			this.coverImageUrl = coverImageUrl;
		}
		public String getEncodedCoverImage() {
			return encodedCoverImage;
		}
		public void setEncodedCoverImage(String encodedCoverImage) {
			this.encodedCoverImage = encodedCoverImage;
		}
		public boolean isFollowedByMe() {
			return isFollowedByMe;
		}
		public void setFollowedByMe(boolean isFollowedByMe) {
			this.isFollowedByMe = isFollowedByMe;
		}
		public String getBio() {
			return bio;
		}
		public void setBio(String bio) {
			this.bio = bio;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
	    
}
