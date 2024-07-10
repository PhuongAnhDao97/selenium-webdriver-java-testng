package javaTester;

import org.testng.annotations.Test;
import java.util.Scanner;

public class Topic_04_Exercise {

    public static void main(String[] args) {


        // bai 1

          Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap ten:");
//        String name = scanner.nextLine();
//
//        System.out.println("Nhap tuoi:");
//        int age = scanner.nextInt();
//
//        System.out.println("After 15 years, age of " + name +" will be " + (age+15));


        // bai 2

//        System.out.println("Nhap a: ");
//        int a = scanner.nextInt();
//
//        System.out.println("Nhap b: ");
//        int b = scanner.nextInt();
//
//        int c = a;
//        a = b;
//        b = c;
//
//        System.out.println("After swaping then a = " + a+ " b = "+b);

        // bai 3

        System.out.println("Nhap a: ");
        int a = scanner.nextInt();

        System.out.println("Nhap b: ");
        int b = scanner.nextInt();

        boolean result = (a>b)? true : false;

        System.out.println(result);



    }








}
