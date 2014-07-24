package chapter6.WorkingwithWebDriver;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class TestChapter6 {

	WebDriver driver;
	
	@Before
	public void setUp(){
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\hzhang8\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		/*driver = new FirefoxDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter4");
		FirefoxBinary binary = new FirefoxBinary();
		binary.setEnvironmentProperty("webdriver.firefox.bin", "C:\\Users\\hzhang8\\AppData\\Local\\Mozilla Firefox\\firefox.exe");*/
	/*	FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.startup.homepage","http://book.theautomatedtester.co.uk/chapter4");
		driver = new FirefoxDriver(profile);*/
		
/*      System.setProperty("webdriver.chrome.driver", "C:\\01WorkDir\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\hzhang8\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		driver = new ChromeDriver(options);*/
		
		//driver = new RemoteWebDriver("http://book.theautomatedtester.co.uk/chapter4",DesiredCapabilities.chrome());		
		
		System.setProperty("webdriver.ie.driver", "C:\\01WorkDir\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.dirver.logfile","C:\\01WorkDir\\IEdriverlog.txt");
		driver = new InternetExplorerDriver();		
		driver.get("http://book.theautomatedtester.co.uk/chapter4");
		
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testExample(){
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
