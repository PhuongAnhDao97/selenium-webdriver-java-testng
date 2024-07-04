package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_28_Wait_FindElement {
    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // selenium ver 3
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // ver 4
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // ver 3
        // explicitWait = new WebDriverWait(driver, 10);


        // ver 4
        fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));


        // ver 3
//        fluentWait.withTimeout(5000, TimeUnit.MICROSECONDS)
//                .pollingEvery(2500, TimeUnit.MICROSECONDS);

        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_FindElement() {
        // element dc tim thay chi 1
        // se k can cho het timeout
        // tim thay tra ve 1 webelement
        // qua step tiep theo
        System.out.println("start steps: "+ getDateTimeNow());
        driver.findElement(By.cssSelector("input#email"));
        System.out.println("start steps: "+ getDateTimeNow());

        // element dc tim thay co nhieu hon 1
        // ko can cho het timeout
        // tra ve 1 element dau tien
        System.out.println("start steps: "+ getDateTimeNow());
        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("linasmith@gmail.com");
        System.out.println("start steps: "+ getDateTimeNow());

        // element ko dc tim thay
        //cho het timeout la 10s
        // trong tgian nay cu moi nua giay tim lai 1 lan
        // neu tim lai ma thay se tra ve element roi qua step tiep theo
        // neu nhu tim lai ma k thay thi > fail test case va throw exception NoSuchElement
        // step con lai k chay nua
        System.out.println("start steps: "+ getDateTimeNow());
        driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));
        System.out.println("start steps: "+ getDateTimeNow());

    }

    @Test
    public void TC_02_FindElements() {

        List<WebElement> elementList;
        // case 1 element dc tim thay trong khoang thoi gian dc set, chi co 1
        // ko can cho het timeout 10s
        // tra ve 1 list elements chua 1 element
        System.out.println("start steps: "+ getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#email"));
        System.out.println("List have :" + elementList.size());
        System.out.println("start steps: "+ getDateTimeNow());

        // case 2 element dc tim thay co nhieu hon 1
        //ko can cho het timeout 10s
        // tra ve 1 list elements chua 2 element
        System.out.println("start steps: "+ getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        System.out.println("start steps: "+ getDateTimeNow());
        System.out.println("List have :" + elementList.size());

        // case 3 element k dc tim thay
        // cho het timeout 10s
        // moi nua giay tim lai 1 lan
        // neu trong tgian tim lai thay element cung tra ve list chua cac element do
        // neu het tgian tim lai k thay> tra ve empty list va ko fail testcase > qua step tiep theo
        System.out.println("start steps: "+ getDateTimeNow());
        driver.findElements(By.cssSelector("input[name='reg_email_confirmation__']"));
        System.out.println("start steps: "+ getDateTimeNow());
        System.out.println("List have :" + elementList.size());

    }

    @Test
    public void TC_03_() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }


}
