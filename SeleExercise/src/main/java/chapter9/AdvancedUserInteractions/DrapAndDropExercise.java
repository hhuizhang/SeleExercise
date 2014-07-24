package chapter9.AdvancedUserInteractions;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DrapAndDropExercise {

	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\hzhang8\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://www.theautomatedtester.co.uk/demo2.html");		
	}
	
	/*@After
	public void tearDown(){
		driver.quit();
	}*/
	
	@Test
	public void testExamples(){
		WebElement someElement = driver.findElement(By.className("draggable"));
		//WebElement otherElement = driver.findElement(By.name("droppable"));
		
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(someElement).moveByOffset(10,50).release().build();
		
		dragAndDrop.perform();
	}
}
