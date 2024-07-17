package javaTester;

public class Topic_11_exercise {

    int ID;
    String name;
    int age;
    float score;

    public Topic_11_exercise(int ID, String name, int age, float score) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void display() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
    }


    public static void main(String[] args) {

//        int number[] = {5,8,3,21,63,6,39};

        // bai 1

//
//        int x = 0;
//
//        for (int i = 0; i < number.length; i++) {
//            if (x < number[i]) {
//                x = number[i];
//            }
//        }
//
//        System.out.println(" max number  = " + x);


        // bai 2

//
//        int x;
//
//        x = number[0] + number[number.length-1];
//
//        System.out.println("tong cua phan tu dau tien va cuoi cung la " +x);

        // bai 3

//        for (int i = 0; i < number.length; i++) {
//            if (number[i]%2 == 0){
//                System.out.println(number[i]);
//            }
//        }

        // bai 4 : tong cac so le > 0

//        int x = 0;
//        for (int i = 0; i < number.length; i++) {
//
//            if (number[i]%2==1 && number[i] > 0){
//                x +=number[i];
//            }
//
//        }
//        System.out.println(x);


        // bai 6
//        int tong = 0;
//        float tbc = 0;
//
//        for (int i = 0; i < number.length; i++) {
//            tong += number[i];
//        }
//
//        tbc = (float) tong /(number.length);
//
//        System.out.println("tong la: " + tong);
//        System.out.println("tbc la: " + tbc);

        // bai 7

        Topic_11_exercise[] topic = new Topic_11_exercise[3];
        topic[0] = new Topic_11_exercise(001, "Hoa", 23, 8);
        topic[1] = new Topic_11_exercise(002, "Tuan", 13, 2);
        topic[2] = new Topic_11_exercise(003, "Khanh", 12, 10);

        for (int i = 0; i < 3; i++) {
            topic[i].display();
        }

    }
}
