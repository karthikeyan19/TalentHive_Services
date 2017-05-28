package com.karthik.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.jongo.Find;
import org.jongo.Jongo;

import com.karthik.constants.MongoConstants;
import com.karthik.dao.IPhotoDao;
import com.karthik.utils.MongoUtils;
import com.karthik.utils.THUtils;
import com.karthik.vo.UserDetail;
import com.karthik.vo.photography.PhotoFeedResponse;
import com.karthik.vo.photography.PhotoVo;
import com.karthik.vo.photography.UploadPhotoVo;
import com.mongodb.WriteResult;

public class PhotoImpl extends BaseDaoImpl implements IPhotoDao {

	@Override
	public PhotoFeedResponse postPhotography(UploadPhotoVo uploadPhoto) {

		UserDetail userDetails = getProfile(uploadPhoto.user.profileId);
		uploadPhoto.user = userDetails.user;
		WriteResult result = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.CN_PHOTOCREDENTIALS)
				.insert(uploadPhoto);
		if (result.getN() != -1) {
			System.out.println("working finsse"+result.getN());
			PhotoFeedResponse photoFeedResponse = new PhotoFeedResponse();
			photoFeedResponse.user = userDetails.user;
			photoFeedResponse.photo = new PhotoVo();
			System.out.println(uploadPhoto.getPhotoID());
			photoFeedResponse.setPhotoID(uploadPhoto.getPhotoID());
			photoFeedResponse.photo.photoURL = uploadPhoto.photo.photoURL;
			photoFeedResponse.photo.location = uploadPhoto.photo.location;
			photoFeedResponse.lastModifiedTime = uploadPhoto.lastModifiedTime;
			photoFeedResponse.photo.titleDescription = uploadPhoto.photo.titleDescription;
			return photoFeedResponse;
		}
		return null;
	}

	@Override
	public List<PhotoFeedResponse> searchPagination(long time) {
	

		Iterator<PhotoFeedResponse> iteratorOfFeed = new Jongo(MongoUtils.getDB())
				.getCollection(MongoConstants.CN_PHOTOCREDENTIALS).find("{lastModifiedTime:{$lte:#}}", time).limit(2)
				.as(PhotoFeedResponse.class).iterator();

		List<PhotoFeedResponse> list = THUtils.iteratorToList(iteratorOfFeed);

		return list;
	}

	@Override
	public List<PhotoFeedResponse> searchforNew(long time) {
	

		Iterator<PhotoFeedResponse> iteratorOfFeed = new Jongo(MongoUtils.getDB())
				.getCollection(MongoConstants.CN_PHOTOCREDENTIALS).find("{lastModifiedTime:{$gte:#}}", time).limit(5)
				.as(PhotoFeedResponse.class).iterator();

		List<PhotoFeedResponse> list = THUtils.iteratorToList(iteratorOfFeed);

		return list;
	}
}
