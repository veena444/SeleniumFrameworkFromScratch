package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//page_url =  https://login.manning.com/login?service=https%3A%2F%2Fwww.manning.com%2Flogin%2Fcas

public class LoginPage {
	
private WebDriver driver;
//public static Logger log;
	
	//Locators for Login Page
	
	private By emailID=By.id("username-sign-in");
	private By password=By.id("password-sign-in");
	private By loginButton= By.name("submit");
	private By incorrectLoginWarining = By.id("msg");
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Methods to interact with the web elements
	
	public void redirectToLoginPage(String url) {
		driver.get(url);
	}
	
	public void setEmailID(String emailId) {
		driver.findElement(emailID).sendKeys(emailId);
	
	}
	
	public void setPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public HomePage loginUser(String email, String passwd) {
		setEmailID(email);
		setPassword(passwd);
		clickLoginButton();
		
		return new HomePage(driver);
	}
	
	public String getIncorrectLoginWarning() {
		return driver.findElement(incorrectLoginWarining).getText();
		
	}

}
