package javaTester;

import org.bouncycastle.oer.Switch;
import org.zeromq.ZContext;

import java.util.Scanner;

public class Topic_10_Break_Continue {
    public static void main(String[] args) {
        // continue: loai tru bo qua
        // continue chi anh huong den vong for no dang dung k =anh huong toi nhung vong for khc
//        for (int i = 0; i < 10; i++) {
//            if (i==5){
//                continue;
//            }
//            System.out.println(i);
//        }

        // bai 2

        System.out.println(" nhap vao so thang");

        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();

        switch (i){
            case 1:
                System.out.println("JAN");
                break;
            case 2:
                System.out.println("FEB");
                break;
            case 3:
                System.out.println("MAR");
                break;
            case 4:
                System.out.println("APR");
                break;
            case 5:
                System.out.println("MAY");
                break;
            case 6:
                System.out.println("JUN");
                break;
            case 7:
                System.out.println("JUL");
                break;
            case 8:
                System.out.println("AUG");
                break;
            case 9:
                System.out.println("SEP");
                break;
            case 10:
                System.out.println("OCT");
                break;
            case 11:
                System.out.println("NOV");
                break;
            case 12:
                System.out.println("DEC");
                break;

        }


    }
}
