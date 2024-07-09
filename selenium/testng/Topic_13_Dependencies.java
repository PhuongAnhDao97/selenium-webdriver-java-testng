package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Listeners(listeners.ExtentReport.class)
public class Topic_13_Dependencies {


    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Create_New_User() {
        Assert.assertTrue(true);
    }


    @Test(dependsOnMethods = "TC_01_Create_New_User")
    public void TC_02_View_And_Search_User() {

    }

    @Test(dependsOnMethods = "TC_01_Create_New_User")
    public void TC_03_Update_Existing_User() {
        Assert.assertTrue(false);

    }

    @Test(dependsOnMethods = "TC_03_Update_Existing_User")
    public void TC_04_Move_Existing_User_To_Other_Role() {

    }

    @Test(dependsOnMethods = "TC_04_Move_Existing_User_To_Other_Role")
    public void TC_05_Delete_User() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
