package javaTester;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_04_Operator {


    public static void main(String[] args) {


        int number = 10;
        number += 5;

        System.out.println(number);

        // number = 15
        System.out.println(number/5);
        System.out.println(number%7);


        // cho phep thuc hien hanh dong di trc r cong sau in ra 15 trc r cong sau la 16
        System.out.println(number++);
        // tang number len 1 tuc la 17 roi moi in ra
        System.out.println(++number);
        System.out.println(number--);

        int firstValue = 5;
        int secondValue = 7;
        int result = firstValue++ + ++secondValue - 8;

        System.out.println("First value" + firstValue);
        System.out.println("Second value" + secondValue);
        System.out.println("Result" + result);


        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }

        // relation dung trong If, AssertTrue, AssertFalse

        if (true){

        }

        Assert.assertTrue(false);
        Assert.assertFalse(false);

        // ! : dung de phu dinh thuong dung trong if ! element is selected

        // bieu thuc tam nguyen









    }



}
