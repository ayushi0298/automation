package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessChrome {
	
	WebDriver driver;
	@Test
	public void HC() {
		
		
		
		String path=System.getProperty("user.dir");
		String genericPath=path+"\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", genericPath);
		
		ChromeOptions co= new ChromeOptions();
		co.setHeadless(true);
		driver= new ChromeDriver(co);
		
		driver.get("https://newtours.demoaut.com");
		String title= driver.getTitle();
		System.out.println(title);
	}

}
