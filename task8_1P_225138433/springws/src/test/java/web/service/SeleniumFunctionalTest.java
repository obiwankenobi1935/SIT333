package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFunctionalTest {

    private WebDriver driver;
    private static final String BASE_URL = "http://127.0.0.1:8080";

    @Before
    public void setUp() {
        // Set path to your chromedriver if needed:
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ── Login Tests ──────────────────────────────────────────

    @Test
    public void testLoginPage_Loads() {
        driver.get(BASE_URL + "/login");
        assert driver.getTitle() != null;
    }

    @Test
    public void testLogin_CorrectCredentials_RedirectsToQ1() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("passwd")).sendKeys("password");
        driver.findElement(By.name("dob")).sendKeys("01/01/2000");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert driver.getCurrentUrl().contains("/q1");
    }

    @Test
    public void testLogin_WrongCredentials_StaysOnLogin() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("passwd")).sendKeys("wrong");
        driver.findElement(By.name("dob")).sendKeys("01/01/1111");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert driver.getCurrentUrl().contains("/login");
    }

    @Test
    public void testLogin_ErrorMessage_Shown_OnFailure() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.name("username")).sendKeys("bad");
        driver.findElement(By.name("passwd")).sendKeys("bad");
        driver.findElement(By.name("dob")).sendKeys("01/01/1111");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String pageText = driver.getPageSource();
        assert pageText.contains("Incorrect credentials.");
    }

    // ── Q1 Addition Tests ────────────────────────────────────

    @Test
    public void testQ1_CorrectAnswer_RedirectsToQ2() {
        driver.get(BASE_URL + "/q1");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("7");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert driver.getCurrentUrl().contains("/q2");
    }

    @Test
    public void testQ1_WrongAnswer_StaysOnQ1() {
        driver.get(BASE_URL + "/q1");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert driver.getCurrentUrl().contains("/q1");
    }

    @Test
    public void testQ1_WrongAnswer_ErrorMessage_Shown() {
        driver.get(BASE_URL + "/q1");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String pageText = driver.getPageSource();
        assert pageText.contains("Wrong answer, try again.");
    }

    @Test
    public void testQ1_EmptyFields_NoErrorPage() {
        driver.get(BASE_URL + "/q1");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        // Should NOT show Whitelabel Error Page
        assert !driver.getPageSource().contains("Whitelabel Error Page");
    }

    // ── Q2 Subtraction Tests ─────────────────────────────────

    @Test
    public void testQ2_CorrectAnswer_RedirectsToQ3() {
        driver.get(BASE_URL + "/q2");
        driver.findElement(By.name("number1")).sendKeys("10");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("6");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert driver.getCurrentUrl().contains("/q3");
    }

    @Test
    public void testQ2_WrongAnswer_StaysOnQ2() {
        driver.get(BASE_URL + "/q2");
        driver.findElement(By.name("number1")).sendKeys("10");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert driver.getCurrentUrl().contains("/q2");
    }

    @Test
    public void testQ2_EmptyFields_NoErrorPage() {
        driver.get(BASE_URL + "/q2");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert !driver.getPageSource().contains("Whitelabel Error Page");
    }

    // ── Q3 Multiplication Tests ──────────────────────────────

    @Test
    public void testQ3_CorrectAnswer_RedirectsToWelcome() {
        driver.get(BASE_URL + "/q3");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("12");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert driver.getCurrentUrl().contains("/welcome");
    }

    @Test
    public void testQ3_WrongAnswer_StaysOnQ3() {
        driver.get(BASE_URL + "/q3");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert driver.getCurrentUrl().contains("/q3");
    }

    @Test
    public void testQ3_EmptyFields_NoErrorPage() {
        driver.get(BASE_URL + "/q3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assert !driver.getPageSource().contains("Whitelabel Error Page");
    }
}