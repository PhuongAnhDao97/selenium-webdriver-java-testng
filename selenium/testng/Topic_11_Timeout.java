package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_11_Timeout {

    WebDriver driver;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test(timeOut = 20000)
    public void Register() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

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
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + fullName +"!");

        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        // buoc 2

        driver.findElement(By.cssSelector("a.skip-account>span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(password);

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, " + fullName +"!");

        contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        // b3 verify account

        driver.findElement(By.xpath("//a[text()='Account Information']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"),emailAddress);

        driver.findElement(By.cssSelector("a.skip-account>span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();

        System.out.println(emailAddress);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    public String getEmailAdress(){

        return "linasmith" + new Random().nextInt(99999) + "@gmail.com";

    }
}
