package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_12_String {
    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = s1;
        String s3 = new String("cat");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        // tham chieu dung equals

        String schoolName = "Nguyen Thi Minh Khai";
        String schoolAddress = "Soc Trang";

        // do dai chuoi
        System.out.println("Do dai cua chuoi: "+ schoolName.length());

        // lay ra 1 ki tu
        System.out.println("Lay ra 1 ki tu: "+schoolName.charAt(0));
        System.out.println("Noi 2 chuoi "+schoolName.concat(schoolAddress));
        System.out.println("ki tu tu vi tri "+schoolName.charAt(3));
        System.out.println("so sanh chuoi tuyet doi "+schoolName.equals(schoolAddress));
        System.out.println("so sanh chuoi tuong doi doi "+schoolName.contains("nguyen"));
        System.out.println("so sanh chuoi tuyet doi "+schoolName.equalsIgnoreCase("nguyen thi minh khai"));
        System.out.println(schoolName.substring(11, 15));

        // split: tach chuoi thanh mang dua vao 1 ki tu or chuoi ki tu
        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" ");
        System.out.println(results[1]);

        // replace
        String productPrice = "$100.00";
        productPrice = productPrice.replace("$", "");
        System.out.println(productPrice);
        // sap xep : sort data { desc asc }
        float productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF);

        //float convert qua chuoi
        productPrice = String.valueOf(productPriceF);
        System.out.println(productPrice);

        String osName = System.getProperty("user.dir");
        System.out.println(osName);


        System.out.println(osName.toUpperCase());
        System.out.println(osName.toLowerCase());

        // trim : cat chuoi
        // khoang trang, xuong dong , tab
        String helloWorld = "     \n    \t    Hello World           ";
        System.out.println(helloWorld.trim());

        // convert
        // ham Parse Int Float






    }
}
