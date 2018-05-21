package com.shaadi.Test;

import org.testng.annotations.Test;

import org.testng.annotations.Listeners;

import com.shaadi.AppPages.LoginPage;
import com.shaadi.AppPages.ProfileSearchPage;
import com.shaadi.BaseQA.TestBase;
import com.shaadi.Utility.Screenshot;

@Listeners(com.shaadi.Reports.CustomeReport.class)

/**
 * @author Jaivir Singh
 *
 */
public class TestSuite extends TestBase {

	@Test(priority = 0)
	public void verifyLoginPage() throws Exception {
		LoginPage lgBtn = new LoginPage(driver);
		lgBtn.testLoginPage();
		Screenshot.takeScreenShot(System.getProperty("user.dir")+"//Screenshots//Success//","verifyLoginPage");


	}
	@Test(priority = 1)
	public void verifySearchPage() throws Exception {
		ProfileSearchPage searchPrfle = new ProfileSearchPage(driver);
		searchPrfle.testSearchPage();
		Screenshot.takeScreenShot(System.getProperty("user.dir")+"//Screenshots//Success//","verifySearchPage");

	}
}
