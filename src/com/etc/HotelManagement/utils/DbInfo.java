package com.etc.HotelManagement.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/************************************
 *@className   DbInfo.java
 *@author      ���
 *@date        2009��1��1��-����12:15:45
 *@version     V1.0
 *@description 
 *
 *************************************/
public class DbInfo {
	private ConfigureDbInfo  configureDbInfo ;
	private static DbInfo dbInfo ;
	private DbInfo(){
		configureDbInfo = new ConfigureDbInfo() ;
		getProperties();
	}
	public static DbInfo getInstance(){
		if(dbInfo == null){
			dbInfo = new DbInfo() ;
		}
		return dbInfo ;
	}
	  public void getProperties(){
		  FileInputStream fisFileInputStream = null;		  
		 try {
			String path =  DbInfo.class.getResource("/").toURI().getPath() + "db.properties" ;
			File file = new File(path) ;
			try {
				fisFileInputStream = new FileInputStream(file) ;
			} catch (FileNotFoundException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
			Properties properties = new Properties() ;
			try {
				properties.load(fisFileInputStream);
			} catch (IOException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
			  configureDbInfo.setDbdriver(properties.getProperty("dbdriver"));
			  configureDbInfo.setDbURL(properties.getProperty("dbURL"));
			  configureDbInfo.setPwd(properties.getProperty("pwd"));
			  configureDbInfo.setUname(properties.getProperty("uname"));
		} catch (URISyntaxException e) {
			 Log.logger.debug(e.getMessage());
			e.printStackTrace();
		} finally{
			if(fisFileInputStream != null){
				try {
					fisFileInputStream.close();
				} catch (IOException e) {
					Log.logger.debug(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		  
	  }
	  public String getDbdriver(){
		  String dbdriver = null ;
		  if(configureDbInfo != null){
			  dbdriver = configureDbInfo.getDbdriver() ;
		  }
		  return dbdriver ;
	  }
	  public String getDbURL(){
		  String dbURL = null ;
		  if(configureDbInfo != null){
			  dbURL = configureDbInfo.getDbURL() ;
		  }
		  return dbURL ;
	  }
	  public String getUname(){
		  String unameString = null  ;
		  if(configureDbInfo != null){
			  unameString = configureDbInfo.getUname() ;
		  }
			return unameString ;	  
	  }
	  public String getpwd(){
		  String pwdString = null ;
		  if(configureDbInfo != null){
			  pwdString = configureDbInfo.getPwd() ;
		  }
		  return pwdString ;
	  }
	class ConfigureDbInfo {
		private String dbdriver ; 
		private String dbURL ; 
		private String uname ;
		private String pwd ;
		public String getDbdriver() {
			return dbdriver;
		}
		public void setDbdriver(String dbdriver) {
			this.dbdriver = dbdriver;
		}
		public String getDbURL() {
			return dbURL;
		}
		public void setDbURL(String dbURL) {
			this.dbURL = dbURL;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		
	}
}
