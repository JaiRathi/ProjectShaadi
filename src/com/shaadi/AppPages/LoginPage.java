package com.shaadi.AppPages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.shaadi.BaseQA.ReadPropertyFile;
import com.shaadi.BaseQA.TestBase;
import com.shaadi.Utility.DataReadProperty;
import com.shaadi.Utility.Screenshot;

import io.appium.java_client.AppiumDriver;

/**
 * @author Jaivir Singh
 *
 */

public class LoginPage extends TestBase {
	public AppiumDriver<WebElement> driver;
	ReadPropertyFile OR;

	public LoginPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		try {
			OR = new ReadPropertyFile(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws Exception
	 *             Method used to click on login button from Screen and verify the
	 *             element is displayed on page.
	 * 
	 */
	public void testLoginPage() throws Exception {
		try {
			WebElement pages = driver.findElement(By.id(OR.initialPage()));
			while (pages.isDisplayed()) {
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				WebElement signInBtn = driver.findElement(By.id(OR.signInButton()));
				String signIn = signInBtn.getText();
				if (signIn.equals("Sign In")) {
					signInBtn.click();
					testUserName();
					testPassword();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir")+"//Screenshots//Failure//","testLoginPage");

		}
	}

	/**
	 * Method used to check User Name element present or not And Sending the
	 * username in text field
	 */
	public void testUserName() {
		try {
			DataReadProperty testData = new DataReadProperty(driver);
			WebElement result = driver.findElement(By.id(OR.enterUserName()));
			if (result.isDisplayed()) {
				result.sendKeys(testData.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method used to check password element presence on page and And Sending the
	 * password in text field
	 */
	public void testPassword() {
		try {
			DataReadProperty testData = new DataReadProperty(driver);
			WebElement result = driver.findElement(By.id(OR.enterPassword()));
			if (result.isDisplayed()) {
				result.sendKeys(testData.getPassword());
				WebElement signin = driver.findElement(By.id(OR.clickSignInBtn()));
				System.out.println("clicking on Sign In button of Login Page" + signin.getText());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				signin.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
