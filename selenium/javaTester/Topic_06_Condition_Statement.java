package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {

    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }


@Test
public  void TC_01_If(){


    boolean status = 5>3;
    // ham if nhan vao 1 dkdung thi vao phan than if , sai thi bo qua
    // kiem tra duy nhat 1 dk
    if (status){

    }
    // assign : phep gan
    int studentNumber = 10;

    // compare
    status = (studentNumber==10);
    System.out.println(status);

    WebDriver driver;
    driver = new FirefoxDriver();
    WebElement languageCheckbox = driver.findElement(By.id(""));

    // uncheck to checkbox
    if (languageCheckbox.isSelected()){
        languageCheckbox.click();
    }

    // ham check to checkbox

    if (!languageCheckbox.isSelected()){
        languageCheckbox.click();
    }


}


@Test
public void TC_02_If_Else(){

    // if - else co toi 2 dk, dung thi vao if sai thi vao else

    // ko nen if else qua nhieu , nhin code xau va kho maintain

    System.out.println(driver);

    System.out.println(driver);
    if(driver.toString().contains("firefox")){
        System.out.println(" use click by javascript");

    } else{
        System.out.println(" use click by selenium");

    }

}


    @Test
    public void TC_03_If_Else_If_Else(){



    }
}
