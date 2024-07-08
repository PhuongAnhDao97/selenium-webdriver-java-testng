package javaTester;

import java.util.ArrayList;
import java.util.List;

public class Topic_13_Java_Generic {

    public static void main(String[] args) {

        // list chi chua kieu du lieu la String
        List<String> students = new ArrayList<String>();
        students.add("John");
        students.add("Mary");
        students.add("Peter");
        students.add("Nam");


        // non - generic
        ArrayList  addresses = new ArrayList<>();

        addresses.add("123 Main St.");
        addresses.add(15);
        addresses.add(true);
        addresses.add(15.7);

        // generic la rang buoc voi 1 kieu du lieu
        // E T V K L : dai dien cho kieu du lieu cua element

    }
}
