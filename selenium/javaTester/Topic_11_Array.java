package javaTester;

import java.util.ArrayList;
import java.util.Arrays;

public class Topic_11_Array {
    public static void main(String[] args) {
        // mang tap hop nhung kieu du lieu giong nhau

        // khia bao mang
        // mang 1 chieu
        int number[] = {1,2,3,4,5,6,7};
        int[] student ={1,2,3,4,5,6,7};

        // lay ra phan tu cua mang
        System.out.println(number[0]);
        System.out.println(number[1]);
        System.out.println(number[6]);


        String[] studentNames = {"An","Nam","Long"};
        System.out.println(studentNames[2]);

        int b[] = new int[5];
        b[0] = 10;
        // co the gan de dc
        b[0] = 15;

        for (int i = 0; i < studentNames.length; i++) {
            System.out.println(studentNames[i]);
        }

        // for each co nhuoc diem la k kiem tra dieu kien dc
        // thuong dung de duyet qua tat ca cac dieu kien
//        for(String std : studentNames) {
//            System.out.println(std);
//        }


        // truong hop dong
        ArrayList<String> sdtName = new  ArrayList<String>();

        for(String std : studentNames) {
            sdtName.add(std);
        }


        // clone mang
        String[] stdName = studentNames.clone();
        // chuyen mang thanh chuoi
        String std_Name = Arrays.toString(stdName);

        System.out.println(std_Name);

        // [An, Nam, Long]

        // mang object: mang doi tuong (chua dc doi tuong la reference

    }
}
