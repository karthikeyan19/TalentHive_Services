package com.karthik.vo;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class CommentVo {
    
	@MongoObjectId
	public String commenterId;
    public String profileUrl;
    public String comment;
    
}
