package com.karthik.vo.photography;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import com.karthik.vo.UserVo;

public class PhotoFeedResponse {
	
    @MongoId
	@MongoObjectId
	public String photoID;
    public PhotoVo photo;
    public long lastModifiedTime;
    public UserVo user;
    public long likeCount;
    public long commentCount;
    
	public long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}
	public String getPhotoID() {
		return photoID;
	}
	public void setPhotoID(String photoID) {
		this.photoID = photoID;
	}
	public UserVo getUser() {
		return user;
	}
	public void setUser(UserVo user) {
		this.user = user;
	}
	public long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}
	public PhotoVo getPhoto() {
		return photo;
	}
	public void setPhoto(PhotoVo photo) {
		this.photo = photo;
	}
	public long getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	
}
