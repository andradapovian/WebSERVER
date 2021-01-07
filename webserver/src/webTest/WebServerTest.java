package webTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebServerTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:/Users/andra/Downloads/geckodriver-v0.28.0-win64/geckodriver.exe"); 
		WebDriver driver = new FirefoxDriver();
//		driver.navigate().to("http://seleniumsimplified.com");
//		Assert.assertTrue("title should start differently", driver.getTitle().startsWith("Selenium Simplified"));
//		driver.close();
		driver.get("http://localhost:8080/");
		System.out.println("Page title is: " + driver.getTitle());
		WebElement firstLink = driver.findElement(By.linkText("do external links work?"));
		firstLink.click();
		System.out.println("Page title is: " + driver.getTitle());
//		WebElement element = driver.findElement(By.name("q"));
//
//        // Enter something to search for
//        element.sendKeys("Cheese!");
//
//        // Now submit the form. WebDriver will find the form for us from the element
//        element.submit();
//
//        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
//        
//        // Google's search is rendered dynamically with JavaScript.
//        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("cheese!");
//            }
//        });
//
//        // Should see: "cheese! - Google Search"
//        System.out.println("Page title is: " + driver.getTitle());
//        
        //Close the browser
//        driver.quit();
		
	}
}
