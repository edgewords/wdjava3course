package utilities;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	protected WebDriver driver;
	
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
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS); //for JavaScript execution timeout
		driver.get("https://www.edgewordstraining.co.uk/webdriver2");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
