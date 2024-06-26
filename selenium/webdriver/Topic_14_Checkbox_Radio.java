package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_14_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Default_Telerik_Checkbox() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        By dualZoneCHeckbox =By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        checktoElement(dualZoneCHeckbox);

        Assert.assertTrue(driver.findElement(dualZoneCHeckbox).isSelected());
        // case bo chon

        unchecktoElement(dualZoneCHeckbox);
        Assert.assertFalse(driver.findElement(dualZoneCHeckbox).isSelected());

    }

    @Test
    public void TC_02_Default_Telerik_Radio() {

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By petrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        By dieselRadio = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::span/input");

        checktoElement(petrolRadio);
        Assert.assertTrue(driver.findElement(petrolRadio).isSelected());
        Assert.assertFalse(driver.findElement(dieselRadio).isSelected());
        Assert.assertFalse(driver.findElement(dieselRadio).isSelected());
        Assert.assertFalse(driver.findElement(dieselRadio).isSelected());

        checktoElement(dieselRadio);
        Assert.assertTrue(driver.findElement(dieselRadio).isSelected());
        Assert.assertFalse(driver.findElement(petrolRadio).isSelected());


    }

    @Test
    public void TC_03_Select_All_Checkbox() {

        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        // cach chon het
        for (WebElement checkbox: allCheckboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
                sleepInSeconds(1);
            }
        }

        // cach verify
        for(WebElement checkbox: allCheckboxes){
            Assert.assertTrue(checkbox.isSelected());
        }


        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        // chon 1 checkbox
        for(WebElement checkbox: allCheckboxes){
            if (checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()){
                checkbox.click();
            }
        }

        // cach verify
        for(WebElement checkbox: allCheckboxes){

            if(checkbox.getAttribute("value").equals("Heart Attack")){
                Assert.assertTrue(checkbox.isSelected());
            } else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }


     }


    @Test
    public void TC_04_CustomCheckbox() {

        // trang ko support nua
        // selected chi apply cho only input
        // de nhung dc JS vao selenium


        // cach click len input ben duoi 2 the div
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[text()='Dang ki cho ng than']")));  // ep thang

        // driver la interface (WebDriver)
        // interface JavscriptExecutor
        // ep kieu interface nay qua kieu khac bang gan (tuong minh)

//        JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
//        jsExcutor.executeScript("");

    }

    @Test
    public void TC_05_Ubuntu() {
        driver.get("https://login.ubuntu.com/");
        sleepInSeconds(2);
        ((JavascriptExecutor)driver) .executeScript("arguments[0].click();",driver.findElement(By.cssSelector("input#id_new_user")));
        ((JavascriptExecutor)driver) .executeScript("arguments[0].click();",driver.findElement(By.cssSelector("input#id_accept_tos")));

    }

    @Test
    public void TC_06_GGdocs() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

        By canThoRadio = By.xpath("//div[@aria-label='Cần Thơ']");

        // verify element is not selected
        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"), "false");

        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='false']")).isDisplayed());

        driver.findElement(canThoRadio).click();
        sleepInSeconds(2);
        // ko AssertFalse dc
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='true']")).isDisplayed());

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
    // neu nhu element chua dc chon r thi moi click
    public  void checktoElement(By byXpath){
        if(!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(1);
        }

    }
// neu nhu element dc chon r thi moi click > bo chon
    public  void unchecktoElement(By byXpath){
        if(driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(1);
        }

    }

}
