package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private static final String DRIVER_PATH = "/opt/homebrew/bin/chromedriver";
    private static final String LOGIN_HTML = "file:///Users/kavish/University/T1%202026/SIT333%20Software%20Quality%20and%20Testing/Tasks/tithub%20shit/SIT333/task7_1P_225138433/pages/login.html";

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String submitLogin(String username, String password, String dob) {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        try {
            driver.navigate().to(LOGIN_HTML);
            sleep(2);

            WebElement ele = driver.findElement(By.id("username"));
            ele.clear();
            ele.sendKeys(username != null ? username : "");

            ele = driver.findElement(By.id("passwd"));
            ele.clear();
            ele.sendKeys(password != null ? password : "");

            // macOS fix: set date field via JavaScript
            WebElement dobField = driver.findElement(By.id("dob"));
            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].value = arguments[1]", dobField, dob != null ? dob : "");

            ele = driver.findElement(By.cssSelector("[type=submit]"));
            ele.submit();

            // Wait for page title to change from login.html
            for (int i = 0; i < 10; i++) {
                sleep(1);
                String title = driver.getTitle();
                if (title.equals("success") || title.equals("fail")) {
                    return title;
                }
            }

            return driver.getTitle();
        } finally {
            driver.close();
        }
    }

    // Test 1: All correct credentials → success
    @Test
    public void testLoginSuccess() {
        String title = submitLogin("kavish", "kavish193", "2005-03-19");
        System.out.println("Test 1 Title: " + title);
        Assert.assertEquals("success", title);
    }

    // Test 2: Wrong username → fail
    @Test
    public void testLoginWrongUsername() {
        String title = submitLogin("wronguser", "kavish193", "2005-03-19");
        System.out.println("Test 2 Title: " + title);
        Assert.assertEquals("fail", title);
    }

    // Test 3: Wrong password → fail
    @Test
    public void testLoginWrongPassword() {
        String title = submitLogin("kavish", "wrongpass", "2005-03-19");
        System.out.println("Test 3 Title: " + title);
        Assert.assertEquals("fail", title);
    }

    // Test 4: Wrong DoB → fail
    @Test
    public void testLoginWrongDob() {
        String title = submitLogin("kavish", "kavish193", "2000-12-31");
        System.out.println("Test 4 Title: " + title);
        Assert.assertEquals("fail", title);
    }

    // Test 5: All fields wrong → fail
    @Test
    public void testLoginAllWrong() {
        String title = submitLogin("nobody", "badpass", "1999-09-09");
        System.out.println("Test 5 Title: " + title);
        Assert.assertEquals("fail", title);
    }

    // Test 6: Empty username → fail
    @Test
    public void testLoginEmptyUsername() {
        String title = submitLogin("", "kavish193", "2005-03-19");
        System.out.println("Test 6 Title: " + title);
        Assert.assertEquals("fail", title);
    }

    // Test 7: Empty password → fail
    @Test
    public void testLoginEmptyPassword() {
        String title = submitLogin("kavish", "", "2005-03-19");
        System.out.println("Test 7 Title: " + title);
        Assert.assertEquals("fail", title);
    }

    // Test 8: Empty DoB → fail
    @Test
    public void testLoginEmptyDob() {
        String title = submitLogin("kavish", "kavish193", "");
        System.out.println("Test 8 Title: " + title);
        Assert.assertEquals("fail", title);
    }

    // Test 9: Invalid DoB format → fail
    @Test
    public void testLoginInvalidDobFormat() {
        String title = submitLogin("kavish", "kavish193", "19/03/2005");
        System.out.println("Test 9 Title: " + title);
        Assert.assertEquals("fail", title);
    }

    // Test 10: SQL injection → fail
    @Test
    public void testLoginSqlInjection() {
        String title = submitLogin("kavish' OR '1'='1", "anything", "2005-03-19");
        System.out.println("Test 10 Title: " + title);
        Assert.assertEquals("fail", title);
    }
}