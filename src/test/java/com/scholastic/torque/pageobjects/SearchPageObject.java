/**
 * @author
 * This class contains the page objects or elements for Search Criteria Page
 */

package com.scholastic.torque.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scholastic.torque.common.UtilityMethods;

public class SearchPageObject extends BaseClass {
	private UtilityMethods utilMethods;
	
	@FindBy(id = "Ntt")
	private WebElement searchTextBox;
	
	@FindBy(id = "goButtonElement")
	private WebElement searchButton;
	
	@FindBy(css = "a[id*='uniNavSIO']")
	private WebElement signOutButton;
	
    public SearchPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    /**
	 * This method checks for the pop-up and closes the pop-up if exists
	 * It also enters the login user credentials
     * @throws InterruptedException 
	 */
    public void enterSearchString(String itemValue) throws InterruptedException{
    	utilMethods = new UtilityMethods();
    	if(utilMethods.isElementVisible(By.cssSelector("a[class*='fsrDeclineButton']"), driver)){
    		driver.findElement(By.cssSelector("a[class*='fsrDeclineButton']")).click();
    	}
    	searchTextBox.clear();
    	searchTextBox.sendKeys(itemValue.trim());
    }
    
    /**
	 * This method clicks on the search button and the driver instance is passed to the next page
	 */    
    public SearchResultsPageObject clickSearchButton(){
    	searchButton.click();
    	return PageFactory.initElements(driver, SearchResultsPageObject.class);
    }
    
    /**
     * This method returns sign out text displayed on the page
     */
    public String signOutButtonText(){
    	return signOutButton.getText();
    }
     
}
