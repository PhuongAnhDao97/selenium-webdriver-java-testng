package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_36_Wait_Page_Ready {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Nopcommerce() throws InterruptedException {
        driver.get("https://admin-demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("input#Email")).clear();
        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input#Password")).clear();
        driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.login-button")).click();

        Assert.assertTrue(isPageLoadedSuccess());

        driver.findElement(By.xpath("//i[contains(@class,'fa-user')]/following-sibling::p")).click();
//        Assert.assertTrue(isPageLoadedSuccess());
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[contains(@class,'fa-user')]/following-sibling::p/parent::a/following-sibling::ul//p[contains(string(),'Customers')]")))).click();
        //driver.findElement(By.xpath("//i[contains(@class,'fa-user')]/following-sibling::p/parent::a/following-sibling::ul//p[contains(string(),'Customers')]")).click();

        Assert.assertTrue(isPageLoadedSuccess());
    }

    @Test
    public void TC_02_OrangeHRM() {
        driver.get("https://api.orangehrm.com");

        //c1
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner"))));


        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='OrangeHRM REST API Documentation']")).isDisplayed());

    }

    @Test
    public void TC_03_() {
     }



     // the rut gon  cua ham ben duoi
//    public boolean isPageLoadedSuccess() {
//        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return (Boolean) ((JavascriptExecutor) driver)
//                        .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
//            }
//        });
//    }


//    public  boolean waitAjaxLoadingInvisible(){
//
//        return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy")));
//
//    }

    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // dieu kien 1
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        // dieu kien 2
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
