/**
 * @author
 * This class contains the reusable methods
 */
package com.scholastic.torque.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class UtilityMethods {
	public static Properties prop;

	/**
	 * This method picks the property values from property file
	 * 
	 * @return Properties
	 */
	public static Properties propertyValue(){
		String filePath = System.getProperty("java.class.path").split(";")[0].split("target")[0] +"src/test/resources/properties/application.properties";

		prop = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop; 
	}

	/**
	 * This method splits the string based on the delimeter and returns the list
	 * 
	 * @return List
	 */

	public List<String> splitString(String textToSplit, String delimeter){
		String[] data = textToSplit.split(",");
		List<String> strList = new ArrayList<>();

		for(String listData : data){
			strList.add(listData);
		}
		return strList;
	}	

	/**
	 *
	 * @return True if JavaScript Alert is present on the page otherwise false
	 */
	public boolean isAlertPresent(WebDriver driver){
		try{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException ex){
			return false;
		}
	}

	/**
	 *
	 * @return True if Webelement is present on the page otherwise false
	 */
	public boolean isElementVisible(final By by, WebDriver driver) throws InterruptedException {
		boolean value = false;

		if (driver.findElements(by).size() > 0) {
			value = true;
		}
		return value;
	}
}
