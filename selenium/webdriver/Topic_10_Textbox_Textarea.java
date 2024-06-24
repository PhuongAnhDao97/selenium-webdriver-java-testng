package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_10_Textbox_Textarea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Login_01_Empty_Email_And_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        SleepInSeconds(3);
        driver.findElement(By.cssSelector("button#send2")).click();
        SleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");
    }

    @Test
    public void Login_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        SleepInSeconds(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("123@123");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");


    }

    @Test
    public void Login_03_Invalid_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        SleepInSeconds(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("linasmith@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1234");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void Login_04_Incorrect_Email_Or_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        SleepInSeconds(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("linasmith@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456789");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(),"Invalid login or password.");

        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();

        driver.findElement(By.cssSelector("input#email")).sendKeys("dutomationfc@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456789");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(),"Invalid login or password.");
    }


    @Test
    public void Login_05_Success() {

        // 1 dk trc / lam auto
        // man-auto , rui ro khi db reset, or qua mtrg moi thi dk lai > bi dong > ko nen lam
        // 2 dung function register nhung email fix cung (1 lan)
        // lan sau se bao exist > ko nen lam
        // 3 se dung tinh nawng register trc va email ko co dinh
        // chay luon dung cho all email


        // buoc 1
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        SleepInSeconds(3);

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        SleepInSeconds(3);

        String  firstName = "Lina",
                lastName = "Smith",
                emailAddress = getEmailAdress(),
                password = "123456789";
        String fullName = firstName + " " + lastName;

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();
        SleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + fullName +"!");

        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        // buoc 2

        driver.findElement(By.cssSelector("a.skip-account>span.label")).click();
        SleepInSeconds(2);
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        SleepInSeconds(5);

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        SleepInSeconds(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(password);

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + fullName +"!");

        contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        // b3 verify account

        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        SleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"),emailAddress);


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public  void  SleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAdress(){

        return "linasmith" + new Random().nextInt(99999) + "@gmail.com";

        // c2 Random rand = new Random();
        //        return "linasmith" + rand.nextInt(99999) + "@gmail.com";

        // c3 String emailAddress = "linasmith" + rand.nextInt(99999) + "@gmail.com";
        //    return emailAddress;
    }
}
