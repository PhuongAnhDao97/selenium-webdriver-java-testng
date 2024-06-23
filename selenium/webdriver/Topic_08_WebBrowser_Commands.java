package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
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
        driver = new FirefoxDriver(); //**

        driver.manage().window().maximize();

        // ver 3/2/1nk find element thi k can dung
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // ver 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Command() throws MalformedURLException {
        //muon dung dc p khoi tao > neu k khoi tao > error NullPointerException
        // 1 bien chua khoi tao nhung dc sd
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/"); //**

        // dong browser ko care bao nhieu tab
        driver.quit(); //**
        // close 1 tab dang active. neu co 1 tab dong browser
        driver.close(); //*

        // 2 ham ben duoi bi anh huong boi implicitWait
        //findElements/ findElement dung de cho cho element dc tim thay




        // By la kieu du lieu, id ben trong cung la kieu du lieu String
        // di tim va tra ve WebElement neu tim thay
        // neu k tim thay bi fail tai step nay -throw exception NoSuchElementException
        // bien abc khai bao p co cung kieu du lieu tra ve
        // tra ve 1 element, neu nhu tim thay > 1 chi lay 1 va thao tac element dau tien
        WebElement abc = driver.findElement(By.id("")); //**


        // tra ve 1 list elements
        // ko tim thay thi k fail, ko throw gi ca, tra ve list rong 0 element
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='check-box")); //**

        // driver.findElements(By.xpath("")).click(); > sai do thao tac nhieu element thi k click dc
        // sua lai bo "s"

        // bat dau bang "get" luon luon tra ve du lieu
        // tai s can lay du lieu lam gi
        // >> verify

        String loginPageUrl = driver.getCurrentUrl();

        // dung de lay ra url cua tab hien tai
        driver.getCurrentUrl(); //*

        // lay ra page source, html, css cua page hien tai
        // verify cach tuong doi
        driver.getPageSource();

        // lay ra title cua page hien tai (tren tab)
        driver.getTitle();


        //lay ra 1 id cua cua so/tab hien tai
        // handle window/tab
        driver.getWindowHandles(); //*


        //lay ra het toan bo id cua cua so/tab hien tai
        // handle window/tab
        driver.getWindowHandle();//*

        // cookies - framework
        driver.manage().getCookies(); //*
        // get ra nhung log o dev tool - framework
        driver.manage().logs().get(LogType.DRIVER); //*
        //apply find element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        // cho cho 1 page dc load xong > thuong la k can
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // set trc khi dung vs thu vien javascriptExecutor
        // Inject 1 doan code JS vao trong Browser / Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // thuong la k dung
        driver.manage().timeouts().getImplicitWaitTimeout();

        driver.manage().window().fullscreen();
        driver.manage().window().maximize(); //**
        driver.manage().window().minimize();

        // test responsive (resolution)
        // test GUI
        driver.manage().window().setSize(new Dimension(1366,768));
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().setSize(new Dimension(2560,1440));

        driver.manage().window().getSize();


        // toa do man hinh, it dung
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();


        // ham dung de dieu huong trang web
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        // thao tac voi history cua page (back/forward...)
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/") );

        // ko ho tro history
        driver.get("");



        // Alert / Window (Tab) / Frame (iFrame) //*
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Test");

        // truyen vao window id , lay tu ham handle //*
        // hoc trong bai window va tab
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homePageWindowID);

        Set<String> allWindowId =driver.getWindowHandles();


        // handle frame iframe
        // index / id (name)/ element
        driver.switchTo().frame(0);
        driver.switchTo().frame("3758273");
        driver.switchTo().frame(driver.findElement(By.id("")));
        // switch ve html chua frame trc do
        driver.switchTo().defaultContent();
        // tu frame trong di ra frame ngoai chua no
        driver.switchTo().parentFrame();






        // neu chi dung 1 lan > ko khai bao bien
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        // dung laij nhieu lan (it nhat 2 lan ) khai bao bien
        Assert.assertEquals(loginPageUrl,"https://www.facebook.com/");



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
