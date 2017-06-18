package com.crossover.service;

import com.crossover.bean.SessionBean;
import com.crossover.bean.User;
import com.crossover.dao.AuthDAO;
import com.google.gson.Gson;

public class AuthService {

	public String getUserSession(String uname, String pass) {
		AuthDAO dao= new AuthDAO();
		SessionBean data=dao.getUserSession(uname,pass);
		Gson convert= new Gson();
		return convert.toJson(data);
	}
	
	public String logout(String sessionId){
		AuthDAO dao= new AuthDAO();
		return dao.logout(sessionId);
	}

	public String getUserDetails(String sess) {
		// TODO Auto-generated method stub
		AuthDAO dao= new AuthDAO();
		User data=dao.getUserDetails(sess);
		Gson convert= new Gson();
		System.out.println(data);
		return convert.toJson(data);
	}

}
