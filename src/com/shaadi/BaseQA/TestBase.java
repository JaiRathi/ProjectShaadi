package com.shaadi.BaseQA;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.shaadi.Utility.MarshMallowPermission;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * @author Jaivir Singh
 *
 */

public class TestBase extends AppAttributes {
	protected static AppiumDriver<WebElement> driver;

	private URL appiumServiceUrl;
	private AppiumDriverLocalService appiumService;

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Method will start Appium Server
	 */
	public AppiumDriverLocalService startAppiumServer() throws IOException, InterruptedException {

		// Starting Appium server on available port
		AppiumDriverLocalService appiumService = null;
		try {
			appiumService = AppiumDriverLocalService.buildService(
					new AppiumServiceBuilder().usingDriverExecutable(new File(AppAttributes.APPIUM_NODE_PATH))
							.withAppiumJS(new File(AppAttributes.APPIUM_JS_PATH)));
			appiumService.start();
		} catch (Exception e) {
			System.out.println("Error while starting server :: " + e);
			throw new RuntimeException();
		}
		return appiumService;
	}

	/**
	 * Method will set device capabilities and return Appium driver
	 */
	public AppiumDriver<WebElement> initDriver() throws IOException, InterruptedException {

		appiumService = startAppiumServer();
		appiumServiceUrl = appiumService.getUrl();
		System.out.println("Appium Service Address : - " + appiumServiceUrl.toString());

		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities capabilities = getDefaultCapabilties();
		appendAdditonalCapabiliteis(capabilities);

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the shaadi App in Android Device using the configurations
		// specified in Desired Capabilities
		AppiumDriver<WebElement> driver = new AndroidDriver<>(appiumServiceUrl, capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * Method will be used to create the instance of driver to launch the App.
	 */
	private DesiredCapabilities getDefaultCapabilties() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", AppAttributes.PLATFORM_VERSION);
		capabilities.setCapability("deviceName", AppAttributes.DEVICE_NAME);
		capabilities.setCapability("platformName", AppAttributes.PLATFORM_NAME);
		capabilities.setCapability("udid", AppAttributes.UDID);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
		capabilities.setCapability("appPackage", AppAttributes.APP_PACKAGE);
		capabilities.setCapability("appActivity", AppAttributes.APP_ACTIVITY);
		capabilities.setCapability("app", AppAttributes.APP);
		return capabilities;
	}

	private void appendAdditonalCapabiliteis(DesiredCapabilities defaultCapabilites) {

	}

	/**
	 * Method will be used to fetch the property of App and setting up the
	 * environment
	 */
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "env" })
	public void setUp(@Optional("app") String file) throws IOException, InterruptedException {
		try {
			setConfig(file);
			driver = initDriver();
			MarshMallowPermission.grantPermission(driver, AppAttributes.UDID);
		} catch (Exception e) {
			System.out.println("Getting error while setting environment :: " + e);
		}

	}

	/**
	 * Method will be used to stop Appium services after suite execution or Failed
	 */
	@AfterSuite(alwaysRun = true)

	public void stopAppium() {
		System.out.println("Stop driver");
		WebDriverWait wait = new WebDriverWait(driver, 400);
		driver.quit();
		System.out.println("Stop appium service");
		appiumService.stop();
	}

	/**
	 * Method will be used to scroll to bottom by using element dimension
	 */
	public static void scrollToBottom(WebElement ele) {
		try {
			Dimension eleSize = ele.getSize();
			int startx = eleSize.width / 2;
			int starty = (int) (eleSize.height * 0.8);
			int endx = eleSize.width / 2;
			int endy = (int) (eleSize.height * 0.4);
			new TouchAction((PerformsTouchActions) driver).press(startx, starty).waitAction().moveTo(endx, endy)
					.release().perform();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Method will be used to scroll exact element
	 */
	public WebElement scrollToExactElement(String parentViewId, String str) {
		return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""
				+ parentViewId + "\")).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"" + str
				+ "\")"));
	}

	/**
	 * Method will be used to scroll to top by using element dimension
	 */
	public static void scrollToTop(WebElement ele) {
		try {
			Dimension eleSize = ele.getSize();
			int startx = eleSize.width / 2;
			int starty = (int) (eleSize.height * 0.2);
			int endx = eleSize.width / 2;
			int endy = (int) (eleSize.height * 0.8);
			new TouchAction((PerformsTouchActions) driver).press(startx, starty).waitAction().moveTo(endx, endy)
					.release().perform();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Method will be used to scroll to top by using element dimension
	 */
	public static void scrollToLeft(WebElement ele) {
		try {
			Dimension eleSize = ele.getSize();
			int startx = (int) (eleSize.width * 0.8);
			int starty = (int) (eleSize.height / 2);
			int endx = (int) (eleSize.width * 0.2);
			int endy = (int) (eleSize.height / 2);
			new TouchAction((PerformsTouchActions) driver).press(startx, starty).waitAction().moveTo(endx, endy)
					.release().perform();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Method will be used to wait for element to be visible
	 */
	public WebElement getElementWhenReady(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

}
