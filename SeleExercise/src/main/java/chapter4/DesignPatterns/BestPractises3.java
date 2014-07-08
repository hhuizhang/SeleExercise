package chapter4.DesignPatterns;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BestPractises3 {

	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\hzhang8\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void ShouldLoadTheHomePageAndThenCheckButtonOnChapter2(){
		driver.get("http://book.theautomatedtester.co.uk");
		HomePage homepage = new HomePage(driver);
		Chapter2 chapter2 = homepage.clickChapter2();
		assertTrue(chapter2.isButtonPresent("but1"));
	}
}
