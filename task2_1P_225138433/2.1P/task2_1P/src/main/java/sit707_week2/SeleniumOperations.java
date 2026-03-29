package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Kavish");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement element1 = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + element1);
		element1.sendKeys("Choudhary");
		
		WebElement element2 = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + element2);
		element2.sendKeys("0416235833");
		
		WebElement element3 = driver.findElement(By.id("password"));
		System.out.println("Found element: " + element3);
		element3.sendKeys("Kavish193");
		
		WebElement element4 = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + element4);
		element4.sendKeys("Kavish193");
		
		WebElement personalbutton = driver.findElement(By.cssSelector("button[value='personal']"));
		personalbutton.click();
		
		WebElement createaccountbutton = driver.findElement(By.cssSelector("button[data-testid='account-action-btn']"));
		createaccountbutton.click();
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshot.png");

		try {
		    FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}

		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void bigw_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("login__firstName"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("kavish");
		
		WebElement element2 = driver.findElement(By.id("login__lastName"));
		System.out.println("Found element: " + element);
		// Send first name
		element2.sendKeys("choudhary");
		
		WebElement element3 = driver.findElement(By.id("login__email"));
		System.out.println("Found element: " + element);
		// Send first name
		element3.sendKeys("kavishchoudhary1935@gmail.com");
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshot2.png");

		try {
		    FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}

		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
