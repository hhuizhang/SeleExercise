package chapter4.DesignPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Chapter2 extends LoadableComponent<Chapter2>{

	WebDriver driver;
	
	@FindBy(how = How.NAME, using = "verifybutton")
	@CacheLookup
	WebElement verifyButton;
	
	
/*	public Chapter2(WebDriver driver){
		this.driver = driver;
		//verifyButton = driver.findElement(By.id("verifybutton"));
		
		if(!"Chapter 2".equalsIgnoreCase(this.driver.getTitle())){
			driver.get("http://book.theautomatedtester.co.uk/chapter2");
		}
	}*/
	
	public Chapter2(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void load(){
		driver.get("http://book.theautomatedtester.co.uk/chapter2");
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		String url = driver.getCurrentUrl();
		if(url != "http://book.theautomatedtester.co.uk/chapter2"){
			try {
				throw new Exception("The wrong page has loaded");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isButtonPresent(String button){
		return driver.findElements(By.xpath("//input[@id='"+ button +"']")).size() > 0;	
	}
	
}
