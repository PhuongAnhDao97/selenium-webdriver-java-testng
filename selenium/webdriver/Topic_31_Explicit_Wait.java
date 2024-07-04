package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.regex.Pattern;

public class Topic_31_Explicit_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        // khoi taoexplicit wait co tong thoi gian 10s polling 0.5 giay mac dinh
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));


        // khoi taoexplicit wait co tong thoi gian 10s polling 0.5 giay tu set
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));


    }

    @Test
    public void TC_01_() {

        // cho alert presence trong DOM trc khi thao tac len
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        //cho cho element k con trong DOM nua
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        //cho cho element k con trong DOM nua (ko quan tam co tren UI ko)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        //cho cho 1 list element trong DOM xuat hien
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        //cha va con > ko dung
        explicitWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.cssSelector(""), By.cssSelector("")));

        //cho cho 1 - n element dc hien thi tren giao dien
        // 1 or nhieu element, rest parameter
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")), driver.findElement(By.cssSelector(""))));

        //cho cho element dc phep click: link/ button/ checkbox/ radio
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));


        //thuong dung trc get title, cho cho page hien tai co title nhu mong doi
        explicitWait.until(ExpectedConditions.titleIs(""));
        driver.getTitle();

        // ket hop nhieu dieu kien > it dung
        explicitWait.until(ExpectedConditions.and(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")), ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("")))));

        //its nhat 1 dk dung la dc
        explicitWait.until(ExpectedConditions.or(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")), ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("")))));

        // cho cho 1 element chua attribute chua gia tri mong doi (tuong doi)
        // attribute lay ben html
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("A"), "B", "C"));

        // cho cho 1 element day du attribute voi gia  tri mong doi (tuyet doi)
        // attribute lay ben html
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector("A"), "B", "C"));

        // cho cho 1 element day du attribute khac null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")), ""));

        // gom tat ca attribute lay ben tab console (day du)
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")), "", ""));


        // tab dom properties / css (chrome) > it dung
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")), "", ""));

        // cho cho 1 element dc selected thanh cong
        // checkbox / radio / dropdown(default)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // cho cho 1 element selected roi
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), true));

        // cho cho 1 element chua selected
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), true));

        // cho cho 1 cai frame frame dc available va switch qua
        // Name or ID
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(""));

        // index
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

        //by or element
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(""))));


        //
        explicitWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements());

        // cho cho 1 doan code js can tra ve gia tri kieu object , string ...
        explicitWait.until(ExpectedConditions.jsReturnsValue("return arguments[0].validationMessage;"));


        // cho cho 1 doan code js dc thuc thi ma ko nem ra exception > true
        Assert.assertTrue(explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("return arguments[0].validationMessage;")));

        // cho cho element co so luong bao nhieu
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""), 10));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""), 10));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""), 10));

        // cho cho window tab la bao nhieu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));

        //

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""), ""));


        Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector(""), pattern));

        // bat buoc text p co trong DOM
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(""), ""));

        //
        explicitWait.until(ExpectedConditions.urlToBe(""));

        //
        explicitWait.until(ExpectedConditions.urlContains(""));

        //
        explicitWait.until(ExpectedConditions.urlMatches("[^abc]"));


        // cho cho 1 dk ma element dc update trang thai lai, dc render lai
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.cssSelector(""))));


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
