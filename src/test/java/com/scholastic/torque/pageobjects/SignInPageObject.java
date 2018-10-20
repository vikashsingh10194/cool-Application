/**
 * @author
 * This class contains the page objects or elements for SignIn Page
 */

package com.scholastic.torque.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageObject extends BaseClass {
		
	@FindBy(id = "logonId")
	private WebElement userIDInputBox;
	
	@FindBy(id = "logonPassword")
	private WebElement passwordInputBox;
	
	@FindBy(css = ".sign-in .signInButton")
	private WebElement signInButton;

    public SignInPageObject(WebDriver driver) throws IOException {    	
    	super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void enterLoginDetails(String userID, String password){
    	userIDInputBox.sendKeys(userID);
    	passwordInputBox.sendKeys(password);
    }
    
    public SearchPageObject clickSignInButton(){
    	signInButton.click();
    	return PageFactory.initElements(driver, SearchPageObject.class);
    }
}
