package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

public class Topic_23_Window_Tab {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Basic_Form() {

        driver.get("https://automationfc.github.io/basic-form/index.html");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        // lay ra ID tab hien tai
        String parentID = driver.getWindowHandle();
        System.out.println(parentID);

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSeconds(2);

        // tra ve set String: ko dc tring lap, con list String la dc trung lap
        Set<String> allIDs = driver.getWindowHandles();

        for (String id : allIDs) { // String ko dung == ma dung equals
            // neu nhu <> parent thi switch vao
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                // thoat khoi vong lap k can kiem tra lai cac gia tri con lai neu co
                break;
            }
        }

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("ABC");
        sleepInSeconds(2);

        String ggTabID = driver.getWindowHandle();

        switchToWindowTabByID(ggTabID);
        sleepInSeconds(2);

        System.out.println(driver.getTitle());


        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSeconds(2);

        // dung ham khac co the su dung cho 2 hoac nhieu hon 2 tab

        switchToWindowByTitle("Facebook – log in or sign up");

        System.out.println(driver.getTitle());

        driver.findElement(By.cssSelector("input#email")).sendKeys("12463");
        sleepInSeconds(2);

        closeAllWindowsWithoutParent("Selenium WebDriver");
    }

    @Test
    public void TC_02_Tech_Panda() {

        driver.get("http://live.techpanda.org/");
        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        WebElement sony = driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div//a[@class='link-compare']"));
        sony.click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");

        WebElement samsung = driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div//a[@class='link-compare']"));
        samsung.click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

        WebElement iphone = driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div//a[@class='link-compare']"));
        iphone.click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product IPhone has been added to comparison list.");


        driver.findElement(By.cssSelector("button[title='Compare']")).click();

        switchToWindowByTitle("Products Comparison List - Magento Commerce");

        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "COMPARE PRODUCTS");
        // get text se get tren UI visible text

        switchToWindowByTitle("Mobile");

        driver.findElement(By.cssSelector("input#search")).sendKeys("124");
        sleepInSeconds(2);

        closeAllWindowsWithoutParent(parentID);
        sleepInSeconds(2);

        // selenium 3 muon new tab, window dung ctr N va Ctrl T


    }

    @Test
    public void TC_03_Dictionary() {
        driver.get("https://dictionary.cambridge.org");

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Log in']")).click();

        switchToWindowByTitle("Login");

        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@data-bound-to='loginID' and text()='This field is required']")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@data-bound-to='password' and text()='This field is required']")).getText(),"This field is required");

        driver.close();

        switchToWindowByTitle("Cambridge Dictionary | English Dictionary, Translations & Thesaurus");

        driver.findElement(By.cssSelector("input#searchword")).sendKeys("Can");
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("button[aria-label='Search']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//h1/b")).getText(),"can");


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

    public void switchToWindowTabByID(String expectedID) {
        Set<String> allIDs = driver.getWindowHandles();

        for (String id : allIDs) {
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String expectedTitle) {
        // lay het tat ca iD cua window
        Set<String> allIDs = driver.getWindowHandles();

        for (String id : allIDs) {
            // cho switch vao tung id trc
            driver.switchTo().window(id);

            String actualTitle = driver.getTitle();

            if (actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(String parentID) {

        Set<String> allIDs = driver.getWindowHandles();

        for (String id : allIDs) {

            if (!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close(); //
            }

        }

        driver.switchTo().window(parentID);

    }

}
