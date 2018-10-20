/**
 * @author
 * This class contains the page objects or elements for Search Results Page
 */

package com.scholastic.torque.pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPageObject extends BaseClass {
	
	@FindBy(css = "div[id*='productHeader'] h1")
	private WebElement itemDescriptionText;
	
	@FindBy(css = "div[id*='otherCatalogsToolTip'] > p > a:nth-of-type(1)")
	private WebElement authorNameText;
	
	@FindBy(id = "grades")
	private WebElement gradeRangeText;
	
	@FindBy(css = ".listPrc")
	private WebElement listPriceText;
	
    public SearchResultsPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    /**
	 * This method stores the page result into the map using key-value pair
	 * 
	 * @return Map
	 */
    public Map<String, String> searchResult(){
    	String[] item = itemDescriptionText.getText().split("\\(");
    	String[] gr = gradeRangeText.getText().split(":");
    	String[] pr = listPriceText.getText().split("\\$"); 	
    	    	    	
    	Map<String, String> map = new HashMap<String, String>();
    	    	
    	map.put("itemDesc", item[0].trim());
    	map.put("grade", gr[1].trim());
    	map.put("author", authorNameText.getText());
    	map.put("listPrice", pr[1].trim());
    	
    	return map;
    }
}
