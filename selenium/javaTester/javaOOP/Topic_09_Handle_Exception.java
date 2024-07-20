package javaTester.javaOOP;

public class Topic_09_Handle_Exception {

    public static void main(String[] args) {
//        int number = 10;
//
//        try {
//            // dung thi chay het doan code trong try ma k qua catch
//            // sai : exception > catch
//            number = number / 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        System.out.println(number);
//
//        String[] browserName = {"Chrome", "Firefox", "Safari"};
//
//        try {
//            browserName[0] = "Edge";
//            browserName[3] = "Edge";
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
//
//        for (String brow : browserName) {
//            System.out.println(brow);
//        }


        try {
            int array[] = new int[10];
            array[10] = 30 / 1;
        } catch (ArithmeticException e) {
            System.out.println("ko the chia cho 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ko ton tai index");
        }


        

    }
}
