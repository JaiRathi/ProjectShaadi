package com.shaadi.AppPages;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.shaadi.BaseQA.ReadPropertyFile;
import com.shaadi.BaseQA.TestBase;
import com.shaadi.Utility.Screenshot;

import io.appium.java_client.AppiumDriver;

/**
 * @author Jaivir Singh
 *
 */

public class ProfileSearchPage extends TestBase {

	public AppiumDriver<WebElement> driver;
	ReadPropertyFile OR;

	public ProfileSearchPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		try {
			OR = new ReadPropertyFile(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws Exception
	 *             This Method used to click on MatchProfile button after login then
	 *             clicking on search button to search partner
	 * 
	 */
	public void testSearchPage() throws Exception {
			WebElement gotITBtn = driver.findElement(By.xpath(OR.recommendedPageBtn()));
			try {
			if (gotITBtn.isDisplayed()) {
				gotITBtn.click();
				gotITBtn.click();
				searchBtnPage();
			} else {
				skipPage();
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "testSearchPage");
		}
	}

	/**
	 * @throws Exception
	 *             This Method used to skip the premium plans if comes
	 * 
	 */
	public void skipPage() throws Exception {
		try {
			WebElement skipBtn = driver.findElement(By.xpath(OR.skipPremiumPage()));
			if (skipBtn.isDisplayed()) {
				skipBtn.click();
				searchBtnPage();
			} else {
				System.out.println("No element found to move search page");
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "testSearchPage");
		}

	}

	/**
	 * @throws Exception
	 *             This Method used to click on search button from matched profile
	 * 
	 */
	public void searchBtnPage() throws Exception {
		try {
			List<WebElement> clickOnSearchButton = driver.findElements(By.className(OR.clickOnSearchButton()));
			if (clickOnSearchButton.size() > 0) {
				clickOnSearchButton.get(0).click();
				selectMaritalStatus();
				selectReligion();
				selectMotherTngue();
				selectCommunity();
				selectCountry();
				selectState();
				selectCity();
				selectDosham();

			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "searchBtnPage");

		}

	}

	/**
	 * @throws Exception
	 *             This Method used to select(Never Married) marital status & Click
	 *             on apply
	 * 
	 */

	public void selectMaritalStatus() throws Exception {
		try {
			WebElement searchPage = driver.findElement(By.id(OR.searchPage()));
			scrollToBottom(searchPage);
			driver.findElement(By.id(OR.selectMaritalStatus())).click();
			driver.findElement(By.id(OR.cancelSelectedText())).click();
			WebElement ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "Never Married");
			ele.click();
			WebElement clickApplyBtn = driver.findElement(By.id(OR.clickApplyBtn()));
			clickApplyBtn.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//",
					"selectMaritalStatus");

		}
	}

	/**
	 * @throws Exception
	 *             This Method used to Click on Religion>>Hindu & Click on apply
	 */
	public void selectReligion() throws Exception {
		try {
			WebElement searchPage = driver.findElement(By.id(OR.searchPage()));
			scrollToBottom(searchPage);
			driver.findElement(By.id(OR.clickReligion())).click();
			driver.findElement(By.id(OR.cancelSelectedText())).click();
			WebElement ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "Hindu");
			ele.click();
			driver.findElement(By.id(OR.clickApplyBtn())).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "selectReligion");

		}
	}

	/**
	 * @throws Exception
	 *             This Method used to Click on mother tongue>hindi & Click on apply
	 */
	public void selectMotherTngue() throws Exception {
		try {
			WebElement searchPage = driver.findElement(By.id(OR.searchPage()));
			scrollToBottom(searchPage);
			driver.findElement(By.id(OR.clickMotherTngue())).click();
			driver.findElement(By.id(OR.cancelSelectedText())).click();
			WebElement ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "Hindi");
			ele.click();
			driver.findElement(By.id(OR.clickApplyBtn())).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "selectMotherTngue");

		}
	}

	/**
	 * @throws Exception
	 *             This Method used to Click on community>>96k kokanastha,agri &
	 *             Click on apply /**
	 */
	public void selectCommunity() throws Exception {
		try {
			driver.findElement(By.id(OR.clickCommunity())).click();
			WebElement ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "96K Kokanastha");
			ele.click();
			ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "Agri");
			ele.click();
			driver.findElement(By.id(OR.clickApplyBtn())).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "selectCommunity");

		}
	}

	/**
	 * @throws Exception
	 *             This Method used to Click on country>>india,usa & Click on apply
	 *             /**
	 */
	public void selectCountry() throws Exception {
		try {
			driver.findElement(By.id(OR.clickCountry())).click();
			driver.findElement(By.id(OR.cancelSelectedText())).click();
			WebElement ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "India");
			ele.click();
			ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "USA");
			ele.click();
			driver.findElement(By.id(OR.clickApplyBtn())).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "selectCountry");

		}
	}

	/**
	 * @throws Exception
	 *             This Method used to Click on state>>maharashtra,Andhra Pradesh &
	 *             Click on apply
	 * 
	 */
	public void selectState() throws Exception {
		try {
			driver.findElement(By.id(OR.clickState())).click();
			driver.findElement(By.id(OR.cancelSelectedText())).click();
			WebElement ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "Andhra Pradesh");
			ele.click();
			ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "Maharashtra");
			ele.click();
			driver.findElement(By.id(OR.clickApplyBtn())).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "selectState");

		}
	}

	/**
	 * @throws Exception
	 *             This Method used to Click on city>>mumbai,Pune & & Click on apply
	 */
	public void selectCity() throws Exception {
		try {
			WebElement searchPage = driver.findElement(By.id(OR.searchPage()));
			scrollToBottom(searchPage);
			driver.findElement(By.id(OR.clickCity())).click();
			driver.findElement(By.id(OR.cancelSelectedText())).click();
			WebElement ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "Mumbai");
			ele.click();
			ele = scrollToExactElement(OR.scrollOnMothrTngPage(), "Pune");
			ele.click();
			driver.findElement(By.id(OR.clickApplyBtn())).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "selectCity");

		}
	}

	/**
	 * @throws Exception
	 *             Click on manglik/chevai dosham>>no manglik & & Click on apply
	 */
	public void selectDosham() throws Exception {
		WebElement searchPage = driver.findElement(By.id(OR.searchPage()));
		scrollToBottom(searchPage);
		try {
			driver.findElement(By.id(OR.clickDosham())).click();
			driver.findElement(By.id(OR.cancelSelectedText())).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		List<WebElement> selectDosham = driver.findElements(By.id(OR.selectDosham()));
		if (selectDosham.isEmpty()) {

		} else {
			selectDosham.get(1).click();
		}
		driver.findElement(By.id(OR.clickApplyBtn())).click();
		driver.findElement(By.id(OR.searchNow())).click();
		if (driver.findElement(By.id(OR.noSearchResult())).isDisplayed()) {
			Screenshot.takeScreenShot(System.getProperty("user.dir") + "//Screenshots//Failure//", "noSearchResult");
		} else if (!driver.findElement(By.id(OR.noSearchResult())).isDisplayed()) {

		}
	}
}
