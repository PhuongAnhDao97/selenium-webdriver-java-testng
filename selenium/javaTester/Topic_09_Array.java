package javaTester;

public class Topic_09_Array {
    int[] studenAge = {15,10,20,22};

    // vua khai bao vua gan
    static  String[] studentName = {"Nguyen Van A", "Le Thi B"};



    public static void main(String[] args) {
        // khai bao do dai trc r gan sau
        String[] studentAddress = new String[5];
        studentAddress[0] = "Le Thi Be Hai";
        studentAddress[1] = "Le Thi Be";
        studentAddress[2] = "Le Thi Hai";
        studentAddress[3] = "Le Thi";
        studentAddress[4] = "Le";

        System.out.println(studentAddress[3]);

        for (String a : studentAddress){
            System.out.println(a);
        }

        for (int i = 0; i < studentAddress.length; i++) {
            System.out.println(studentAddress[i]);

        }

        System.out.println(studentName[0]); // neu muon truy cap bien trong ham main statis thi bien do p static


        // neu k phai new mot doi tuong chua no
        Topic_09_Array topic = new Topic_09_Array();

        // doi tuong chua no co the truy cap vao no
        System.out.println(topic.studenAge[0]);


        System.out.println();
    }


}
