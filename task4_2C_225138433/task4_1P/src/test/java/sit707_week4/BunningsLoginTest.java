package sit707_week4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BunningsLoginTest {

    private static final String DRIVER_PATH = "/opt/homebrew/bin/chromedriver";
    private static final String LOGIN_URL = "https://www.bunnings.com.au/login";

    private static final String VALID_EMAIL = "kavishchoudhary1935@gmail.com";
    private static final String VALID_PASSWORD = "2qi#h#C,B@k=ns";

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String submitLogin(String email, String password) {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        try {
            driver.navigate().to(LOGIN_URL);
            sleep(3);

            WebElement emailField = driver.findElement(By.id("username"));
            emailField.clear();
            emailField.sendKeys(email != null ? email : "");

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.clear();
            passwordField.sendKeys(password != null ? password : "");

            WebElement submitBtn = driver.findElement(By.id("login-submit"));
            submitBtn.click();
            sleep(4);

            return driver.getCurrentUrl();
        } finally {
            driver.close();
        }
    }

    @Test
    public void testLoginSuccess() {
        String url = submitLogin(VALID_EMAIL, VALID_PASSWORD);
        System.out.println("Test 1 URL: " + url);
        Assert.assertFalse("Expected redirect away from login page",
            url.contains("/login"));
    }

    @Test
    public void testLoginWrongPassword() {
        String url = submitLogin(VALID_EMAIL, "wrongpassword123");
        System.out.println("Test 2 URL: " + url);
        Assert.assertTrue("Expected to stay on login page",
            url.contains("/login"));
    }

    @Test
    public void testLoginWrongEmail() {
        String url = submitLogin("notanemail@fake.com", VALID_PASSWORD);
        System.out.println("Test 3 URL: " + url);
        Assert.assertTrue("Expected to stay on login page",
            url.contains("/login"));
    }

    @Test
    public void testLoginWrongEmailWrongPassword() {
        String url = submitLogin("notanemail@fake.com", "wrongpassword123");
        System.out.println("Test 4 URL: " + url);
        Assert.assertTrue("Expected to stay on login page",
            url.contains("/login"));
    }

    @Test
    public void testLoginEmptyEmailEmptyPassword() {
        String url = submitLogin("", "");
        System.out.println("Test 5 URL: " + url);
        Assert.assertTrue("Expected to stay on login page",
            url.contains("/login"));
    }

    @Test
    public void testLoginEmptyEmailValidPassword() {
        String url = submitLogin("", VALID_PASSWORD);
        System.out.println("Test 6 URL: " + url);
        Assert.assertTrue("Expected to stay on login page",
            url.contains("/login"));
    }

    @Test
    public void testLoginValidEmailEmptyPassword() {
        String url = submitLogin(VALID_EMAIL, "");
        System.out.println("Test 7 URL: " + url);
        Assert.assertTrue("Expected to stay on login page",
            url.contains("/login"));
    }
}