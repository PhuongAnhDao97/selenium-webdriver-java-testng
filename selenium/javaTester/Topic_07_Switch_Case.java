package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Topic_07_Switch_Case {
    WebDriver driver;

    @Parameters("browser")
    @Test
    public void TC_01_(String browserName) {
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
            case "chrome":
                driver = new ChromeDriver();
            case "edge":
                driver = new EdgeDriver();
            default:
                new RuntimeException("please input correct driver");
                break;
        }

        driver.get("https://www.facebook.com/");
        System.out.println(driver);

        driver.quit();

    }


    @Test
    public void TC_02_() {

        // chay trong ham main
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap thang");
        int x = scanner.nextInt();

        switch (x){
            case 1:
                System.out.println("co 31 ngay");
                break;
            case 2:
                System.out.println("co 28 hoac 29 ngay");
                break;
            case 3:
                System.out.println("co 31 ngay");
                break;
            case 4:
                System.out.println("co 30 ngay");
                break;
            case 5:
                System.out.println("co 31 ngay");
                break;
            case 6:
                System.out.println("co 30 ngay");
                break;
            case 7:
                System.out.println("co 31 ngay");
                break;
            case 8:
                System.out.println("co 31 ngay");
                break;
            case 9:
                System.out.println("co 30 ngay");
                break;
            case 10:
                System.out.println("co 31 ngay");
                break;
            case 11:
                System.out.println("co 30 ngay");
                break;
            case 12:
                System.out.println("co 31 ngay");
                break;
            default:
                System.out.println("error");
                break;

        }

    }

    @Test
    public void TC_03_(){
        // chay trong ham main
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap so");
        int x = scanner.nextInt();

        switch (x){
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
            default:
                System.out.println("error");
                break;

        }

    }

    @Test
    public void TC_04_(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap phep toan");
        String math = scanner.nextLine();

        System.out.println("Nhap a = ");
        int a = scanner.nextInt();

        System.out.println("Nhap b = ");
        int b = scanner.nextInt();

        switch (math) {
            case "+":
                System.out.println("Tong 2 so la :" + (a + b));
                break;
            case "-":
                System.out.println("Hieu 2 so la :" + (a - b));
                break;
            case "*":
                System.out.println("Tich 2 so la :" + (a * b));
                break;
            case "/":
                System.out.println("Thuong 2 so la :" + (a / b));
                break;
        }

    }

    // ham tra ve driver, c return thi k can dung break
    public WebDriver getBrowserDriver(String browserName) {
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                new RuntimeException("please input correct driver");
                break;
        }

        return driver;
    }




}
