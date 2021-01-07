package webTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebServerTest2 {
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.gecko.driver","C:/Users/andra/Downloads/geckodriver-v0.28.0-win64/geckodriver.exe"); 
		
	}

	@Test
	public void test1() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/");
		assertEquals("Welcome!", driver.getTitle());
	}
	
	@Test
	public void test2() {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/");
		WebElement firstLink = driver.findElement(By.linkText("do external links work?"));
		firstLink.click();
		System.out.println("Page title is: " + driver.getTitle());
		assertEquals("Google", driver.getTitle());
	}

}
