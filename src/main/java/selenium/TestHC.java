package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestHC {
	WebDriver driver;
	@Test(priority=1)
	public void HC() {
		
	driver.get("https://newtours.demoaut.com");
	String title= driver.getTitle();
	System.out.println(title);
	
	driver.get("https://google.com");
	String titl= driver.getTitle();
	System.out.println(titl);
}
}
