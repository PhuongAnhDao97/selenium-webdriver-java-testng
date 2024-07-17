package javaTester;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class Topic_12_Exercise {
//    public static void main(String[] args) {
//
//
//    }


    @Test
    public void TC_01() {
        String courseName = "Automation Testing Advanced";

        char[] courseNameArr = courseName.toCharArray();
        int count = 0;
        // upper case
        for (char character : courseNameArr) {
            if (character < 'Z' && character >= 'A') {
                count++;
            }
        }
        System.out.println(" tong so upercase = " + count);
        // lower case
        count = 0;
        for (char character : courseNameArr) {
            if (character < 'z' && character >= 'a') {
                count++;
            }
        }
        System.out.println(" tong so lowercase = " + count);
        // number
        count = 0;
        for (char character : courseNameArr) {
            if (character < '9' && character >= '0') {
                count++;
            }
        }
        System.out.println(" tong so number = " + count);
    }

    @Test
    public void TC_02() {

        String courseName = "Automation Testing 345 Tutorials Online 789";

        char[] courseNameArr = courseName.toCharArray();
        int count = 0;

        for (char character : courseNameArr) {
            if (character == 'a') {
                count++;
            }
        }
        System.out.println("tong so ki tu 'a' co trong chuoi la: " + count);
        System.out.println((courseName.contains("Testing")));
        System.out.println((courseName.startsWith("Automation")));
        System.out.println((courseName.endsWith("Online")));
        System.out.println((courseName.replace("Online", "Offline")));

        count = 0;

        for (char character : courseNameArr) {
            if (character >= '0' && character <= '9') {
                count++;
            }
        }
        System.out.println(count);


    }

    @Test
    public void TC_03() {

        String stringex = "Coding";

        byte[] strAsByteArray = stringex.getBytes();

        byte[] result = new byte[strAsByteArray.length];
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];

        System.out.println(new String(result));
    }




    @Test
    public void TC_04() {

    }
}
