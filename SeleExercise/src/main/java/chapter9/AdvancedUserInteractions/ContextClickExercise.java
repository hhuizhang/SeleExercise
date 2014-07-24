package chapter9.AdvancedUserInteractions;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ContextClickExercise {

	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\hzhang8\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://www.theautomatedtester.co.uk/demo1.html");		
	}
	
	/*@After
	public void tearDown(){
		driver.quit();
	}*/
	
	@Test
	public void drawImageOnCanvas(){
		WebElement element = driver.findElement(By.id("tutorial"));
		
		Actions builder = new Actions(driver);
		
		//Action drawImage = builder.
		Action contextClick = builder.contextClick(element).build();
		
		contextClick.perform();
	}
}
