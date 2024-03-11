package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//url: https://www.manning.com/user/createNewUserAccount?id=registration-form
public class AccountPage {
	
	public WebDriver driver;

    public AccountPage(WebDriver driver)
    {
        this.driver = driver;
    }
    

    //locators
    
   private final By accountText = By.xpath("//h2[normalize-space()='Welcome']"); 
   private final By accountCreatedText=By.xpath("//h3[@class='alert alert-success']");
      
    public String getAccountText()
    {
        return driver.findElement(accountText).getText();
    }

    public String getAccountCreatedText()
    {
       return driver.findElement(accountCreatedText).getText();
       
    }

}

