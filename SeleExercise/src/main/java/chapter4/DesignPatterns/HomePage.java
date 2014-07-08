package chapter4.DesignPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public Chapter2 clickChapter2(){
		clickChapter("2");
		return new Chapter2(driver);
	}
	
	private void clickChapter(String number){
		driver.findElement(By.linkText("Chapter" + number)).click();
	}
}
