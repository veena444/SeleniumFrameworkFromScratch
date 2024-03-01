package pages;

import static base.CustomWaits.staticWait;
import static utils.PropertyReaderHelper.getCustomProperty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//url: https://www.manning.com/
public class HomePage {
	
private WebDriver driver;
	
	//locators
	private By homePageText=By.id("manningOnlineLogo");
	private By homePageLogo = By.id("manning-m");
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void loginToHomePage() {
		driver.get(getHomePageText());
	}
	
	public void loadHomePage() {
		System.out.println(getCustomProperty("homePageUrl"));
		driver.get(getCustomProperty("homePageUrl"));
		staticWait(2);
		
	}

	public String getHomePageText() {
		return driver.findElement(homePageText).getText();
		
	}

}
