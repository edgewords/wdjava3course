package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
	
	protected WebDriver driver;
    protected WebDriverWait wait;
    // define our web page elements
    private By Basic_HTML = By.cssSelector("[href='basicHtml\\.html'] span");
    private By LoginLink = By.partialLinkText("Login");
    // our constructor to set up the driver instance
    public homePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    // our Action methods
    public homePage clickLogin(){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.LoginLink)).click();  
        return this; 
    }
    
    public homePage clickBasic_HTML(){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.Basic_HTML)).click();  
        return this; 
    }

}
