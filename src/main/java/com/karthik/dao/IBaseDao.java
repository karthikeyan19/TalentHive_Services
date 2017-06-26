package com.karthik.dao;

import com.karthik.vo.ProfileVo;
import com.karthik.vo.UserDetail;

public interface IBaseDao {

	UserDetail getUserDetails(String profileId);
	
}
