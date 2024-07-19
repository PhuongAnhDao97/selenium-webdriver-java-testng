package javaTester.javaOOP;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.st;

public class Topic_02_Variables_Property_Method {

    // access modifier
    // data type
    // variable name

    // variable value
    // instance variable : goi ben ngoai pham vi class, la o clas khac
    // ben ngoai method, block, constructor

    // static variable
    public static String studentAddress = "Ho Chi Minh"; // dung va gan lai dc
    private static String studentPhone = "0987654321"; // dung trong class cho tat ca cac instance/ object

    // final variable
    final String contry = "Viet Nam"; // ko cho phep gan lai, co dinh ko dc phep thay doi


    // final static variable : hang so (constant)
    // ko dc ghi de
    // co the truy cap rong rai cho tat ca instance / thread
    static final float piNumber = 3.14f;

    private static String studentName = "Lina Smith"; // bien global: goi trong pham vi class

    int age = 14;


    public Topic_02_Variables_Property_Method(String studentName) {
        this.studentName = studentName; // local variable pham vi constructor
    }

    // ham - static
    public static void main(String[] args) {
        if (studentName.startsWith("Lina")){
            int number = 100; // local variable pham vi block code
        }

        studentAddress = "Da Nang";
        studentPhone = "0989654321";
    }

    // ham = non static
    public void display() {
        String studentName = "Lina Smith"; // bien local pham vi method


    }
}
