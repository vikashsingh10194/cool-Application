package com.scholastic.torque.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.scholastic.torque.pageobjects.SearchPageObject;

import cucumber.api.java.en.When;

public class SearchStepdefs {
	public SearchPageObject searchPage;
	public WebDriver driver;

	public SearchStepdefs()
	{
		driver = Hooks.driver;		
	}

	@When("^the parent searches for \"([^\"]*)\"$")
	public void parentShouldSearchFor(String item) throws Throwable {
	   searchPage = new SearchPageObject(driver);
	   searchPage.enterSearchString(item);
	   searchPage.clickSearchButton();
	}
}
