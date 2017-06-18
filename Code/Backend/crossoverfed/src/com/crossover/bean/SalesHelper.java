package com.crossover.bean;

import java.util.ArrayList;
import java.util.LinkedList;

public class SalesHelper {
	private String requestDescription;
	private LinkedList<Object[]> data;
	public LinkedList<Object[]> getData() {
		return data;
	}
	public void setData(LinkedList<Object[]> data) {
		this.data = data;
	}
	public String getRequestDescription() {
		return requestDescription;
	}
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

}
