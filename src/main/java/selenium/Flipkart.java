package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Flipkart {

	WebDriver driver;
	String username;
	String password;
	String path;

	@Test(priority = 1)
	public void browser() {
		path = System.getProperty("user.dir");
		String genericPath = path + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", genericPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test(priority = 2)
	public void readCredentials() throws Exception {
		FileInputStream fis = new FileInputStream(new File(
				"C:\\Users\\Ayushi\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\Testing\\test\\auto.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);
		username = row.getCell(0).getStringCellValue();
		System.out.println(username);
		XSSFRow row1 = sheet.getRow(1);
		password = row1.getCell(0).getStringCellValue();
		System.out.println(password);
		workbook.close();
	}

	@Test(priority = 3)
	public void cart() throws Exception {
		// driver.get("https://www.flipkart.com");
		driver.get(Config.getData("Environment"));
		WebElement element = driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
		Actions action = new Actions(driver);
		// Action build =action.moveToElement(element).sendKeys(username).build();
		driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys(username);
		driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).clear();
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
		Thread.sleep(10000);
		WebElement elementClick = driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]"));
		Action build1 = action.click(elementClick).build();
		// build.perform();
		build1.perform();
		// driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
		// driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 4)
	public void sikuliMethod() throws Exception {
		Screen screen = new Screen();
		Pattern searchBox = new Pattern(
				"C:\\Users\\Ayushi\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\Testing\\test\\Capture.JPG");
		screen.type(searchBox, "Redmi note 7");
		Pattern pt = new Pattern(
				"C:\\Users\\Ayushi\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\Testing\\test\\Cap2.JPJ.JPG");
		screen.click(pt);
		Pattern p = new Pattern(
				"C:\\Users\\Ayushi\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\Testing\\test\\new.JPG");
		screen.click(p);
		Thread.sleep(5000);
	}

	@Test(priority = 5)
	public void addToCart() throws InterruptedException {

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();

	}

	@AfterMethod
	public void screenShot() throws Exception {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path + "s.png"));
		System.out.println(path+"s.png");

	}
	

}