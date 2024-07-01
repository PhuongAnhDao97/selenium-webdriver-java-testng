package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_21_Shadow_DOM {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Shadow_Dom() {
        driver.get("https://automationfc.github.io/shadow-dom/");

        // di theo dung cau truc html

        WebElement shadowHostElement = driver.findElement(By.cssSelector("div#shadow_host"));

        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();

        String someText = shadowRootContext.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.println(someText);


        // dung findelements > dung voi css
        List<WebElement> allInput = shadowRootContext.findElements(By.cssSelector("input"));

        WebElement checkboxShadow = shadowRootContext.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxShadow.isSelected());

         System.out.println(allInput.size());

         WebElement nestedShadowHostElement = shadowRootContext.findElement(By.cssSelector("div#nested_shadow_host"));

         SearchContext shadowRootContextChild = nestedShadowHostElement.getShadowRoot();

        String nestedText = shadowRootContextChild.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();

        Assert.assertEquals(nestedText, "nested text");


    }

    @Test
    public void TC_02_Shopee() {

        driver.get("https://shopee.vn/");

    }

    @Test
    public void TC_03_() {
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
}
