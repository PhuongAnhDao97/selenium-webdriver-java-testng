package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Scope {
    WebDriver driver; // khai bao
    // cac bien dc khai bao ngoai ham > pham vi class
    // bien Global (toan cuc)
    // dung cho tat ca ham trong 1 class
    String homPageUrl;  // chi khai bao Declare
    String fullName = "Lina Smith"; // khai bao va khoi tao Initial

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver(); // khoi tao
    }

    @Test
    public void TC_01_() {
        // bien dc khai bao trong ham/ block code > bien cuc bo (local)
        // chi dung trong ham kahi bao/ block code sinh ra
        String homePageUrl = "";
        // trong 1 ham neu co 2 bien cung ten, 1 global va 1 local > uu tien local su dung
        // 1 bien local neu nhu goi toi dung ma chua dc init thi se bi loi ngay (trong qua trinh compile code)
        driver.get(homePageUrl);

        // neu trong 1 ham 2 bien cung ten , ma muon lay bien global > su dung tu khoa this
        // bien global chua init ma goi ra dung, ko bao loi level (compile code)
        // level runtime se loi
        driver.get(this.homPageUrl);
    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {

    }

    @Test
    public void TC_04_() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
