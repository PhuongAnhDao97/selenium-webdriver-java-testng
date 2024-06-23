package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_09_WebElement_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Element() {
        // dung de xoa du lieu torng 1 field cho phep nhap (editable)
        // Textbox / textarea / dropdown (editable)
        // thuong dc su dung trc ham sendkey de dam bao tinh toan ven du lieu
        driver.findElements(By.id("")).clear(); //**

        // dung de nhap lieu
        driver.findElement(By.id("")).sendKeys(); //**

        // apply cho thg nao click dc, dung de click len element
        driver.findElement(By.id("")).click(); //**

        // tim tu node cha vao node con >> it su dung > find xpath, css
        driver.findElement(By.id("email")).findElement(By.id("input"));
        driver.findElement(By.id("email")).findElements(By.id("input"));

        // tra ve nhieu elements khop voi dieu kien
        List<WebElement> textBoxes = driver.findElements(By.id(""));
        textBoxes.add(driver.findElement(By.id("gsrg")));


        // java non generic
        ArrayList<Object> name = new ArrayList<Object>();
        name.add("test");
        name.add(15);
        name.add('B');
        name.add(true);
        name.add(textBoxes);
        System.out.println(name);

//        // java generic
        ArrayList<String> address = new ArrayList<String>();
        address.add("test");
//        address.add(15);
//        address.add('B');
//        address.add(true);


        // dung de verify 1 check box / radio / dropdown da dc chon hay chua
        Assert.assertTrue(driver.findElement(By.id("")).isSelected()); //*
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        // dropdown co thu vien rieng de handle (default /custom)


        //  dung de verify 1 element bat ki co hien thi hay k
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed()); //**

        // dung de verify 1 element co dc thao tac len k (ko p read-only)
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled()); //*
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());

        // html element
        // tra ve value cua attribute do
        driver.findElement(By.id("input#email")).getAttribute("id"); //*
        driver.findElement(By.id("input#email")).getAttribute("title");
        driver.findElement(By.id("input#email")).getAttribute("type");

        // Tab accessibility / properties trong element
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("checked");

        // Tab Style torng element
        // font/ size / color / background
        driver.findElement(By.id("")).getCssValue(""); //*

        // lien quan toi position
        // lay ra vi tri cua element so voi do phan gia man hinh
        Point nameTextboxLocation = driver.findElement(By.id("")).getLocation();
//        nameTextboxLocation.getX();
//        nameTextboxLocation.getY();

        // Location + Size
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();

            // lay location
            Point namPoint = nameTextboxRect.getPoint();
            // lay size
            nameTextboxRect.getDimension();
            Dimension nameAddress = nameTextboxRect.getDimension();
            nameAddress.getHeight();
            nameAddress.getWidth();

        // handle loai shadow element (hc tong bai javasriptExecutor)
        driver.findElement(By.id("")).getShadowRoot();

        // tu id/ class/ name /css / xpath co the truy ra nguoc lai tagname
        driver.findElement(By.id("#firstname")).getTagName();
        driver.findElement(By.className("firstname")).getTagName();

            // element A dau ra cua no la tagname
            driver.findElement(By.xpath("//*[@class='firstname']")).getTagName();

            // dau vao cua element B se nhan tagname cua element A lam tham so >> can dung

        // get visible text, text bij hidden k get dc
        driver.findElement(By.id("")).getText(); //**

        // chup 1 hinh bi loi va luu duoi dang
        // BYTE
        // FILE: luu thanh hinh co kich thuoc trong o cung: png, jpg
        // BASE 64: hinh duoi dang text, ko he co kich thuoc
        driver.findElement(By.id("")).getScreenshotAs(OutputType.BASE64); //*
        driver.findElement(By.id("")).getScreenshotAs(OutputType.BYTES);
        driver.findElement(By.id("")).getScreenshotAs(OutputType.FILE);

        // nam trong the form moi apply, giong hanh vi nhan enter
        driver.findElement(By.id("")).submit(); //**

    }

    @Test
    public void TC_02_() {
        //html element: textbox / text area / dropdown / checkbox / link..
        // tim va tra ve 1 element
        driver.findElement(By.id(""));
        // tim va tuong tac len
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys();

        // tim va luu vao bien, chua tuong tac
        // khi dung bien nay it nhat 2 lan tro len
        WebElement fullNameTextBox = driver.findElement(By.id(""));
        fullNameTextBox.clear();
        fullNameTextBox.sendKeys("automation FC");
        fullNameTextBox.getAttribute("value");



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
