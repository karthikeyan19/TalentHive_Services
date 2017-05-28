package com.karthik.vo.photography;

import java.util.List;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import com.karthik.vo.CommentVo;
import com.karthik.vo.UserDetail;
import com.karthik.vo.UserVo;

public class UploadPhotoVo {
	
	@MongoId
	@MongoObjectId
	public String _id;
	public long createdTime;
	public long lastModifiedTime;
	public PhotoVo photo;
	public UserVo user;
	public List<String> likedList;
	public List<CommentVo> commentList;
	public long likeCount;
	public long commentCount;

	public String getPhotoID() {
		return _id;
	}

	public void setPhotoID(String photoID) {
		this._id = photoID;
	}
	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}
	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

	public long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public PhotoVo getPhoto() {
		return photo;
	}

	public void setPhoto(PhotoVo photo) {
		this.photo = photo;
	}

	public List<String> getLikedList() {
		return likedList;
	}

	public void setLikedList(List<String> likedList) {
		this.likedList = likedList;
	}

	public List<CommentVo> getComments() {
		return commentList;
	}

	public void setComments(List<CommentVo> comments) {
		this.commentList = comments;
	}

}
