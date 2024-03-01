package pageTests;

import static utils.PropertyReaderHelper.getCustomProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testConfig.BaseTest;

@Listeners(utils.ListenerHelper.class)
public class LoginPageTests extends BaseTest{
	
	private Logger log=LogManager.getLogger(this.getClass().getName());
	
	public LoginPageTests() 
	{
		key = "loginPage";
	}
	
	
	@Test(priority=1, description="User is able to login with valid username and password and redirected to HomePage")
	public void ValidLoginTest() {
		
	  loginPage.redirectToLoginPage(getCustomProperty("loginPageUrl"));
	  log.info("Redirected to login page");
	  homePage=  loginPage.loginUser(getCustomProperty("emailAddress"),getCustomProperty("password"));
	  log.info("Enter valid Email & Password then click on login button");
	  String actualTitle=driver.getTitle();
	  log.info("Title of Home Page will be displayed");
	  String expectedTitle="Manning";
	  Assert.assertEquals(actualTitle, expectedTitle, "Manning");
	  log.info("Actual & expected titles are matching");
	   
	}
	
	@Test(priority=2, description="User is not able to login")
	public void InvalidLoginTest() {
	   
	   loginPage.redirectToLoginPage(getCustomProperty("loginPageUrl"));
	   log.info("Redirected to login page");
	   loginPage.loginUser(getCustomProperty("emailAddress"),getCustomProperty("incorrectPassword"));
	   log.info("Enter valid Email & invalid Password");
	   String text=loginPage.getIncorrectLoginWarning();	   
	   Assert.assertEquals(text, "Authentication attempt has failed, likely due to invalid credentials. Please verify and try again.");
	   log.info("Authentication failed message");
	}

}


