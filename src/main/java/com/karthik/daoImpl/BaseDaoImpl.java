package com.karthik.daoImpl;

import org.jongo.Jongo;

import com.karthik.constants.MongoConstants;
import com.karthik.dao.IBaseDao;
import com.karthik.utils.MongoUtils;
import com.karthik.vo.ProfileVo;
import com.karthik.vo.UserDetail;

public class BaseDaoImpl implements IBaseDao {

	@Override
	public UserDetail getUserDetails(String profileId) {
        
		return new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.CN_PROFILECREDENTIALS)
		.findOne("{user.profileId:#}", profileId).projection("{user:1}").as(UserDetail.class);
	}

}
