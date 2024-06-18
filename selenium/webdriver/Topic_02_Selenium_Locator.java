package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
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
        driver.get("https://demo.nopcommerce.com/register");
    }

    /**
     * 8 type locator
     * selenium locator = html attribute
     * Id / class / name : trung voi 3 attribute c html
     * LinkText / Partial LinkText: HTML link the (a)
     * Tag name: html tag name input div li
     * Css, Xpath
     * <p>
     * selenium version 4.x
     * them: relative locator
     * above/ bellow / near/ leftOf/ rightOf
     * <p>
     * UI Testing
     * FUI: functional UI
     * GUI: graphic UI : Font, size, color, position, location, resolution, responsive
     * TestNG order testcase theo alphabet
     */

    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("Kiet");
        System.out.println("test: " + driver.findElement(By.id("FirstName")));
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_Tagname() {
        driver.findElements(By.tagName("input"));
        // tim so nhieu, co bao nhieu the giong nhau
        // it dung
    }

    @Test
    public void TC_05_LinkText() {
        driver.findElements(By.linkText("Shipping & returns"));
        // do chinh xac cao vi lay tuyet doi
        // it dung
    }

    @Test
    public void TC_06_PartialLinkText() {
        driver.findElements(By.partialLinkText("vendor account"));
        // do chinh xac ko cao vi tuong doi
        // it dung
    }

    @Test
    public void TC_07_Css() {
        // css voi id
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // css voi class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // css vs name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // css vs tagname
        driver.findElement(By.cssSelector("input"));

        // css vs link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        // css vs partial link
        //giua
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        //dau
        //driver.findElement(By.cssSelector("a[href^='addresses']"));
        //duoi
        //driver.findElement(By.cssSelector("a[href$='addresses']"));

    }

    @Test
    public void TC_08_Xpath() {
        // Xpath voi id
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // Xpath voi class
        driver.findElement(By.xpath("//div[@class='page-title']"));


        // Xpath vs name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // Xpath vs tagname
        driver.findElement(By.xpath("//input"));

        // Xpath vs link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        // Xpath vs partial link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
