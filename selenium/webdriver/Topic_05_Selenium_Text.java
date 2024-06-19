package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Selenium_Text {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {
        driver.get("https://automationfc.github.io/basic-form/");

        // 1- truyen text vao trong locator de check hien thi
            // nen su dung vi no tuyet doi
            driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']")).isDisplayed();
            // han che vi no tuong doi
            driver.findElement(By.xpath("//p[contains(text(),'Mail Personal or Business Check')]")).isDisplayed();
            driver.findElement(By.xpath("//p[contains(text(),\"Mail Personal or Business Check, Cashier's Check or money order to:\")]")).isDisplayed();


        // 2- get text ra roi verify sau
        //Mail Personal or Business Check, Cashier's Check or money order to:
        String text = driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();
        Assert.assertTrue(text.contains("Mail Personal or Business Check"));
        Assert.assertTrue(text.contains("Cashier's Check or money order to:"));
        Assert.assertTrue(text.contains("Mail Personal or Business Check, Cashier's Check or money order to:"));

        //nen ****

        String nestedText =  driver.findElement(By.xpath("//h5[@id='nested']")).getText();
        System.out.println(nestedText);

        Assert.assertEquals(nestedText,"Hello World! (Ignore Me) @04:45 PM");

        //concat
        //cach 1 >> locator xau
        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]")).isDisplayed();
        // cach 2 >> suggest, locator ngan gon, de hieu
        String concatText =  driver.findElement(By.xpath("//span[@class='concat']")).getText();
        Assert.assertEquals(concatText,"Hello \"John\", What's happened?");





    }


    @Test
    public void TC_02_() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
