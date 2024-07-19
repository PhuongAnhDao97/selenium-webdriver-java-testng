package javaTester.javaOOP;

public class Topic_04_Non_Access_Modifier {

    // static : anh huong variable and method
    // dc sinh ra khi chuong trinh dc bat va huy khi chuong trinh dong
    // dung cho tat ca cac instance/ object
    // pham vi toan bo system su dung
    // co the override dc
    static  String BROWSER = "Chrome";
    // ham static
    public static void main(String[] args) {
        System.out.println(BROWSER);
        // static way: truy cap thong qua ham static goi truc tiep, or thong qua class

        Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();

        topic.clickToElement("Button");
        sendKeyToElement("Button");

    }

    public  void clickToElement(String elementName){

        System.out.println(elementName);
    }

    // mot ham static co the goi truc tiep den 1 ham static khac trong cung class
    // ngoai class thi truy cap truc tiep tu ten class k can khoi tao instance
    // nen dung de khoi tao cac class, che giau viec khoi tao doi tuong
    public  static  void sendKeyToElement(String elementName){

        System.out.println(elementName);
    }

    public  final void setCarName(){
        System.out.println("setCarName");
    }

}
