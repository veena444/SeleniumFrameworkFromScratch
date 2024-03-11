package pageTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testConfig.BaseTest;

public class RegisterPageTests extends BaseTest{
	
	public RegisterPageTests() {
		key="registerPage";
	}
	
	@Test(priority=1,description="Register a new user",
			dataProvider="getRegisterUserData")
	
	public void enterNewUserDetails(HashMap<String,String> input) throws InterruptedException {
		registerPage.redirectToRegisterPage();
		accountPage=registerPage.RegisterUser(input.get("fName"), input.get("lName"), input.get("Email"), input.get("paswd"));
		Thread.sleep(100);
		String successMessage=accountPage.getAccountText();
		Assert.assertEquals(successMessage, "Welcome");
		String actualMessage=accountPage.getAccountCreatedText().trim();		
		String expectedMessage = "One more step!\nWe've sent you a confirmation email to your account.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}
	
	  @DataProvider
	    public Object[][] getRegisterUserData() throws IOException
	    {
	        List<HashMap<String, String>> data = getjsonData(System.getProperty("user.dir") + "/src/test/java/testData/register_new_user.json");
	        return new Object[][]
	                {
	                        {data.get(0)}
	                };
	    }

}
