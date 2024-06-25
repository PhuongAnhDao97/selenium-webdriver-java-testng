package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_12_Custom_Dropdown {
    WebDriver driver;
    // wait tuong minh
    // Visible / Invisible / Presence / number / clickable /...
    WebDriverWait explicitWait; // wait ngam

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        // ngam dinh: ko ro rang cho 1 trang thai cu the nao het cua element
        // ngam dinh cho viec tim find element
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_JQuery() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");


        // 1 -  click vao 1 the de cho no xo het cai item ben trong dropdown ra
        driver.findElement(By.xpath("//span[@id='number-button']")).click();

        // 2.1 no se xo ra het tat ca cac item trong dropdown
        // 2.2 no se xo ra 1 phan va dang load them
        // cho cho no xo ra het item trong drop down

        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));

        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));

        // allItems dang luu tru 19 items ben trong

        for (WebElement item : allItems) {
            // neu element dc tick xong cac ham khac goi thi get text bi fail
            String textItem = item.getText();
            // 3 kiem tra text cua tung item thoa dk thi click vao
            if (textItem.equals("8")) {   // kieu tham chieu thi .equals/ neu nguyen thuy thi dung ==
                item.click();
                break; // dung trong for / while / do-while / switch-case
            }
        }
        selectItemInDropdown("//span[@id='speed-button']","ul#speed-menu div","Slow");
        sleepInSeconds(3);
        selectItemInDropdown("//span[@id='files-button']","ul#files-menu div","jQuery.js");
        sleepInSeconds(3);
        selectItemInDropdown("//span[@id='number-button']","ul#number-menu div","8");
        sleepInSeconds(3);
//        driver.navigate().refresh();
        selectItemInDropdown("//span[@id='number-button']","ul#number-menu div","15");
        sleepInSeconds(3);
        selectItemInDropdown("//span[@id='salutation-button']","ul#salutation-menu div","Mr.");
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(),"Slow");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button span.ui-selectmenu-text")).getText(),"jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button span.ui-selectmenu-text")).getText(),"15");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button span.ui-selectmenu-text")).getText(),"Mr.");
}


    @Test
    public void TC_02_React() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInDropdown("//div[@role='listbox']","div.item>span.text","Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Justen Kitsune");
        sleepInSeconds(2);

        selectItemInDropdown("//div[@role='listbox']","div.item>span.text","Stevie Feliciano");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Stevie Feliciano");
        sleepInSeconds(2);


    }

    @Test
    public void TC_03_() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemInDropdown("//li[@class='dropdown-toggle']","ul.dropdown-menu a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
    }

    @Test
    public void TC_04_Editable() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        selectItemInEditableDropdown("input.search","div.item span","Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Algeria");
    }

    @Test
    public void TC_05_NopComerce() {
        driver.get("https://demo.nopcommerce.com/register");
        selectItemInDropdown("//select[@name='DateOfBirthDay']","select[name='DateOfBirthDay']>option","15");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']>option[value='15']")).isSelected());
        sleepInSeconds(1);

        selectItemInDropdown("//select[@name='DateOfBirthMonth']","select[name='DateOfBirthMonth']>option","September");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']>option[value='9']")).isSelected());
        sleepInSeconds(1);

        selectItemInDropdown("//select[@name='DateOfBirthYear']","select[name='DateOfBirthYear']>option","1995");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']>option[value='1995']")).isSelected());
        sleepInSeconds(1);
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



    // nhung du lieu truyen vao xem nhu la tham so
    public  void selectItemInDropdown(String parentXpath, String childItemCss, String itemTextExpected) {

        driver.findElement(By.xpath(parentXpath)).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss)); // gan lai chu k can khai bao
        for(WebElement item : allItems){
            String textItem = item.getText();
            if (textItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }

    }

    public  void selectItemInEditableDropdown(String parentCss, String childItemCss, String itemTextExpected) {

        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        sleepInSeconds(1);


        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss)); // gan lai chu k can khai bao
        for(WebElement item : allItems){
            String textItem = item.getText();
            if (textItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }

    }

}
