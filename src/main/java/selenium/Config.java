package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Config {
	
	@Test
	public static String getData(String string) throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\Ayushi\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\Testing\\config.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String st= prop.getProperty(string);
		return st;
	}
	

}
