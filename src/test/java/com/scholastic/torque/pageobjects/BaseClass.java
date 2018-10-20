/**
 * @author
 * This is a base class which other base classes will extend to get the driver instance
 */

package com.scholastic.torque.pageobjects;

import org.openqa.selenium.WebDriver;

public abstract class BaseClass {
	public static WebDriver driver;
	public static boolean bResult;

	//Constructor
	public BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}

}
