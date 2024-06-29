package webdriver;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Topic_15_Alert {
    WebDriver driver;
    WebDriverWait explicitWait;

    String username = "admin";
    String password = "admin";

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
    public void TC_04_Authentication_Alert_ByPass_To_Url() {


        // cach 1 truyen thawng user/ pass vao url
//        String username = "admin";
//        String password = "admin";
        // cach truyen bien vao chuoi
        driver.get("http://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"))
                .isDisplayed());

        // cach 2: chi chay dc tren window (Auto IT)
        // co che: cho alert bat len

        // tu page A thao tac authen sang page B
        driver.get("http://the-internet.herokuapp.com/");

        String authenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        String[] authenArray = authenLink.split("//");
        driver.get(authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1]);
        Assert.assertTrue(driver.findElement(
                        By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"))
                .isDisplayed());


        // java string cung cap ham xu ly chuoi

    }

    @Test
    public void TC_05_Authentication_Selenium_4x() {
        // thu vien Alert k cho su dung authentication alert dc
        // Chrome Dev Tool (CDP) - CHrome / Edge



        // get devtool object
        DevTools devTools = ((HasDevTools)driver).getDevTools();

        //start new session
        devTools.createSession();

        // enable the network domain of devtools
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        // encode username / password
        Map<String, Object> headers = new HashMap<String, Object>();

        String basicAuthen = "Basic" + new String(new Base64().encode(String.format("%s:%s", username , password).getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to header

        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
        driver.get("http://the-internet.herokuapp.com/basic_auth");

        Assert.assertTrue(driver.findElement(
                        By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"))
                .isDisplayed());

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

    public  String getAuthenByUrl (String url, String username, String password){

        String[] authenArray = url.split("//");

        return  authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1];

    }


}
