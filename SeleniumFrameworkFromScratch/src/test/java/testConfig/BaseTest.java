package testConfig;

import static utils.PropertyReaderHelper.getCustomProperty;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.SetupDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class BaseTest extends SetupDriver {
	
	//PageObjects
			public HomePage homePage;
			public LoginPage loginPage;
			public RegisterPage registerPage;
			public AccountPage accountPage;
			
			
			public WebDriver getDriver() {
				return driver;
			}
			
			//key for page object initialization
			public String key;
			
			
			public BaseTest() {				
				browserType=getCustomProperty("browser");				
			}
			
			
			@BeforeMethod(alwaysRun = true)
			public void setUp() {				
				setUpDriver();
				if(key.equalsIgnoreCase("homepage")) {
					homePage = new HomePage(driver);
				}
				else if(key.equalsIgnoreCase("loginpage")) {
					loginPage=new LoginPage(driver);
				}
				else if(key.equalsIgnoreCase("registerpage")) {
					registerPage=new RegisterPage(driver);
				}
				else {
					System.out.println("Page is not yet defined!");
				}
			}
			
			// close browser
			@AfterMethod(alwaysRun = true)
			public void tearDown() {				
				quitDriver();
			}


}
