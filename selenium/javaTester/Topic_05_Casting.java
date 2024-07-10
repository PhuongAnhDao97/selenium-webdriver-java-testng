package javaTester;

public class Topic_05_Casting {

    public static void main(String[] args) {

        // implicit: ko mat du lieu
        byte b = 126;
        System.out.println(b);
        short s = b;
        System.out.println(s);
        int i = s;
        System.out.println(i);
        long l = i;
        System.out.println(l);
        float f = l;
        System.out.println(f);
        double d = f;
        System.out.println(d);


        // explicit tuong minh > mat du lieu


        double dNumber = 876543217;
        System.out.println(dNumber);
        float fNumber = (float) dNumber;
        System.out.println(fNumber);
        long lNumber = (long) fNumber;
        System.out.println(lNumber);
        int iNumber = (int) lNumber;
        System.out.println(iNumber);
        short sNumber = (short) iNumber;
        System.out.println(sNumber);
        byte bNumber = (byte) sNumber;
        System.out.println(bNumber);


        // reference casting









    }

}
