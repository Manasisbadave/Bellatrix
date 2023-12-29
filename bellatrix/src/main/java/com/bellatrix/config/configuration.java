package com.bellatrix.config;

import com.bellatrix.utilities.FileUtil;

public class configuration {
	public String getAppUrl() {

		FileUtil file = new FileUtil();
		return file.getProperty("/src/main/resources/config.properties", "app.url");
	}
	
	public String getUsername() {

		FileUtil file = new FileUtil();
		return file.getProperty("/src/main/resources/config.properties", "Username");
	}
	
	public String getPassword() {

		FileUtil file = new FileUtil();
		return file.getProperty("/src/main/resources/config.properties", "password");
	}
}
