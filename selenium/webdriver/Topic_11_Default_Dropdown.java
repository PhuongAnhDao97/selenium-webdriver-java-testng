package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_11_Default_Dropdown {
    WebDriver driver;
    String firstName = "Lina", lastName = "Kane", emailAddress = getEmailAdress(),
            companyName = "Lina JSC", password = "123456";
    String day = "15", month = "October", year = "2000";


    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        // chon ngay
        dayDropdown.selectByVisibleText(day); // lay bien global do bien local khac kieu du lieu
        // verify dropdown la single (ko p multiple)
        Assert.assertFalse(dayDropdown.isMultiple());
        // verify so luong item trong dropdown la 32 items
        Assert.assertEquals(dayDropdown.getOptions().size(), 32);
        // c2
        //List<WebElement> dayOptions = dayDropdown.getOptions();
        // Assert.assertEquals(dayOptions.size(), 32);

        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);

//        dayDropdown.isMultiple(); // kiem tra xem la single hay multiple dropdown
//        dayDropdown.selectByValue("7764"); // co value moi dung dc
//        dayDropdown.selectByIndex(10); // lay index cua option bd tu 0
//        dayDropdown.deselectByVisibleText("Tinh Ha Tay"); // text trong the option


//        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
//        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));

        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

        driver.findElement(By.cssSelector("a.ico-logout")).click();
        sleepInSeconds(2);
    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demo.nopcommerce.com/");
        sleepInSeconds(3);
        // login
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(3);

        // verify
        driver.findElement(By.className("ico-account")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),companyName);




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

    public String getEmailAdress() {

        return "linakane" + new Random().nextInt(99999) + "@gmail.com";
    }
}
