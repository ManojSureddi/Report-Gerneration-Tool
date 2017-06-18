package com.crossover.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.service.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class UserController {
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public String getUserSession(@RequestParam("username")String uname,@RequestParam("password") String pass) {
		AuthService service = new AuthService();
		return service.getUserSession(uname, pass);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST, headers = "Accept=application/json")
	public String logOutUserSession(@RequestParam("sessionId")String sessionId) {
		AuthService service = new AuthService();
		return service.logout(sessionId);
	}
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
	public String getUserDetails(@RequestParam("sessionId")String sessionId) {
		AuthService service = new AuthService();
		return service.getUserDetails(sessionId);
	}
}