package com.shaadi.Utility;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.shaadi.BaseQA.TestBase;




public class Screenshot extends TestBase {
	 static Calendar cal = new GregorianCalendar();
	 static int date = cal.get(Calendar.DATE);
	  static int month = cal.get(Calendar.MONTH); //4
	  static int year = cal.get(Calendar.YEAR); //2013
	  static int sec =cal.get(Calendar.SECOND);
	  static int min =cal.get(Calendar.MINUTE);
	  static int day =cal.get(Calendar.HOUR_OF_DAY);

	public static void takeScreenShot(String location, String fileName)
	{

		File f1 =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(f1, new File(location + "/" + fileName + date+"_"+(month+1)+"_"+(year)+"_"+(day)+"_"+min+"_" +sec+ ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}