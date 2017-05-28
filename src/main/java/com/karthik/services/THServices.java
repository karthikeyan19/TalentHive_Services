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

}
