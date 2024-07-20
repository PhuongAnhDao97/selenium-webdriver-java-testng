package javaTester.javaOOP;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Topic_08_Handle_Exception {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
         //complier time > checked exception
         //String fullName = 15;
        File file = new File("D:\testing.txt");
        FileOutputStream fileOS = new FileOutputStream(file);

        // FileNotFoundException
        Thread.sleep(5);

        // chu yeu xu li runtime exception > unchecked exception

        WebDriver driver = null;
        driver.get("");

         //NullPointerException

        String[] browserNames = {"Chrome", "Firefox", "IE"};

        System.out.println(browserNames[0]);
        System.out.println(browserNames[1]);
        System.out.println(browserNames[2]);
        System.out.println(browserNames[3]);

         //ArrayIndexOutOfBoundsException

        int number = 15/0;

        System.out.println(number);

         //ArithmeticException loi chia cho 0




    }
}
