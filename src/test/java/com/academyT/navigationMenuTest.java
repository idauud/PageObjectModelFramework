package com.academyT;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.TestBase;

public class navigationMenuTest extends TestBase

{
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	@BeforeTest
	public void initialize() throws IOException 
	
	{
		driver =initializeDriver(); 
		driver.get(prop.getProperty("url"));
	}

	
	@Test
	public void navigationMenuValidationTest() throws IOException 
	
	{
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationMenu().isDisplayed());
		log.info("validating if the navigation bar is displayed");
		
	}
	
	@AfterTest
	public void teardown() 
	
	{
		
		driver.close();
		driver = null;
		
	}

}
