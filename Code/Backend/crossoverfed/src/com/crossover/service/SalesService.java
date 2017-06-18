package com.crossover.service;

import com.crossover.bean.SalesHelper;
import com.crossover.dao.SalesDAO;
import com.google.gson.Gson;

public class SalesService {

	public String getSalesmanData(String sessionId) {
		SalesDAO dao = new SalesDAO();
		SalesHelper data=dao.getSalesmanData(sessionId);
		Gson convert= new Gson();
		return convert.toJson(data);
	}

	public String getLastYearData(String sessionId) {
		SalesDAO dao = new SalesDAO();
		SalesHelper data=dao.getLastYearData(sessionId);
		Gson convert= new Gson();
		return convert.toJson(data);
	}

	public String getTopSalesman(String sessionId) {
		// TODO Auto-generated method stub
		SalesDAO dao = new SalesDAO();
		SalesHelper data=dao.getTopSalesman(sessionId);
		Gson convert= new Gson();
		return convert.toJson(data);
	}

	public String getTopSalesOrder(String sessionId) {
		// TODO Auto-generated method stub
		SalesDAO dao = new SalesDAO();
		SalesHelper data=dao.getTopSalesOrder(sessionId);
		Gson convert= new Gson();
		return convert.toJson(data);
	}



}
