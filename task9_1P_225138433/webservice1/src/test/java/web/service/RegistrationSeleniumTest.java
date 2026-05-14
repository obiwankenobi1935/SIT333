package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationSeleniumTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        return new ChromeDriver();
    }

    private void navigateToRegPage(WebDriver driver) {
        driver.navigate().to(
            "file:///Users/kavish/University/T1%202026/SIT333%20Software%20Quality%20and%20Testing/Tasks/tithub%20shit/SIT333/task7_2D_225138433/pages/register.html");
        sleep(2);
    }

    private void fillForm(WebDriver driver, String fname, String lname,
                          String username, String password, String email,
                          String phone, String gender, String dob) {
        WebElement ele;

        ele = driver.findElement(By.id("fname"));
        ele.clear();
        ele.sendKeys(fname);

        ele = driver.findElement(By.id("lname"));
        ele.clear();
        ele.sendKeys(lname);

        ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys(username);

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys(password);

        ele = driver.findElement(By.id("email"));
        ele.clear();
        ele.sendKeys(email);

        ele = driver.findElement(By.id("phone"));
        ele.clear();
        ele.sendKeys(phone);

        Select genderSelect = new Select(driver.findElement(By.id("gender")));
        genderSelect.selectByValue(gender);

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys(dob);
    }

    // Successful registration with all valid fields

    @Test
    public void testRegisterSuccess() {
        WebDriver driver = getDriver();
        navigateToRegPage(driver);

        fillForm(driver, "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", "01/01/2000");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(3);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("success", title);

        driver.close();
    }

    // Registration fails with empty first name

    @Test
    public void testRegisterEmptyFirstName() {
        WebDriver driver = getDriver();
        navigateToRegPage(driver);

        fillForm(driver, "", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", "01/01/2000");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(3);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);

        driver.close();
    }

    // Registration fails with empty last name

    @Test
    public void testRegisterEmptyLastName() {
        WebDriver driver = getDriver();
        navigateToRegPage(driver);

        fillForm(driver, "Kavish", "", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", "01/01/2000");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(3);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);

        driver.close();
    }

    // Registration fails with invalid email (no @)

    @Test
    public void testRegisterInvalidEmail() {
        WebDriver driver = getDriver();
        navigateToRegPage(driver);

        fillForm(driver, "Kavish", "Choudhary", "kavishc",
                "pass123", "kavishnoatsign.com", "0412345678",
                "male", "01/01/2000");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(3);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);

        driver.close();
    }

    // Registration fails with empty password

    @Test
    public void testRegisterEmptyPassword() {
        WebDriver driver = getDriver();
        navigateToRegPage(driver);

        fillForm(driver, "Kavish", "Choudhary", "kavishc",
                "", "kavish@email.com", "0412345678",
                "male", "01/01/2000");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(3);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);

        driver.close();
    }

    // Registration fails with empty phone

    @Test
    public void testRegisterEmptyPhone() {
        WebDriver driver = getDriver();
        navigateToRegPage(driver);

        fillForm(driver, "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "",
                "male", "01/01/2000");

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(3);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);

        driver.close();
    }
}