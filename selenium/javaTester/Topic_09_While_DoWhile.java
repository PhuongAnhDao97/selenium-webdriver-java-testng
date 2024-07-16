package javaTester;

import java.util.Scanner;

// class
public class Topic_09_While_DoWhile {
// function
    public static void main(String[] args) {

         // block code
//        for (int i = 0; i < 5; i++) { // bien i sinh ra trong lap for, chi su dung trong vong lap for
//            System.out.println(i);
//        }
//
//        System.out.println("================================================");
//        int i = 0;
//        while (i < 5) {
//            System.out.println(i);
//            i++;
//        }
//
//        do {
//            System.out.println(i);
//            i++;
//
//        } while (i<5);



        // bai 2
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        while(n < b) {
//            if (n%3==0 && n%5==0){
//                System.out.println(n);
//            }
//            n++;
//        }


        // bai 3

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int i = 0;
//        int s = 0;
//        while (i <= n){
//            if (i%2== 1){
//                s = s + i;
//            }
//            i++;
//        }
//        System.out.println(s);


        // bai 4

//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        while(a < b) {
//            if (a%3==0){
//                System.out.println(a);
//            }
//            a++;
//        }

        // bai 5

//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int i = 1;
//        int s = 1;
//
//        while(i <= a) {
//            s= i*s;
//            i++;
//        }
//        System.out.println(s);

        // bai 6

        int x = 1;
        int H =0;

        while (x <= 10)
        {
            if (x%2==0){
                H += x;

            }
            x++;
        }
        System.out.println(H);
    }
}
