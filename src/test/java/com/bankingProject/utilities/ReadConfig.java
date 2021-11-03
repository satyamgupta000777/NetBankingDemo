package com.bankingProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		File src= new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch(Exception e){
			e.getMessage();
		}
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
		
	}
	
	
	public String getUsename() {
		String username=pro.getProperty("username");
		return username;
		
	}
	
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
		
	}
	
	public String getChromePath() {
		String chromePath=pro.getProperty("chromePath");
		return chromePath;
		
	}
	
	public String getIEPath() {
		String iePath=pro.getProperty("iePath");
		return iePath;
		
	}
	
	public String getFirefoxPath() {
		String firefoxPath=pro.getProperty("firefoxPath");
		return firefoxPath;
		
	}
	
	
}
