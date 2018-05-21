package com.shaadi.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

/**
 * @author Jaivir Singh
 *
 */
public class DataReadProperty {
	//public WebDriver driver;
	public static Properties testData = new Properties();
	public static FileInputStream fis ;
	
	public DataReadProperty(WebDriver driver) throws Exception {
		//this.driver = driver;
		try {
			fis= new FileInputStream(System.getProperty("user.dir")+"/src/com/shaadi/TestData/LoginTestData");	
		
			testData.load(fis);

			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public String getUserName(){
	return testData.getProperty("UserName");
}
public String getPassword(){
	return testData.getProperty("Password");
}
    
}


