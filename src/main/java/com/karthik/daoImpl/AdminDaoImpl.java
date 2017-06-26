package com.karthik.daoImpl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.karthik.constants.MongoConstants;
import com.karthik.dao.IAdminDao;
import com.karthik.utils.MongoUtils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.jongo.Jongo;
import com.karthik.vo.LoginVo;
import com.karthik.vo.ProfileVo;
import com.karthik.vo.UserDetail;
import com.karthik.vo.UserVo;
import com.mongodb.WriteResult;

public class AdminDaoImpl extends BaseDaoImpl implements IAdminDao {

	private static final String CLIENT_ID = "877402304105-kcm1cpivf4btjkqr790oor34g7s0sbkd.apps.googleusercontent.com";

	@Override
	public UserDetail userLogin(LoginVo login) {
		LoginVo logindet = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.CN_LOGINCREDENTIALS)
				.findOne("{emailId:#,password:#}", login.getEmailId(), login.getPassword()).as(LoginVo.class);
		if (logindet != null) {
			System.out.print("wii");
			return getUserDetails(logindet.getEmailId());
		}

		return null;
	}

	@Override
	public ProfileVo getProfile(String userName) {

		ProfileVo profile = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.CN_PROFILECREDENTIALS)
				.findOne("{user.userName:#}", userName).as(ProfileVo.class);

		return profile;
	}

	@Override
	public UserDetail googleLogin(String googleTokenId, String userName) {
		UserDetail userDetails =null;
		// TODO Auto-generated method stub
		 NetHttpTransport transport = new NetHttpTransport();
		
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, new JacksonFactory())
				.setAudience(Collections.singletonList(CLIENT_ID))
				// Or, if multiple clients access the backend:
				// .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2,
				// CLIENT_ID_3))
				.build();

		// (Receive idTokenString by HTTPS POST)

		GoogleIdToken idToken=null;
		try {
			idToken = verifier.verify(googleTokenId);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (idToken != null) {
			Payload payload = idToken.getPayload();

			// Print user identifier

			// Get profile information from payload

			// Use or store profile information
			// ...
			userDetails = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.CN_PROFILECREDENTIALS)
					.findOne("{user.googleTokenId:#}", googleTokenId).as(UserDetail.class);

			if (userDetails == null) {
				ProfileVo profile = new ProfileVo();
				profile.user = new UserVo();
				String userId = payload.getSubject();
				System.out.println("User ID: " + userId);
				profile.user.profileId = userId;

				profile.email = payload.getEmail();
				boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
				profile.user.name = (String) payload.get("name");
				String pictureUrl = (String) payload.get("picture");
				String givenName = (String) payload.get("given_name");
				profile.user.userName = userName;
				profile.user.setGoogleTokenId(googleTokenId);
				profile.user.loginType = 1;
				WriteResult result = insertProfile(profile);

				if(result!=null)
					userDetails = getUserDetails(profile.user.profileId);
				System.out.println(userDetails.user.name);
			}

		} else {
			System.out.println("Invalid ID token.");
		}
		
		return userDetails;
	}

	public WriteResult insertProfile(ProfileVo profile) {
		return new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.CN_PROFILECREDENTIALS).insert(profile);
	}
}
