package com.scholastic.torque.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		monochrome = true,
		plugin = {"pretty:target/Junit/pretty.txt", "json:target/Junit/output.json", "html:target/Junit/htmlReport"},
		glue = "com.scholastic.torque.stepdefinitions",
		features = {"src/test/resources/features/Search.feature"},		
		tags= {"@Search", "@en_US", "@P1"}
		)

public class JUnitRunnerTest {
	
}

