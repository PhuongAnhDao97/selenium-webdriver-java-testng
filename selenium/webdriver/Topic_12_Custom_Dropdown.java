package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_12_Custom_Dropdown {
    WebDriver driver;
    // wait tuong minh
    // Visible / Invisible / Presence / number / clickable /...
    WebDriverWait explicitWait; // wait ngam
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        // ngam dinh: ko ro rang cho 1 trang thai cu the nao het cua element
        // ngam dinh cho viec tim find element
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");


        // 1 -  click vao 1 the de cho no xo het cai item ben trong dropdown ra
        driver.findElement(By.xpath("//span[@id='number-button']")).click();
        sleepInSeconds(10);

        // 2.1 no se xo ra het tat ca cac item trong dropdown
        // 2.2 no se xo ra 1 phan va dang load them
        // cho cho no xo ra het item trong drop down

        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));

        List<WebElement> allItems   = driver.findElements(By.cssSelector("ul#number-menu div"));

        // allIOtems dang luu tru 19 items ben trong

        for(WebElement item : allItems){
                // neu element dc tick xong cac ham khac goi thi get text bi fail
                String textItem = item.getText();
            // 3 kiem tra text cua tung item thoa dk thi click vao
                if (textItem.equals("8")){   // kieu tham chieu thi .equals/ neu nguyen thuy thi dung ==
                    item.click();
                    break; // dung trong for / while / do-while / switch-case
                }
        }


    }

    @Test
    public void TC_02_() {

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

}
