package com.karthik.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.services.PhotoService;
import com.karthik.services.THServices;
import com.karthik.vo.GoogleLoginVo;
import com.karthik.vo.LoginVo;
import com.karthik.vo.ProfileVo;
import com.karthik.vo.photography.PhotoFeedResponse;
import com.karthik.vo.photography.UploadPhotoVo;

@RestController
public class THController {
	
THServices thServices= new THServices();

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String,Object> userLogin(@RequestBody LoginVo login) {
	    System.out.println(login.getEmailId());
		return thServices.userLogin(login);
	}
	
	@RequestMapping(value = "/googleLogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String,Object> googleLogin(@RequestBody GoogleLoginVo login) {
	    System.out.println(login.googleTokenId);
		return thServices.googleLogin(login.googleTokenId,login.userName);
	}
	
	
	@RequestMapping(value="/profile/{userName}",method =  RequestMethod.GET,headers = "Accept=application/json")
	public ProfileVo getProfile(@PathVariable("userName") String userName){
	    
	return thServices.getProfile(userName);
	}	
	
}
