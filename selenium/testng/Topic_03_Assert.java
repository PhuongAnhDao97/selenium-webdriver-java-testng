package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Assert {
    WebDriver driver;

    @Test
    public void test01(){


        // Equals kiem tra 2 du lieu bang nhau (Actual, expected)
        // string boolean int float
        String fullName = "Automation";

        Assert.assertEquals(fullName, "Automation VG", "Actual fullname is not the same as expected");

        // True - False
        // dieu kien nhan vao la boolean
        // isdisplayed, islelected, isenalbled, ismultipled, user-defined

        // mong doi ket qua tra ve la dung
        Assert.assertTrue(isElementDisplayed(By.cssSelector("")));
        Assert.assertTrue(isElementDisplayed(By.cssSelector("")), "Element is not displayed"); // message trong truong hop co loi


        // mong doi ket qua tra ve la sai
        Assert.assertFalse(isElementDisplayed(By.cssSelector("")));
        Assert.assertFalse(isElementDisplayed(By.cssSelector("")), "Element is not displayed");

    }

    private boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

}
