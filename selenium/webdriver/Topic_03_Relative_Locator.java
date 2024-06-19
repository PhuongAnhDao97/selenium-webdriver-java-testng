package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_03_Relative_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Relative_Locator() {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Flogin");
        // Login button

        By loginButtonBy = By.cssSelector("button.login-button");
        // hoac bang WebElement
        WebElement loginButtonElement = driver.findElement(By.cssSelector("button.login-button"));

        // remember me checkbox
        By rememberMeCheckboxBY = By.id("RememberMe");

        // forgot password link

        WebElement forgotPasswordElement = driver.findElement(By.cssSelector("span.forgot-password"));

        // password textbox

        By passwordTextboxBy = By.cssSelector("input#Password");

        // GUI (location/position)

        WebElement rememberMeTextElement = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)
                .toRightOf(rememberMeCheckboxBY)
                .toLeftOf(forgotPasswordElement)
                .below(passwordTextboxBy)
                .near(forgotPasswordElement));
        //RelativeLocator.with(By.tagName("label")).above(loginButtonElement);

        System.out.println(rememberMeTextElement.getText());
        List<WebElement> allLinks = driver.findElements(RelativeLocator.with(By.tagName("a")));
        System.out.println(allLinks.size());

    }


    @Test
    public void TC_02_() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
