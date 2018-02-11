package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public String user="";
	public String pass="";




	
	
		
	public LoginPage(WebDriver driver) 
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
public LoginPage(WebDriver driver, String username, String pass ) 
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		user=username;
		this.pass=pass;
	}
	
		
	
//public void setUser(String username) {
//	this.user = username;
//}
//
//public void setPass(String pass) {
//	this.pass = pass;
//	
//}
	@FindBy(css="#user_email") WebElement email;
	@FindBy(css="#user_email") WebElement password;
	@FindBy(css="[class='btn btn-primary btn-md login-button']") WebElement loginButton;
	
	public void loginHere()
	{
		email.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	
	public WebElement userName() {
		
		return email;
	}
	public WebElement userPass() {
		
		return password;
	}
	
	public WebElement loginButton() {
		
		return loginButton;
	}

}
