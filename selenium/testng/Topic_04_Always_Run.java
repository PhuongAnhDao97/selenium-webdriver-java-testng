package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_Always_Run {

    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Run before class");
        Assert.assertTrue(false);
        // neu bi fail o before class, skip test va after class
    }

    @Test
    public void test_01(){
        System.out.println("Test 01");
    }

    @Test
    public void test_02(){
        System.out.println("Test 02");
    }

    @Test
    public void test_03(){
        System.out.println("Test 03");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
        System.out.println("Run after class");
    }
}
