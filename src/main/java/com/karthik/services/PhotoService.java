package com.karthik.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.karthik.dao.IPhotoDao;
import com.karthik.daoImpl.PhotoImpl;
import com.karthik.utils.THUtils;
import com.karthik.vo.ProfileVo;
import com.karthik.vo.photography.PhotoFeedResponse;
import com.karthik.vo.photography.UploadPhotoVo;

public class PhotoService {
	
	IPhotoDao iPhotoDao=new PhotoImpl();
    
	/*
	 * post a photo in Photography Talent 
	 */
	public Map<String,Object> postPhotography(UploadPhotoVo photo){
		
		Map map= new HashMap<>();
		PhotoFeedResponse photoFeedResponse=iPhotoDao.postPhotography(photo);
		if(photoFeedResponse!=null){
			map.put("photoID", photoFeedResponse.photoID);
			map.put("photo",photoFeedResponse.photo);
			map.put("user",photoFeedResponse.user);
			map.put("likeCount",photoFeedResponse.likeCount);
			map.put("commentCount",photoFeedResponse.commentCount);			
			map=THUtils.appendingBaseResponse(map, 0);
		}
		
		else {
			map=THUtils.appendingBaseResponse(map, 2);
		}
		return map;
	}
	
	
	/*
	 * getting  PhotographyFeed using Pagination for search option 
	 */
	public List<PhotoFeedResponse> getPFSearchPagination(long time){
		return iPhotoDao.searchPagination(time);
	}
	

	/*
	 * getting PhotographyFeed with new data for search option 
	 */
	public List<PhotoFeedResponse> searchforNew(long time){
		return iPhotoDao.searchforNew(time);
	}
	
	
	
		
}

