package com.karthik.daoImpl;

import com.karthik.constants.MongoConstants;
import com.karthik.dao.IAdminDao;
import com.karthik.utils.MongoUtils;
import org.jongo.Jongo;
import com.karthik.vo.LoginVo;
import com.karthik.vo.ProfileVo;
import com.karthik.vo.UserDetail;

public class AdminDaoImpl extends BaseDaoImpl implements IAdminDao  {

	@Override
	public UserDetail userLogin(LoginVo login) {
		LoginVo logindet =new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.CN_LOGINCREDENTIALS)
				.findOne("{emailId:#,password:#}",login.getEmailId(),login.getPassword())
				.as(LoginVo.class);
		if(logindet!=null){
		 return getProfile(logindet.getEmailId());
		}
		
			
	   return null;
	}

	

}
