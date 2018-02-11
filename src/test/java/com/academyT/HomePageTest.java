package com.academyT;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.TestBase;

public class HomePageTest extends resources.TestBase

{	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeTest
	public void initialize() throws IOException

	{
		driver = initializeDriver();
		
		// driver object is getting form base class it is declared as public
		// its is returning us the driver object with browser initialized
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String user, String pass, String type)

	{
		// here we providing the url inside the test as will will require the url for
		// each parameter values. if we pass it in the before test
		// it will trigger the url only once before fist test case and will not get the
		// url for the rest of parameter every parameter is treatred as seperate test.

		driver.get("http://qaclickacademy.com");
		log.info("we are getting the url inside test not in before test for a reason");
//		try {
//			driver.findElement(By.xpath("(//div[@class='sumome-react-wysiwyg-move-handle']/div/button)[2]"))
//					.click();
//		} catch (NoSuchElementException e) {
//			
//		}
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();

		LoginPage logP = new LoginPage(driver, user, pass);
		logP.loginHere();
		log.info("calling the getlongin fucntion from the page class");
		System.out.println(type);

	}

	@DataProvider
	public Object[][] getData()

	{
		Object[][] obj = new Object[2][3];

		obj[0][0] = "user1@ga.com";
		obj[0][1] = "jhgvcv";
		obj[0][2] = "resstrected user";

		obj[1][0] = "user2@ga.com";
		obj[1][1] = "jhgvdddcv";
		obj[1][2] = "unresstrected user";

		return obj;
	}

	@AfterTest
	public void teardown()
	

	{
		log.fatal("killing the browser");
		driver.quit();
		driver = null;
	}
}
