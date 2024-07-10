package javaTester;

public class Topic_01_Data_Type {

    // global, ko can khoi tao van xai dc
    static int studentNumber;
    String address  = "Lina Smith";
    public static void main(String[] args) {
        // bien local phai khoi tao moi xai dc
        int studentNumber = 0;
        System.out.println(studentNumber);

        // bien k static muon xai dc phai new object
        Topic_01_Data_Type topic = new Topic_01_Data_Type();
        System.out.println(topic.address);


    }









    /**
     * kieu du lieu trong java: 2 nhom
     * I: kieu du lieu nguyen thuy primitive type
     *      8 loai
     *          so nguyen: byte - short - int - long
     *          so thuc: float - double
     *          ki tu: char
     *          logic: boolean
     * II: tham chieu reference type phai new moi dung dc
     *          String - chuoi ki tu
     *          Class : By, FirefoxDriver, Select, Topic_01_Da_Type
     *          Object: co the convert qua 1 kieu khac dc > class, string
     *          Array: co gia tri va dc khai bao truoc, nhung dung dc 1 kieu cho 1 mang thoi
     *          Collection: List(dc trung), Set(ko dc trung), Queue, Map??
     *          Interface
     *
     * Khai bao bien luu tru loai du lieu nao do
     * access modifier: pham vi truy cap (public/ private/ protected/ default)
     * kieu du lieu
     * ten bien
     * gai tri bien
     * int StudentNumber = 200;
     */
}
