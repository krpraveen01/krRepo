package com.krpk.springboot.SpringEurekaClient2.service;


public class UserInfo {
	
	private int userId;
	private String name;
	private String gender;
	private String phNUm;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhNUm() {
		return phNUm;
	}
	public void setPhNUm(String phNUm) {
		this.phNUm = phNUm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
