package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Topic_06_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    public static void main(String[] args) {
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

    @Test
    public void TC_01_() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap n = ");
        int n = scanner.nextInt();

        if (n % 2 == 0) {
            System.out.println("n la so chan");
        } else {
            System.out.println(" n la so le");
        }
    }


    @Test
    public void TC_02_() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap a: ");
        int a = scanner.nextInt();

        System.out.println("Nhap b: ");
        int b = scanner.nextInt();

        if (a >= b) {
            System.out.println("a > = b");
        } else {
            System.out.println(" a < b");
        }

    }

    @Test
    public void TC_03_() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten thu 1: ");
        String a = scanner.nextLine();

        System.out.println("Nhap ten thu 2: ");
        String b = scanner.nextLine();

        // equal dung cho relation variable
        // kiem tra gia tri cua bien va vung nho cua bien
        if (a.equals(b)) {
            System.out.println(" ten 2 nguoi giong nhau");
        } else {
            System.out.println("ten 2 nguoi khac nhau");
        }
    }


    @Test
    public void TC_04_() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap a: ");
        int a = scanner.nextInt();

        System.out.println("Nhap b: ");
        int b = scanner.nextInt();

        System.out.println("Nhap c: ");
        int c = scanner.nextInt();

        if (a > b && a > c) {
            System.out.println(" a la so lon nhat");
        } else if (b > a && b > c) {
            System.out.println(" b la so lon nhat");
        } else if (c > a && c > b) {
            System.out.println(" c la so lon nhat");
        }
    }


    @Test
    public void TC_05_() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap a: ");
        int a = scanner.nextInt();

        if (a > 10 && a < 100) {
            System.out.println("a nam trong doan [10,100]");
        } else {
            System.out.println("a khong nam torng doan [10,100]");
        }
    }

    @Test
    public void TC_06_() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap diem hoc sinh: ");
        int x = scanner.nextInt();

        if (x <= 10 && x >= 8) {
            System.out.println("A");
        } else if (x < 8.5 && x >= 7.5) {
            System.out.println("B");
        } else if (x < 7.5 && x >= 5) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
    }

    @Test
    public void TC_07_() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thang: ");
        int x = scanner.nextInt();

        List<Integer> thang31ngay = List.of(1, 3, 5, 7, 8, 10, 12);

        if (thang31ngay.contains(x)) {
            System.out.println("Thang "+x+" co 31 ngay");
        } else if (x == 2) {
            System.out.println("Thang co 28 hoac 29 ngay");
        } else {
            System.out.println("Thang co 30 ngay");
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
