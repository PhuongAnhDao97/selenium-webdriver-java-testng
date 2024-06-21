package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
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

        // ver 3/2/1
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
