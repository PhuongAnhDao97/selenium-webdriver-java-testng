package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_26_Upload_File {
    WebDriver driver;

    String projectPath = System.getProperty("user.dir");

    String hcmName = "HCM.jpg";
    String dlName = "DaLat.jpg";
    String pyName = "PhuYen.jpg";

    // window \\
    // MAC /

    // de may khac cung chay dc lay duong dan tuong doi

    String character = Platform.getCurrent().is(Platform.WINDOWS) ? "\\" : "/";

    String hcmFilePath = projectPath + character + "uploadFiles" + character + hcmName;
    String dlFilePath = projectPath + character + "uploadFiles" + character + dlName;
    String pyFilePath = projectPath + character + "uploadFiles" + character + pyName;



    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Single_File() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        // fix cung path, chi co may minh chay, may ng khac k chay dc
        // String filePath = "D:\\Workspace\\Selenium\\02 - Selenium WebDriver\\selenium-webdriver-java-testng\\uploadFiles\\DaLat.jpg";

        By uploadBy = By.cssSelector("input[name='files[]']");

        driver.findElement(uploadBy).sendKeys(hcmFilePath);
        sleepInSeconds(2);

        driver.findElement(uploadBy).sendKeys(dlFilePath);
        sleepInSeconds(2);

        driver.findElement(uploadBy).sendKeys(pyFilePath);
        sleepInSeconds(2);

        // verify loaded success

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ hcmName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ dlName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ pyName +"']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        for (WebElement button : startButtons) {
            button.click();
            sleepInSeconds(2);
        }


        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hcmName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + dlName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + pyName + "']")).isDisplayed());



    }

    @Test
    public void TC_02_Multiple_File() {

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadBy = By.cssSelector("input[name='files[]']");

        driver.findElement(uploadBy).sendKeys(hcmFilePath + "\n" +dlFilePath + "\n" +pyFilePath);

        // neu nhieu qua thi k load file len dc do gioi han ki tu, khoang 140 kti tu
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ hcmName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ dlName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ pyName +"']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        for (WebElement button : startButtons) {
            button.click();
            sleepInSeconds(2);
        }


        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hcmName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + dlName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + pyName + "']")).isDisplayed());

    }

    @Test
    public void TC_03_() {
     }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
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
