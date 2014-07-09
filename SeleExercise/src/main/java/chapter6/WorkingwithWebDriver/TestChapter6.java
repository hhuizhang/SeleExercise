package chapter6.WorkingwithWebDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TestChapter6 {

	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\hzhang8\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter4");
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testExample(){
		WebElement element = driver.findElement(By.id("nextBid"));
		element.sendKeys("100");
		System.out.printf(element.getLocation().toString());
		System.out.printf(element.getSize().toString());
		System.out.printf(element.getTagName());
		System.out.print(element.isDisplayed());
		
	}
}
