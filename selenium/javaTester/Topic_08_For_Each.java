package javaTester;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Topic_08_For_Each {


    @Test
    public void TC_01() {

        //
//        System.out.println(1);
//        System.out.println(2);
//        System.out.println(3);
//        System.out.println(4);
//        System.out.println(5);
//        System.out.println(6);
//        System.out.println(7);
//        System.out.println(8);
//        System.out.println(9);
//        System.out.println(10);
//    }


        // for i
        // bien tam: dung de tang gia tri len sau moi lan duyet
        // dung de so sanh voi tong gia tri
        // ve 2 so sanh voi tong
        // tang i len 1 don vi sau khi chay vao than vong for
        for (int i = 1; i <= 10; i++) {

            System.out.println(i);
        }


        // Array/ list/ set/ queue thi index bat dau bang 0 > nen dung i = 0

        // dung for de chay qua het tat ca gia tri
        // for if chi dung khi thoa man dk gi do


        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};

        for (int i = 0; i < cityName.length; i++){

            System.out.println(cityName[i]);

        }

        System.out.println("=====================");

        // for each

        for (String city : cityName){
            System.out.println(city);
        }

        System.out.println("=====================");
        // for if

        for (int i = 0; i < cityName.length; i++){

            if (cityName[i].equals("Ha Noi")){
                System.out.println(cityName[i]);
                break; // dung break thi chay tim thay thoat va k kiem tra nua
            }

        }

        // java collection
        // Class: ArrayList / LinkedList / Vector
        // Interface: List/ Set/ Queue

        List<String> cityAddresses = new ArrayList<String>();

        // compile (coding)
        cityAddresses.add("Ha Giang"); // them luc viet code
        cityAddresses.add("Ha Noi"); // them luc viet code
        cityAddresses.add("Ha Tinh"); // them luc viet code

        // Runtime ( Running) // add luc dang chay
        for (String city : cityName) {
            cityAddresses.add(city);
        }

        System.out.println(cityAddresses.size());




    }
}
