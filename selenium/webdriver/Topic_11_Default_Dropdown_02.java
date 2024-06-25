package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_11_Default_Dropdown_02 {
    WebDriver driver;
    String day = "1", month = "May", year = "1999";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Url() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();
        SleepInSeconds(2);

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Fina");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Lunney");

        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText(day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getOptions().size(), 32);
        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getOptions().size(), 13);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getOptions().size(), 112);

        driver.findElement(By.cssSelector("input#Email")).sendKeys(getEmailAdress());
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#register-button")).click();
        SleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

        driver.findElement(By.cssSelector("a.ico-account")).click();
        SleepInSeconds(2);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);


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

    public String getEmailAdress() {

        return "linakane" + new Random().nextInt(99999) + "@gmail.com";
    }
}
