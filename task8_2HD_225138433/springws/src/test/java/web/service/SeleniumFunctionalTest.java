package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFunctionalTest {

    private WebDriver driver;
    private static final String BASE_URL = "http://127.0.0.1:8080";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Login Tests

    @Test
    public void testLoginPage_Loads() {
        driver.get(BASE_URL + "/login");
        Assert.assertTrue(driver.getPageSource().contains("Login"));
    }

    @Test
    public void testLogin_CorrectCredentials_RedirectsToQ1() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.name("username")).sendKeys("ahsan");
        driver.findElement(By.name("passwd")).sendKeys("ahsan_pass");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void testLogin_WrongCredentials_StaysOnLogin() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("passwd")).sendKeys("wrong");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void testLogin_ErrorMessage_Shown_OnFailure() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.name("username")).sendKeys("bad");
        driver.findElement(By.name("passwd")).sendKeys("bad");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Incorrect credentials."));
    }

    // Q1 Addition Tests

    @Test
    public void testQ1_CorrectAnswer_RedirectsToQ2() {
        driver.get(BASE_URL + "/q1");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("7");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ1_WrongAnswer_StaysOnQ1() {
        driver.get(BASE_URL + "/q1");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void testQ1_WrongAnswer_ErrorMessage_Shown() {
        driver.get(BASE_URL + "/q1");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Wrong answer, try again."));
    }

    @Test
    public void testQ1_EmptyFields_NoErrorPage() {
        driver.get(BASE_URL + "/q1");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertFalse(driver.getPageSource().contains("Whitelabel Error Page"));
    }

    // Q2 Subtraction Tests

    @Test
    public void testQ2_CorrectAnswer_RedirectsToQ3() {
        driver.get(BASE_URL + "/q2");
        driver.findElement(By.name("number1")).sendKeys("10");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("6");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
    }

    @Test
    public void testQ2_WrongAnswer_StaysOnQ2() {
        driver.get(BASE_URL + "/q2");
        driver.findElement(By.name("number1")).sendKeys("10");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ2_EmptyFields_NoErrorPage() {
        driver.get(BASE_URL + "/q2");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertFalse(driver.getPageSource().contains("Whitelabel Error Page"));
    }

    // Q3 Multiplication Tests

    @Test
    public void testQ3_CorrectAnswer_RedirectsToQ4() {
        driver.get(BASE_URL + "/q3");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("12");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q4"));
    }

    @Test
    public void testQ3_WrongAnswer_StaysOnQ3() {
        driver.get(BASE_URL + "/q3");
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
    }

    @Test
    public void testQ3_EmptyFields_NoErrorPage() {
        driver.get(BASE_URL + "/q3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertFalse(driver.getPageSource().contains("Whitelabel Error Page"));
    }

    // Q4 Date After Days Tests

    @Test
    public void testQ4_PageLoads() {
        driver.get(BASE_URL + "/q4");
        Assert.assertTrue(driver.getPageSource().contains("Q4"));
    }

    @Test
    public void testQ4_CorrectAnswer_RedirectsToQ5() {
        driver.get(BASE_URL + "/q4");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('startDate').value = '2024-01-01'");
        driver.findElement(By.name("days")).sendKeys("45");
        driver.findElement(By.name("result")).sendKeys("2024-02-15");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q5"));
    }

    @Test
    public void testQ4_WrongAnswer_StaysOnQ4() {
        driver.get(BASE_URL + "/q4");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('startDate').value = '2024-01-01'");
        driver.findElement(By.name("days")).sendKeys("45");
        driver.findElement(By.name("result")).sendKeys("2024-01-01");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q4"));
    }

    @Test
    public void testQ4_WrongAnswer_ErrorMessage_Shown() {
        driver.get(BASE_URL + "/q4");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('startDate').value = '2024-01-01'");
        driver.findElement(By.name("days")).sendKeys("45");
        driver.findElement(By.name("result")).sendKeys("wrong");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Wrong answer, try again."));
    }

    // Q5 Days Between Dates Tests

    @Test
    public void testQ5_PageLoads() {
        driver.get(BASE_URL + "/q5");
        Assert.assertTrue(driver.getPageSource().contains("Q5"));
    }

    @Test
    public void testQ5_CorrectAnswer_RedirectsToQ6() {
        driver.get(BASE_URL + "/q5");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('date1').value = '2024-01-01'");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('date2').value = '2024-02-01'");
        driver.findElement(By.name("result")).sendKeys("31");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q6"));
    }

    @Test
    public void testQ5_WrongAnswer_StaysOnQ5() {
        driver.get(BASE_URL + "/q5");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('date1').value = '2024-01-01'");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('date2').value = '2024-02-01'");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q5"));
    }

    @Test
    public void testQ5_WrongAnswer_ErrorMessage_Shown() {
        driver.get(BASE_URL + "/q5");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('date1').value = '2024-01-01'");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.getElementById('date2').value = '2024-02-01'");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Wrong answer, try again."));
    }

    // Q6 Science Tests

    @Test
    public void testQ6_PageLoads() {
        driver.get(BASE_URL + "/q6");
        Assert.assertTrue(driver.getPageSource().contains("Q6"));
    }

    @Test
    public void testQ6_CorrectAnswer_RedirectsToWelcome() {
        driver.get(BASE_URL + "/q6");
        driver.findElement(By.name("mass")).sendKeys("4");
        driver.findElement(By.name("acceleration")).sendKeys("5");
        driver.findElement(By.name("result")).sendKeys("20.0");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/welcome"));
    }

    @Test
    public void testQ6_WrongAnswer_StaysOnQ6() {
        driver.get(BASE_URL + "/q6");
        driver.findElement(By.name("mass")).sendKeys("4");
        driver.findElement(By.name("acceleration")).sendKeys("5");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q6"));
    }

    @Test
    public void testQ6_WrongAnswer_ErrorMessage_Shown() {
        driver.get(BASE_URL + "/q6");
        driver.findElement(By.name("mass")).sendKeys("4");
        driver.findElement(By.name("acceleration")).sendKeys("5");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Wrong answer, try again."));
    }

    @Test
    public void testQ6_EmptyFields_NoErrorPage() {
        driver.get(BASE_URL + "/q6");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertFalse(driver.getPageSource().contains("Whitelabel Error Page"));
    }
}