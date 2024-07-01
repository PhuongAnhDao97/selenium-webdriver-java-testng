package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_20_Popup_II {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @Test
    public void TC_01_Random_Not_In_DOM() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");

        Thread.sleep(15000);

        By cardPopup = By.cssSelector("div#card");
        By newsletterPopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");

        // neu hien thi thi close no di
        if (!driver.findElements(cardPopup).isEmpty()) {
            driver.findElement(By.cssSelector("div#dismiss-button")).click();
            System.out.println(" pop 1 hien thi");
        }

        if (driver.findElements(newsletterPopup).size() > 0
                && driver.findElements(newsletterPopup).get(0).isDisplayed()) { // lon hon 0 la da dc render ra roi, nhung chua biet hien thi hay k
            driver.findElement(By.cssSelector("div.lepopup-element-html-content>a:not([class])[onclick]")).click();
            System.out.println("popup 2 hien thi va dong");
        }

        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("button#search-submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h1/span[text()='Agile Testing Explained']")).isDisplayed());

        // neu k hien thi qua step tiep theo > field search duw lieu


    }


    @Test
    public void TC_02_Random_Not_In_DOM() throws InterruptedException {

        driver.get("https://www.kmplayer.com/home");

        By containerPopup = By.cssSelector("div.pop-container");

        if (driver.findElement(containerPopup).isDisplayed()){
            System.out.println("popup hien thi");
            driver.findElement(By.cssSelector("div.close>close")).click();
        }
        // neu bi che boi popup khac thi nen dung javascript de click

        int heightBrowser = driver.manage().window().getSize().getHeight();
        if (heightBrowser <1920){
            ((JavascriptExecutor)driver) .executeScript("arguments[0].click();",driver.findElement(By.cssSelector("li.pc.pc64x")));

        }

        Thread.sleep(2000);
        findElement(By.cssSelector("li.pc.pc64x")).click();
    }

    public WebElement findElement(By locator) {

        // neu popup xuat hien thi close di
        // chi override ham dc khi code do xuat hien o tat ca cac page

        if (driver.findElement(By.cssSelector("div.pop-container")).isDisplayed()){
            System.out.println("popup hien thi");
            driver.findElement(By.cssSelector("div.close>close")).click();
        }

        return driver.findElement(locator);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
