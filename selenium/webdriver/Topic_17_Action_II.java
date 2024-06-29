package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_17_Action_II {
    WebDriver driver;
    Actions action;
    String osName =System.getProperty("os.name");
    Keys keys;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        action = new Actions(driver);

        if (osName.startsWith("Windows")) {
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

        // keys = osName.startsWith("Windows") ? keys = Keys.CONTROL : keys = Keys.COMMAND;
    }

    @Test
    public void TC_01_Click_And_hold_Block() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allnumbers = driver.findElements(By.cssSelector("ol#selectable>li"));

        action.clickAndHold(allnumbers.get(0)) // click vao so 1 va giu chuot
                .moveToElement(allnumbers.get(3)) // di toi so 4
                .release() // tra chuot trai
                .perform(); // thuc thi

        Thread.sleep(4000);


        List<WebElement> allnumberselected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allnumberselected.size(),4);


    }

    @Test
    public void TC_02_Click_And_hold_Random() {

        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allnumbers = driver.findElements(By.cssSelector("ol#selectable>li"));

        // nhan phim ctrl xuong nhung chua nha ra
        action.keyDown(Keys.CONTROL).perform();

        action.click(allnumbers.get(0))
        .click(allnumbers.get(3))
        .click(allnumbers.get(7))
        .click(allnumbers.get(10))
        .click(allnumbers.get(13))
        .click(allnumbers.get(17))
                .pause(Duration.ofSeconds(3))
                .perform();

        // nha phim ctrl

        action.keyUp(Keys.CONTROL).perform();

        List<WebElement> allnumberselected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allnumberselected.size(),6);


    }

    @Test
    public void TC_03_Double_Click() throws InterruptedException {

        driver.get("https://automationfc.github.io/basic-form/index.html");

        ((JavascriptExecutor)driver).executeScript ("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//button[text()='Double click me']")) );

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");

     }

    @Test
    public void TC_04_Right_Click()  {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        // right click
        action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
        // kiem tra quit menu hien thi
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
        // hover
        action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-hover.context-menu-visible")).isDisplayed());

        driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-hover.context-menu-visible")).click();

        driver.switchTo().alert().accept();

        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());


    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
