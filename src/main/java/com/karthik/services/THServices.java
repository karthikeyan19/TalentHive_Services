package com.karthik.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.karthik.dao.IAdminDao;
import com.karthik.vo.LoginVo;

import com.karthik.vo.ProfileVo;
import com.karthik.vo.UserDetail;
import com.karthik.daoImpl.AdminDaoImpl;
import com.karthik.utils.THUtils;

public class THServices {
	IAdminDao llcDao = new AdminDaoImpl();

	public Map<String, Object> userLogin(LoginVo login) {
		Map map = new HashMap<>();
		UserDetail userDetails = llcDao.userLogin(login);
		if (userDetails != null) {
			map.put("user", userDetails.user);
			System.out.println(userDetails.user.getName());
			map = THUtils.appendingBaseResponse(map, 0);
		}

		else {
			map = THUtils.appendingBaseResponse(map, 2);
		}
		return map;
	}
   public ProfileVo getProfile(String userName){
	   return llcDao.getProfile(userName);
   }
	public Map<String, Object> googleLogin(String googleTokenId,String userName) {
		Map map = new HashMap<>();
		UserDetail userDetails = llcDao.googleLogin(googleTokenId,userName);
		if (userDetails!=null) {
			
			map = THUtils.appendingBaseResponse(map, 0);
			map.put("userDetails", userDetails.user);
			map.put("isSuccess", true);
		}
		else {
			map = THUtils.appendingBaseResponse(map, 2);
			System.out.println("error");
		}
		return map;
	}


}
