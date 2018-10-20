/**
 * @author
 * This class contains the page objects or elements for Home Page
 */

package com.scholastic.torque.pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePageObject extends BaseClass {
	
	public HomePageObject(WebDriver driver) {
        super(driver);
    }
	
	/**
	 * This method opens the application url 
	 */
	public void openUrl(String url){
		driver.get(url);
	}
}
