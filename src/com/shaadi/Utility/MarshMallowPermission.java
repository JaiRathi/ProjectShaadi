package com.shaadi.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

/**
 * @author Jaivir Singh
 *
 */
public class MarshMallowPermission {
	public static void grantPermission(WebDriver driver, String udid){
		if(System.getProperty("os.name").startsWith("Mac")) {
			Properties bashProfile = new Properties();
			String path = "/Users/" + System.getProperty("user.name")+ "/.bash_profile";
			try {
				bashProfile.load(new FileInputStream(path));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String sdkPath = bashProfile.getProperty("ANDROID_HOME");
			System.out.println("***************************Permission***************************");
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.ACCESS_FINE_LOCATION" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.ACCESS_COARSE_LOCATION" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_SMS" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.RECEIVE_SMS" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.CAMERA" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_CONTACTS" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.RECORD_AUDIO" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_CALL_LOG" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_PHONE_STATE" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_EXTERNAL_STORAGE" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.WRITE_EXTERNAL_STORAGE" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "settings", "secure", "location_providers_allowed", "+network" });
			executeADBCommand(new String[] { sdkPath+"/platform-tools/adb", "-s", udid, "-d", "shell", "settings", "secure", "location_providers_allowed", "+gps" });
		}else{
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.ACCESS_FINE_LOCATION"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.ACCESS_COARSE_LOCATION"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_SMS"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.RECEIVE_SMS"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.CAMERA"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_CONTACTS"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.RECORD_AUDIO"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_CALL_LOG"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_PHONE_STATE"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.READ_EXTERNAL_STORAGE"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "pm", "grant", "com.snapdeal.main", "android.permission.WRITE_EXTERNAL_STORAGE"});
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "settings", "secure", "location_providers_allowed", "+network" });
			executeADBCommand(new String[] { "adb", "-s", udid, "-d", "shell", "settings", "secure", "location_providers_allowed", "+gps" });
		}
	}
	
	private static void executeADBCommand(String[] args) {
	    ProcessBuilder pb = new ProcessBuilder(args);
	    Process pc;
	    try {
	        pc = pb.start();
	        pc.waitFor();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
