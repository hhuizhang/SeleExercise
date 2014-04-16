package MySeleProj.SeleExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ExampleForFireFox {
	
	public static void main(String[] agrs){
		
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\hzhang8\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
		//driver.navigaet().to("http://www.google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		//WebElement element = driver.findElement(By.id("gbqfq"));
		
		element.sendKeys("Cheese!");
		
		element.submit();
		
		System.out.println("Page title is: " + driver.getTitle());
		
		(new WebDriverWait(driver,10)).until(new ExpectedCondition <Boolean>(){
		    public Boolean apply(WebDriver d){
			    return d.getTitle().toLowerCase().endsWith("cheese!");
		    }
	    });
		
		System.out.println("Page title21 is: " + driver.getTitle());
		
		driver.quit();
	}

}
