package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
		
	public LandingPage(WebDriver driver) 
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href*='com/sign_in']") 
	WebElement signin ;
	
	@FindBy(css=".text-center>h2")
	WebElement title;
	
	@FindBy(css="[class='nav navbar-nav navbar-right']")
	WebElement navigationMenu;
	
	public WebElement getNavigationMenu()
	{
		return navigationMenu;
	}

	
	public WebElement  getLogin()
	{
		
		return signin; 
	}
	
	public WebElement getTtl() {
		
		return title;
	}
	
	
}
