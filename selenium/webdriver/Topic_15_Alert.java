package webdriver;

import org.openqa.selenium.Alert;
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

public class Topic_15_Alert {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        sleepInSeconds(3);
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent()); // dam bao alert xuat hien trc khi thao tac

        // Alert alert = driver.switchTo().alert(); // c2
        Assert.assertEquals(alert.getText(),"I am a JS Alert");

        // khi accept, or cancel alert se mat luon
        alert.accept();
        sleepInSeconds(2);

        By resultText = By.cssSelector("p#result");

        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked an alert successfully");



//         thu vien alert k sd cho authen alert, lien quan den bao mat
//        selenium 4 > chrom dev tool, chi dung cho chrom va edge
//         cancel alert: apply cho confirm va prompt
//        void dismiss();
//          dung de accept: apply ca 3
//        void accept();
//          get text trong alert
//        String getText();
//          nhap text
//        void sendKeys(String keysToSend);
    }

    @Test
    public void TC_02_Confirm_Alert() {

        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        sleepInSeconds(2);
        By resultText = By.cssSelector("p#result");
        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked: Cancel");

    }

    @Test
    public void TC_03_Prompt_Alert() {

        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        String text = "Lina Smith";
        alert.sendKeys(text);
        alert.accept();
        sleepInSeconds(2);
        By resultText = By.cssSelector("p#result");
        Assert.assertEquals(driver.findElement(resultText).getText(),"You entered: " + text);
     }

    @Test
    public void TC_04_Authentication_Alert() {
        //cach 3
        // thu vien Alert k cho su dung authentication alert dc
        // Chrome Dev Tool (CDP) - CHrome / Edge

        // cach 1 truyen thawng user/ pass vao url
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

        // cach 2: chi chay dc tren window (Auto IT)
        // co che: cho alert bat len
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
