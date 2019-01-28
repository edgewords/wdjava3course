package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import poms.homePage;

@RunWith (Parameterized.class)
public class QuickTest {

	String username;
	String password;
		
	WebDriver driver;
	
	public QuickTest (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Parameters (name="Test {index}: Username= {0}, Password= {1}")
	public static Collection<String[]> testData(){
		return Arrays.asList(new String[][] {
			{"edgewords","edgewords123"},
			{"webdriver","edgewords123"}
		});
	}
	
	@Test
	public void test() throws InterruptedException {		
		homePage HomePage = new homePage(driver);
		HomePage.clickLogin();
		
		
		//driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.linkText("Submit")).click();
		Thread.sleep(2000);
		assertTrue (driver.findElement(By.linkText("Add Record")).isDisplayed());
	}
	
	@Before
	public void setUp() throws Exception {
		
		String browser = System.getProperty("browser");
	    
	    if (browser != null && browser.equalsIgnoreCase("firefox")) {
	    	driver = new FirefoxDriver(); 	
	    }
	    else {
	    	driver = new ChromeDriver(); //instantiate a browser
	    }
	    System.out.println("Browser passed through is : " + browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.edgewordstraining.co.uk/webdriver2");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
