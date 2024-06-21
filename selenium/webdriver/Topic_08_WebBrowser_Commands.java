package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_08_WebBrowser_Commands {
    // cac cau lenh de thao tac voi browser
    // driver.

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    WebElement element;

    // cac cau lenh thao tac voi element
    // element.

    //

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // ver 3/2/1nk find element thi k can dung
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // ver 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Command() {
        //muon dung dc p khoi tao > neu k khoi tao > error NullPointerException
        // 1 bien chua khoi tao nhung dc sd
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");

        // dong browser ko care bao nhieu tab
        driver.quit();
        // close 1 tab dang active. neu co 1 tab dong browser
        driver.close();

        // 2 ham ben duoi bi anh huong boi implicitWait
        //findElements/ findElement dung de cho cho element dc tim thay




        // By la kieu du lieu, id ben trong cung la kieu du lieu String
        // di tim va tra ve WebElement neu tim thay
        // neu k tim thay bi fail tai step nay -throw exception NoSuchElementException
        // bien abc khai bao p co cung kieu du lieu tra ve
        // tra ve 1 element, neu nhu tim thay > 1 chi lay 1 va thao tac element dau tien
        WebElement abc = driver.findElement(By.id(""));


        // tra ve 1 list elements
        // ko tim thay thi k fail, ko throw gi ca, tra ve list rong 0 element
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='check-box"));

        // driver.findElements(By.xpath("")).click(); > sai do thao tac nhieu element thi k click dc
        // sua lai bo "s"

        // bat dau bang "get" luon luon tra ve du lieu
        // tai s can lay du lieu lam gi
        // >> verify

        String loginPageUrl = driver.getCurrentUrl();

        // dung de lay ra url cua tab hien tai
        driver.getCurrentUrl();
        // lay ra page source, html, css cua page hien tai
        // verify cach tuong doi
        driver.getPageSource();
        //
        driver.getTitle();
        //
        driver.getWindowHandles();
        //
        driver.getWindowHandle();


        // neu chi dung 1 lan > ko khai bao bien
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        // dung laij nhieu lan (it nhat 2 lan ) khai bao bien
        Assert.assertEquals(loginPageUrl,"https://www.facebook.com/");

        // Assert equal la tuyet doi


    }

    @Test
    public void TC_02_() {


    }

    @Test
    public void TC_03() {

    }

    @Test
    public void TC_04() {

    }
}
