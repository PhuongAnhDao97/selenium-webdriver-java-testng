package javaTester;

public class Topic_08_Parameter {

    static String fullNameGlobal = "lina Smith";
    public static void main(String[] args) {
        setFullName("Kane");
        System.out.println(getFullName());
    }

    public static void setFullName(String fullName){ // tham so
        fullNameGlobal  = fullName;

    }

    public static String getFullName(){
        return fullNameGlobal;
    }
}
