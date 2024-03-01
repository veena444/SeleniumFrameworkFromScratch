package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderHelper {
	
	private static Properties properties = new Properties();
	private static String propFilePath = System.getProperty("user.dir")+"/src/main/resources/config.properties";
	
	public static String getCustomProperty(String propName)  {
		try {
			properties.load(new FileInputStream(propFilePath));
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return  properties.getProperty(propName);
	}

}
