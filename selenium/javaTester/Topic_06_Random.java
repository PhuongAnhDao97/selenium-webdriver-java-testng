package javaTester;

import java.util.Random;

public class Topic_06_Random {
    // java builtin cung cap san chi lay ra sd

    // java libraries do 1 ca nhan to chuc viet, su dung lai

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt(99999));  // bound: 0-999

        System.out.println("linasmith" + new Random().nextInt(99999) + "@gmail.com");
        System.out.println("linasmith" + new Random().nextInt(99999) + "@gmail.com");
        System.out.println("linasmith" + new Random().nextInt(99999) + "@gmail.com");


    }
}
