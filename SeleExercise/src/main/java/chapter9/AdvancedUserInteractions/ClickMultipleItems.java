package chapter9.AdvancedUserInteractions;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
public class ClickMultipleItems {

	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\hzhang8\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://book.theautomatedtester.co.uk/multi-select.html");
	}
	
	@After
/*	public void tearDown(){
		driver.quit();
	}*/
	
	@Test
	public void clickMultipleItems(){
		
		WebElement select = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
		List<WebElement> options = select.findElements(By.tagName("option"));
		
		Actions builder = new Actions(driver);
		Action multipleSelect = builder.keyDown(Keys.CONTROL).click(options.get(0)).click(options.get(1)).keyUp(Keys.CONTROL).build();
		multipleSelect.perform();
	}
	
}
