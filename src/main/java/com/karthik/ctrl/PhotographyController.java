package com.karthik.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.services.PhotoService;
import com.karthik.services.THServices;
import com.karthik.vo.LoginVo;
import com.karthik.vo.photography.PhotoFeedResponse;
import com.karthik.vo.photography.UploadPhotoVo;

/*
 * controller for photography
 */
@RestController
public class PhotographyController {

	PhotoService photoServices = new PhotoService();

	
	/*
	 * upload a photo method
	 * 
	 * @Requestbody UploadPhotoVo Object model
	 */
	@RequestMapping(value = "/uploadPhotograph", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> postPhotography(@RequestBody UploadPhotoVo photo) {
		System.out.println("working fine");

		return photoServices.postPhotography(photo);

	}

	
	/*
	 * getting search PhotographyFeed method
	 * 
	 * @param1 time long(current time)
	 * 
	 * @param2 isPagination true/false
	 */

	@RequestMapping(value = "/searchPhotographfeed/{time}/{isLookingForNewData}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<PhotoFeedResponse> getSearchPhotographyfeed(@PathVariable("time") long time,
			@PathVariable("isLookingForNewData") boolean isLookingForNewData) {
		System.out.println("working...");

		if (isLookingForNewData)
			return photoServices.searchforNew(time);
		else
			return photoServices.getPFSearchPagination(time);

	}

}
