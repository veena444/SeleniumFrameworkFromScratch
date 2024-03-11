package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
  
  public List<HashMap<String,String>> getjsonData(String jsonFilePath) throws IOException
  {
      //TODO: Convert json file content to JSON string
      String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

      ObjectMapper mapper = new ObjectMapper();
      List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {

      });
      return data;
  }

}
