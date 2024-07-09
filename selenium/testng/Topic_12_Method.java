package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Topic_12_Method {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {
        System.out.println("Run test 01");

    }


    @Test
    public void TC_02_() {
        System.out.println("Run test 02");


    }

    @Test
    public void TC_03_() {
        System.out.println("Run test 03");


    }

    @Test
    public void TC_04_() {
        System.out.println("Run test 04");


    }

    @Test
    public void TC_05_() {
        System.out.println("Run test 05");


    }

    @Test
    public void TC_06_() {
        System.out.println("Run test 06");


    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
