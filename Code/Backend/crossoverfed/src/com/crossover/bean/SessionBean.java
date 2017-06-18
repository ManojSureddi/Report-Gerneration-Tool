package com.crossover.bean;

public class SessionBean {
	private String sessionId;
	private boolean loginSucceeded;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public boolean getLoginSucceeded() {
		return loginSucceeded;
	}
	public void setLoginSucceeded(boolean loginSucceeded) {
		this.loginSucceeded = loginSucceeded;
	}
}
