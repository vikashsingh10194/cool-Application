package com.scholastic.torque.stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.scholastic.torque.pageobjects.SearchResultsPageObject;

import cucumber.api.java.en.Then;

public class SearchResultsStepdefs {

	public SearchResultsPageObject searchResultPage;
	public WebDriver driver;

	public SearchResultsStepdefs()
	{
		driver = Hooks.driver;		
	}
	
	@Then("^the parent should be presented with the \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void shouldBePrsentedWithItemDetails(String itemDesc, String grade, String author, String listPrice)
			throws Throwable {
		searchResultPage = new SearchResultsPageObject(driver);
		Map<String, String> map = new HashMap<>();
		
		map = searchResultPage.searchResult();		
		
		String[] gradeMap = map.get("grade").split("(-)|(-)|(–)");
		String[] gradeValue = grade.split("(-)|(-)|(–)");
		
		for( int i = 0; i < gradeMap.length; i++){
			
			Assert.assertTrue("Item grade should be matching", gradeMap[i].trim().contains(gradeValue[i].trim())); 
		}
		
		Assert.assertEquals("Item description should be matching", map.get("itemDesc"), itemDesc.trim());		
		Assert.assertEquals("Item author should be matching", map.get("author"), author.trim());
		Assert.assertEquals("Item list price should be matching", map.get("listPrice"), listPrice.trim());
	}
}
