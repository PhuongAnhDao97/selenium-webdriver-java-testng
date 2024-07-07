package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

public class Topic_34_Wait_V_Mix {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Only_Implicit_Not_Found_Element() {

        // exception : NoSuchException

    }

    @Test
    public void TC_02_Only_Explicit_Found() {
        //
    }

    @Test
    public void TC_03_Only_Explicit_Not_Found_Element_Param_By() {
        driver.get("https://www.facebook.com/");

        explicitWait =new WebDriverWait(driver, Duration.ofSeconds(5));
        // exception : TimeoutException

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
     }


    @Test
    public void TC_04_Only_Explicit_Not_Found_Element_Param_WebElement() {
        driver.get("https://www.facebook.com/");

        explicitWait =new WebDriverWait(driver, Duration.ofSeconds(5));
        // exception : TimeoutException

        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#automation"))));


        // NoSuchElementException: Unable to locate element: input#automation
        //For documentation on this error, please visit:
        // quang ra loi cua implicit vi chay ham find trc

        // neu chi dung explicit thi ti le fail rat cao, phai dung them implicit
    }

    @Test
    public void TC_05_Mix_Im_Ex() {

        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait =new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("input#email"));

        System.out.println("start time" + getDateTimeNow());

        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
        } catch (Exception e) {
            System.out.println("end time" + getDateTimeNow());
            throw new RuntimeException(e);
        }





    }

    @Test
    public void TC_05_() {
    }

    @Test
    public void TC_06_() {
    }

    @Test
    public void TC_07_() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }

}
