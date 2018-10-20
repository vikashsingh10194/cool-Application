package com.scholastic.torque.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.scholastic.torque.pageobjects.SearchPageObject;

import cucumber.api.java.en.Given;

public class SignInStepdefs {
	public SearchPageObject searchPage;
	public WebDriver driver;

	public SignInStepdefs() {
		driver = Hooks.driver;
	}

	@Given("^A Parent Who is logged-in$")
	public void a_Parent_Who_is_logged_in() throws Throwable {
		searchPage = new SearchPageObject(driver);		
		Assert.assertEquals("Parent has been logged in", "Sign Out", searchPage.signOutButtonText());
	}
}
