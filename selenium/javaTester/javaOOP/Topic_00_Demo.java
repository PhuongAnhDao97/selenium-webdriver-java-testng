package javaTester.javaOOP;

public class Topic_00_Demo {

    public static void main(String[] args) {
        Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();

        topic.setPersonName("Lina");
        topic.setPersonAge(15);
        topic.setPersonPhone(987654321);

        topic.showPersonInfo();

    }
}
