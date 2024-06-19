package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Find_Element {
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
        driver.get("http://live.techpanda.org/");

        //click vao my account tren header
        // sai
        //driver.findElement(By.xpath("//a[@title='My Account']")).click();
        // dung
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        // the k co attribute
        //driver.findElement(By.xpath("asffff")),getText();

    }


    @Test
    public void TC_02_() {

    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
