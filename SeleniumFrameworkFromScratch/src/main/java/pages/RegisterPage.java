package pages;

import static base.CustomWaits.staticWait;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	
WebDriver driver;
	
	//locators
	
	private By registerNewAccount = By.id("showRegistration");
	private By firstName = By.xpath("//*[@id='firstName']");
	//private By firstName = By.id("firstName");
	private By lastName = By.xpath("//*[@id='lastName']");
	private By email = By.xpath("//*[@id='username']");
	private By password = By.xpath("//*[@id='password']");
	private By createAcctButton=By.xpath("/html[1]/body[1]/div[1]/div[4]/form[1]/div[5]/button[1]");
	
	
	//private By createAcctButton =By.xpath("//*[@name='signInBtn']");
	private String page_url ="https://login.manning.com/login?service=https%3A%2F%2Fwww.manning.com%2Flogin%2Fcas";
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPage redirectToRegisterPage() {
		driver.get(page_url);
		driver.findElement(registerNewAccount).click();
		return new RegisterPage(driver);
	}
	
	public void setFirstName(String fstName) {
		driver.findElement(firstName).sendKeys(fstName);
	}
	
	public void setLastName(String lstName) {
		driver.findElement(lastName).sendKeys(lstName);
	}
	
	public void setEmailId(String Email) {
		driver.findElement(email).sendKeys(Email);
	}
	
	public void setPassword(String pswd) {
		driver.findElement(password).sendKeys(pswd);
	}
	
	public void setCreateAccountButton() {
		driver.findElement(createAcctButton).sendKeys(Keys.ENTER);
	}
	
	public AccountPage RegisterUser(String fName, String lName, String Email, String paswd) {
		
		setFirstName(fName);
		staticWait(1);
		setLastName(lName);
		staticWait(1);
		setEmailId(Email);
		staticWait(1);
		setPassword(paswd);
		staticWait(1);
		setCreateAccountButton();
		staticWait(10);		 
		
		return new AccountPage(driver);
	}

}
