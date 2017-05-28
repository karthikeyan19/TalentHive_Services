package com.karthik.dao;

import com.karthik.vo.LoginVo;

import com.karthik.vo.ProfileVo;
import com.karthik.vo.UserDetail;

public interface IAdminDao {

	public UserDetail userLogin(LoginVo login);
	
}
