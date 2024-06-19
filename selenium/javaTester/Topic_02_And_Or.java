package javaTester;

public class Topic_02_And_Or {

    public static void main(String[] args) {
        //mem 1
        boolean member01;

        // mem2
        boolean member02;

        // result
        boolean result;


        // AND
        member01 =true;
        member02 = true;
        System.out.println("result = " + (member02 && member01));

        member01 =true;
        member02 = false;
        System.out.println("result = " + (member02 && member01));

        member01 =false;
        member02 = true;
        System.out.println("result = " + (member02 && member01));

        member01 = false;
        member02 = false;
        System.out.println("result = " + (member02 && member01));

        // OR
        member01 =true;
        member02 = true;
        System.out.println("result = " + (member02 || member01));

        member01 =true;
        member02 = false;
        System.out.println("result = " + (member02 || member01));

        member01 =false;
        member02 = true;
        System.out.println("result = " + (member02 || member01));

        member01 = false;
        member02 = false;
        System.out.println("result = " + (member02 || member01));


        //NOT

        /**
         * laty the input type k p textbox
         * //input[not(@type='text')]
         * //input[not(@type='hidden')]
         */

    }
}
