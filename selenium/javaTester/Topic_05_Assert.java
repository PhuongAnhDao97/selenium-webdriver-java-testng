package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {

    WebDriver driver;

    @Test
    public void verifyTestNG(){

        // trong java co nhieu thu vien verify du lieu:
        // goi la Testing framework (Unit/ Integration/ UI auto test)
        // JUnit 4/ TestNG / JUnit5 / AssertJ/ Hamcrest,...
        // TestNg vua la thu vien, vua la test runner


        // keiu du lieu nhan vao la boolean (true/ false)
        // khi mong muon Dk tra ve la dung thi dung assertTrue de verify 3 ham : asserTrue, assertfalse, assertequals
        //Assert.assertTrue();

        // Assert equal la tuyet doi
        // assertTrue contains la tuong doi
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));
        // muon dk k dung dung assertFalse
        Assert.assertFalse(driver.getPageSource().contains("Create new account"));

        // cac ham tra ve kieu du lieu boolean thi dung
        // quy tac: bat dau voi tien to la isXXX
        // WebElement
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();

        // mong doi dieu kien giong thuc te, tuyet doi
        // actual = expected
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
        Assert.assertEquals(driver.findElement(By.id("")).getText(),"lalala");

        //unit test
        Object name = null;
        Assert.assertNull(name);
        name = "Testing";
        Assert.assertNotNull(name);

    }
}
