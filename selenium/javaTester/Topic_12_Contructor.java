package javaTester;

public class Topic_12_Contructor {


    public Topic_12_Contructor (String name){
        System.out.println(name);
    }

    public Topic_12_Contructor (int age){
        System.out.println(age);
    }

    public Topic_12_Contructor (int age, String name){
        System.out.println(age + name);
    }


    public static void main(String[] args) {

        // 1 class neu k co 1 contructor cu the thi no se co 1 contructor default rong(empty)

        // contructor la 1 ham cung ten voi class

        // ko co kieu du lieu tra ve
        // trong 1 class co the co nhieu contructor

        // neu minh define khi khoi tao no bat buoc p goi toi contructor minh define chu k goi den contructor rong nua

        // dai dien cho tinh da hinh thai




        Topic_12_Contructor topic01 = new Topic_12_Contructor("ABC");
        Topic_12_Contructor topic02 = new Topic_12_Contructor(13);


    }
}
