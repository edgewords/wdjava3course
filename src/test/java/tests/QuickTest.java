package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import poms.homePage;
import utilities.BaseTest;

@RunWith (Parameterized.class)
public class QuickTest extends BaseTest {

	String username;
	String password;
			
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
}
