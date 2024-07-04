package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_33_Explicit_III {
    WebDriver driver;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");

    String hcmName = "HCM.jpg";
    String dlName = "DaLat.jpg";
    String pyName = "PhuYen.jpg";

    String character = Platform.getCurrent().is(Platform.WINDOWS) ? "\\" : "/";

    String hcmFilePath = projectPath + character + "uploadFiles" + character + hcmName;
    String dlFilePath = projectPath + character + "uploadFiles" + character + dlName;
    String pyFilePath = projectPath + character + "uploadFiles" + character + pyName;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    @Test
    public void TC_01_AjaxLoading() {

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        By selectedDateBy = By.cssSelector("span.label");

        Assert.assertEquals(driver.findElement(selectedDateBy).getText(),"No Selected Dates to display.");

        driver.findElement(By.xpath("//a[text()='12']")).click();

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));

        Assert.assertEquals(driver.findElement(selectedDateBy).getText(),"Friday, July 12, 2024");



    }

    @Test
    public void TC_02_GoFile_Uploading() {

        driver.get("https://gofile.io/welcome");

        //  wait + verify spinner icon bien mat
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));

        // wait + click
        explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a.ajaxLink>button")))).click();

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));


        // upload 3 files
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(hcmFilePath + "\n" +dlFilePath + "\n" +pyFilePath);

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));


        // wait cho progress bar bien mat
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("input[type='file']"))));


        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='HCM.jpg']/parent::a/parent::div/following-sibling::div/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='DaLat.jpg']/parent::a/parent::div/following-sibling::div/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='PhuYen.jpg']/parent::a/parent::div/following-sibling::div/a")).isDisplayed());

    }

    @Test
    public void TC_03_() {



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}


// co 2 cach wait:
// 1 wait cho 1 cai dc hoan thanh > invisible
// wiat cho 1 cai xuat hien
