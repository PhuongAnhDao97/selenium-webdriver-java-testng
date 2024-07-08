package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.function.Function;

public class Topic_35_Fluent_Wait {
    WebDriver driver;
//    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    FluentWait<String> fluentString;



    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();

        driver.manage().window().maximize();

//        // time
//        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        // time - polling (default 0.5s), fluent wait co the sua lai polling time
//        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));
    }

    @Test
    public void TC_01_() {
        // cach khoi tao
        fluentDriver = new FluentWait<WebDriver>(driver);

        // set tong tgian
        fluentDriver.withTimeout(Duration.ofSeconds(10));

        // set polling time
        fluentDriver.pollingEvery(Duration.ofMillis(500));

        // ignore exception
        fluentDriver.ignoring(NoSuchElementException.class);
        fluentDriver.ignoring(TimeoutException.class);

        // condition, nhan 1 function viet theo chua cua selenium generic
        fluentDriver.until(new Function<WebDriver, String>() {
            // nho bam implement method
            @Override
            public String apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector("")).getText();
            }
        });


        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(400))
                .ignoring(NoSuchElementException.class, TimeoutException.class)

                .until(new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return webDriver.findElement(By.cssSelector("")).isDisplayed();
                    }
                });


    }

    @Test
    public void TC_02_Verify_By_Boolean() {

        fluentDriver = new FluentWait<WebDriver>(driver);
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // cho cho helloworld text hien thi trong vong 10s

        // setting
        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        // condition

        fluentDriver.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed();
            }
        });


    }

    @Test
    public void TC_03_Verify_By_String() {

        // cach 1 viet tuong minh
//        driver.get("https://automationfc.github.io/dynamic-loading/");
//        fluentDriver = new FluentWait<WebDriver>(driver);
//
//        driver.findElement(By.cssSelector("div#start>button")).click();
//
//        // setting
//        fluentDriver.withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(100))
//                .ignoring(NoSuchElementException.class);
//
//        // condition
//
//        String helloText = fluentDriver.until(new Function<WebDriver, String>() {
//            @Override
//            public String apply(WebDriver webDriver) {
//                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).getText();
//            }
//        });
//
//        Assert.assertEquals(helloText, "Hello World!");



        // cach 2 su dung ham da wrap
        driver.get("https://automationfc.github.io/dynamic-loading/");
        waitAndFindElement(By.cssSelector("div#start>button")).click();

        String helloText = waitAndFindElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).getText();

        Assert.assertEquals(helloText,"Hello World!");




    }

    @Test
    public void TC_04_Verify_By_String() {

        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countdownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));

        fluentElement = new FluentWait<WebElement>(countdownTime);

        fluentElement.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                System.out.println(webElement.getText());
                return webElement.getText().endsWith("00");
            }
        });

    }


    @Test
    public void TC_05_Verify_By_Alert() {

        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countdownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));

        fluentElement = new FluentWait<WebElement>(countdownTime);

        fluentElement.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoAlertPresentException.class);

        fluentElement.until(new Function<WebElement, Alert>() {
            @Override
            public Alert apply(WebElement webElement) {

                return new WebDriverWait(driver, Duration.ofSeconds(15))
                        .until(ExpectedConditions.alertIsPresent());
            }
        });

    }

    public  WebElement waitAndFindElement(By locator){


        FluentWait<WebDriver> fluentDriver = new FluentWait<WebDriver>(driver); // buoc khai bao

        // buoc setting

        fluentDriver.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        // condition


        return fluentDriver.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(locator);
            }
        });
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
