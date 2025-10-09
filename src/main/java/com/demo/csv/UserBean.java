package com.demo.csv;

import com.opencsv.bean.CsvBindByName;

public class UserBean {
	@CsvBindByName(column = "username")
	private String username;
	@CsvBindByName(column = "password")

	private String password;

	public UserBean() {

	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password + "]";
	}

}
