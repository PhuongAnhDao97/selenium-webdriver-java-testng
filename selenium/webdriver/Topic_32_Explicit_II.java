package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_32_Explicit_II {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Equal_5s() {

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");


        driver.findElement(By.cssSelector("div#start>button")).click();

        // wait cho lading icon bien mat trong 10s
        // explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

        // wait cho hello world text hien thi
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));


        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }


    @Test
    public void TC_02_Less_Than_5s() {

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");


        driver.findElement(By.cssSelector("div#start>button")).click();
        //explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");



    }

    @Test
    public void TC_03_More_Than_5s() {

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationfc.github.io/dynamic-loading/");


        driver.findElement(By.cssSelector("div#start>button")).click();
        // explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}


// co 2 cach wait:
// 1 wait cho 1 cai dc hoan thanh > invisible
// wiat cho 1 cai xuat hien
