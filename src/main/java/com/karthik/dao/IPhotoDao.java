package com.karthik.dao;

import java.util.List;

import com.karthik.vo.photography.PhotoFeedResponse;
import com.karthik.vo.photography.PhotoVo;
import com.karthik.vo.photography.UploadPhotoVo;

public interface IPhotoDao {

	PhotoFeedResponse postPhotography(UploadPhotoVo photo);

	List<PhotoFeedResponse> searchPagination(long time);

	List<PhotoFeedResponse> searchforNew(long time);
}
