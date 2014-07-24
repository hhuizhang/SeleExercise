package chapter8.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestChapter8 {

	WebDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("opera");
		capability.setPlatform(Platform.VISTA);

		driver = new RemoteWebDriver(new URL("http://grid.stratus.qa.ebay.com:8080/wd/hub"),capability);
		driver.get("http://book.theautomatedtester.co.uk/chapter4");		
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testExamples(){
		WebElement element1 = driver.findElement(By.id("nextBid"));
		element1.sendKeys("100");
		System.out.println(element1.getLocation().toString());
		System.out.println(element1.getSize().toString());
		System.out.println(element1.getTagName());
		System.out.println(element1.isDisplayed());
		WebElement element2 = driver.findElement(By.id("selectLoad"));
		String value2 = element2.getAttribute("value");
		Assert.assertEquals("Click to load the select below", value2);
	}
}
