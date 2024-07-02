package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_24_New_Driver {
    WebDriver userDriver;
    WebDriver adminDriver;

    @BeforeClass
    public void beforeClass() {

        userDriver = new FirefoxDriver();
        adminDriver = new ChromeDriver();

        userDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        adminDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        userDriver.manage().window().maximize();
        adminDriver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {

        userDriver.get("");
        userDriver.findElement(By.cssSelector("")).click();

        adminDriver.get("");

        adminDriver.findElement(By.cssSelector("")).getText();




    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {
     }

    @AfterClass
    public void afterClass() {
        userDriver.quit();
        adminDriver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
