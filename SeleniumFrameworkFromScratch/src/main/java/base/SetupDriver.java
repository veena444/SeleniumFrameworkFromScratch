package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupDriver extends Commons{
	
	public WebDriver driver;
	public String browserType;
	
	// helps to trigger browser depending upon user selection
	public void setUpDriver()
	{
		if(browserType.equalsIgnoreCase("chrome")){
		WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();
	}
	else if (browserType.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
	}
	else if(browserType.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	else {
		System.out.println("Driver not supported!");
	}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	// helps to close the browser
	
	public void quitDriver() {
		driver.quit();
	}
	

}
