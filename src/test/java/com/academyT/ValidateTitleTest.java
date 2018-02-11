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

public class ValidateTitleTest extends TestBase

{

	public static Logger logger =LogManager.getLogger(TestBase.class.getName());

	@BeforeTest
	public void initialize() throws IOException

	{
		driver = initializeDriver();
		logger.info("initializing driver for title page");
		driver.get(prop.getProperty("url"));
		logger.info("navigating to url ");
		// we getting properties objects throws testBase class
	}

	@Test
	public void validatingHomePageTitle() throws IOException

	{

		// driver.findElement(By.xpath("(//div[@class='sumome-react-wysiwyg-move-handle']/div/button)[2]")).click();
		logger.error("pop up blocking the click element function");
		LandingPage la = new LandingPage(driver);
		String pageTitle = la.getTtl().getText();

		Assert.assertEquals(prop.getProperty("hptitle"), pageTitle);
		logger.info("comparing the title page");

	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;
	}
}
