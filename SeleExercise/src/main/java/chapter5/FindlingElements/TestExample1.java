package chapter5.FindlingElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByLinkText;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestExample1 {

	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\hzhang8\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver(); 
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testExamples(){
/*	    System.out.println(driver.getPageSource()); 
		System.out.println(driver.getCurrentUrl()); 
		System.out.println(driver.getTitle()); 
		System.out.println(driver.getWindowHandle());*/ 
		
/*		WebElement element1 = ((FindsById)driver).findElementById("verifybutton");
		WebElement element2 = ((FindsById)driver).findElementById("verifybutton11");*/
		
		List<WebElement> element3 = ((FindsById)driver).findElementsById("verifybutton");
		Assert.assertEquals(1,element3.size());
		
		List<WebElement> element4 = ((FindsById)driver).findElementsById("verifybutton11");
		Assert.assertEquals(0,element4.size());
		
		WebElement element5 = ((FindsByName)driver).findElementByName("selected(1234)");
		List<WebElement> element6 = ((FindsByName)driver).findElementsByName("selected(1234)");
		Assert.assertEquals(1, element6.size());
		
		WebElement element7 = ((FindsByClassName)driver).findElementByClassName("storetext");
		List<WebElement> element8 = ((FindsByClassName)driver).findElementsByClassName("storetext");
		Assert.assertEquals(1, element8.size());
		
		WebElement element9 = ((FindsByXPath)driver).findElementByXPath("/html/body/div[2]/p[3]/select");
		List<WebElement> element10 = ((FindsByXPath)driver).findElementsByXPath("/html/body/div[2]/p[3]/select/option");
		Assert.assertEquals(4, element10.size());
		
		driver.get("http://book.theautomatedtester.co.uk/");
		
		WebElement element11 = ((FindsByLinkText)driver).findElementByLinkText("Chapter1");
		List<WebElement> element12 = ((FindsByLinkText)driver).findElementsByLinkText("Chapter1");
		Assert.assertEquals(1, element12.size());
		
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
		
		WebElement element13 = ((FindsByCssSelector)driver).findElementByCssSelector("html body div.mainbody p input#radiobutton");
		List<WebElement> element14 = ((FindsByCssSelector)driver).findElementsByCssSelector("html body div.mainbody p input#radiobutton");
		Assert.assertEquals(1, element14.size());
		
		driver.get("http://book.theautomatedtester.co.uk/");
		driver.findElement(By.linkText("Chapter1"));
		List<WebElement> element15 = driver.findElements(By.linkText("Chapter1"));
		Assert.assertEquals(1, element15.size());
		
		//implicit wait
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='ajaxdiv']"));
		
		//explicit wait
		WebElement element16 = (new WebDriverWait(driver,10)).until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.xpath("//div[@id='ajaxdiv']"));
			}
		});

	}
}
