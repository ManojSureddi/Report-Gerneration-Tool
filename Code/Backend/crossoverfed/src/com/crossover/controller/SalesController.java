package com.crossover.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.dao.AuthDAO;
import com.crossover.dao.SalesDAO;
import com.crossover.service.AuthService;
import com.crossover.service.SalesService;

@RestController
@RequestMapping(value = "/data")
public class SalesController {
	@RequestMapping(value = "/salesmandata", method = RequestMethod.POST, headers = "Accept=application/json")
	public String getSalesmanData(@RequestParam("sessionId")String sessionId) {

		SalesService service = new SalesService();
		return service.getSalesmanData(sessionId);
	}

	@RequestMapping(value = "/lastyeardata", method = RequestMethod.POST, headers = "Accept=application/json")
	public String getLastYearData(@RequestParam("sessionId")String sessionId) {
		SalesService service = new SalesService();
		return service.getLastYearData(sessionId);
	}
	@RequestMapping(value = "/topsalesorder", method = RequestMethod.POST, headers = "Accept=application/json")
	public String getTopSalesOrder(@RequestParam("sessionId")String sessionId) {
		SalesService service = new SalesService();
		return service.getTopSalesOrder(sessionId);
	}
	@RequestMapping(value = "/topsalesman", method = RequestMethod.POST, headers = "Accept=application/json")
	public String getTopSalesman(@RequestParam("sessionId")String sessionId) {
		SalesService service = new SalesService();
		return service.getTopSalesman(sessionId);
	}
}
