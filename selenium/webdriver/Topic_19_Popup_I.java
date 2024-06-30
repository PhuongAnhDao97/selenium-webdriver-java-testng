package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_19_Popup_I {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fixed_Popup_In_DOM() {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.cssSelector("button.login_")).click();

        By loginPopup = By.cssSelector("div[id='modal-login-v1'][style]>div");

        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("linasmithhhh2414");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#password-input")).sendKeys("linasmithhhh2414");

        driver.findElement(By.cssSelector("button[data-text='Đăng nhập']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.error-login-panel")).isDisplayed());

        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.close")).click();

        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());


    }

    @Test
    public void TC_02_Fixed_Popup_Not_In_DOM() {
        driver.get("https://tiki.vn/");

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());

        driver.findElement(By.cssSelector("p.login-with-email")).click();

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']/parent::div/following-sibling::span[1]")).getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']/parent::div/following-sibling::span")).getText(),"Mật khẩu không được để trống");

        driver.findElement(By.cssSelector("img.close-img")).click();



        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(), 0);



    }

    @Test
    public void TC_03_Fixed_Popup_Not_In_DOM() {

        driver.get("https://www.facebook.com/");
        
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).isDisplayed());

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div/img")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).size(),0);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
