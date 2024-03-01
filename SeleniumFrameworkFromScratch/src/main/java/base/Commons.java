package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Commons {
	
	public WebDriver driver;
	public Properties prop;
	
	//helps to get the configuration details from config.properties file
	
  public void getFileProperty() {
	  
  try {
	
		prop =new Properties();
		FileInputStream fis =new FileInputStream(
				System.getProperty("C:\\Users\\aksha\\eclipse-workspace\\SeleniumFrameworkFromScratch\\src\\main\\resources\\config.properties"));
		prop.load(fis);
  }
  catch(FileNotFoundException e) {
	  e.printStackTrace();
  }
  catch(IOException e) {
	  e.printStackTrace();
 
 }
	
}

}
