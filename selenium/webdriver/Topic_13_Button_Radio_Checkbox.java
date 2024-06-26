package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_13_Button_Radio_Checkbox {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Egov_Button() {
        driver.get("https://egov.danang.gov.vn/reg");

        Assert.assertFalse(driver.findElement(By.cssSelector("input.egov-button")).isEnabled());

        driver.findElement(By.cssSelector("input#chinhSach")).click();
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.cssSelector("input.egov-button")).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("input.egov-button")).getCssValue("background-color")).asHex().toLowerCase(),"#ef5a00");





    }

    @Test
    public void TC_02_Fahasa_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSeconds(2);

        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        Assert.assertFalse(loginButton.isEnabled());

        System.out.println(loginButton.getCssValue("background-color"));

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("lina@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toUpperCase(),"#C92127");



    }

    @Test
    public void TC_03_() {
     }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
