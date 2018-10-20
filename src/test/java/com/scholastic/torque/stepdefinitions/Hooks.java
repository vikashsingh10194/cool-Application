package com.scholastic.torque.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scholastic.torque.common.UtilityMethods;
import com.scholastic.torque.pageobjects.HomePageObject;
import com.scholastic.torque.pageobjects.SignInPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {	

	public HomePageObject homePage;
	public SignInPageObject signInPage;
	public static WebDriver driver;
	
	@Before
	/**
	 * Delete all cookies at the start of each scenario to avoid shared state
	 * between tests
	 */
	public void openBrowser() throws IOException {
		String browserName = UtilityMethods.propertyValue().getProperty("browser").toLowerCase().trim();

		if (driver == null) {

			switch (browserName) {
			case "ff":
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				break;

			default:
				break;
			}
			homePage = new HomePageObject(driver);
			homePage.openUrl(UtilityMethods.propertyValue().getProperty("url"));
			signInPage = new SignInPageObject(driver);
			signInPage.enterLoginDetails(UtilityMethods.propertyValue().getProperty("userID"),
					UtilityMethods.propertyValue().getProperty("password"));
			signInPage.clickSignInButton();
		}				
	}

	@After
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	public void embedScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				// byte[] screenshot = getScreenshotAs(OutputType.BYTES);
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}		
		}	
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                driver.close();               
            }
        });
	}

}