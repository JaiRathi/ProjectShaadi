package com.shaadi.BaseQA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

/**
 * Below method will be used to read the locators of pages from property file
 * and return them for actions.
 * 
 * @author Jaivir Singh
 *
 */
public class ReadPropertyFile {
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	@SuppressWarnings("static-access")
	public ReadPropertyFile(WebDriver driver) throws Exception {
		this.driver = driver;
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/com/shaadi/PagesProperties/ORPages.properties");
			OR.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * All below method will return the element xpath of Login Page
	 * 
	 * @author jaivir.singh
	 */
	public String initialPage() {
		return OR.getProperty("initialScroller");
	}

	public String signInButton() {
		return OR.getProperty("clickSignInButton");
	}

	public String enterUserName() {
		return OR.getProperty("enterUserName");
	}

	public String enterPassword() {
		return OR.getProperty("enterPassword");
	}

	public String clickSignInBtn() {
		return OR.getProperty("clickSignInBtn");
	}

	/**
	 * All below method will return the element xpath of Search Page
	 * 
	 * @author jaivir.singh
	 */
	public String recommendedPageBtn() {
		return OR.getProperty("recommendedPageBtn");
	}

	public String skipPremiumPage() {
		return OR.getProperty("skipPremiumPage");
	}

	public String clickOnSearchButton() {
		return OR.getProperty("clickOnSearchButton");
	}

	public String searchPage() {
		return OR.getProperty("searchPage");
	}

	public String selectMaritalStatus() {
		return OR.getProperty("selectMaritalStatus");
	}

	public String selectNeverMrdStatus() {
		return OR.getProperty("selectNeverMrdStatus");
	}

	public String clickApplyBtn() {
		return OR.getProperty("clickApplyBtn");
	}

	public String clickReligion() {
		return OR.getProperty("clickReligion");
	}

	public String selectReligion() {
		return OR.getProperty("selectReligion");
	}

	public String clickMotherTngue() {
		return OR.getProperty("clickMotherTngue");
	}

	public String selectMotherTngue() {
		return OR.getProperty("selectMotherTngue");
	}

	public String scrollOnMothrTngPage() {
		return OR.getProperty("scrollOnMothrTngPage");
	}

	public String clickCommunity() {
		return OR.getProperty("clickCommunity");
	}

	public String selectCommunity() {
		return OR.getProperty("selectCommunity");
	}

	public String clickCountry() {
		return OR.getProperty("clickCountry");
	}

	public String selectCountry() {
		return OR.getProperty("selectCountry");
	}

	public String clickState() {
		return OR.getProperty("clickState");
	}

	public String selectState() {
		return OR.getProperty("selectState");
	}

	public String clickCity() {
		return OR.getProperty("clickCity");
	}

	public String selectCity() {
		return OR.getProperty("selectCity");
	}

	public String clickDosham() {
		return OR.getProperty("clickDosham");
	}

	public String selectDosham() {
		return OR.getProperty("selectDosham");
	}

	public String searchNow() {
		return OR.getProperty("searchNow");
	}

	public String scrollOnList() {
		return OR.getProperty("scrollOnList");
	}

	public String cancelSelectedText() {
		return OR.getProperty("cancelSelectedText");
	}

	public String noSearchResult() {
		return OR.getProperty("checkSearchResult");
	}
}