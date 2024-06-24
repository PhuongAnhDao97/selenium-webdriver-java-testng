package javaTester;

public class Topic_07_String {
    public static void main(String[] args) {
        String firstName = "Lina";
        String lastName = "Smith";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        fullName = firstName.concat(" ").concat(lastName);
        System.out.println(fullName);

        String ABC = "Welcome "+ fullName + " to ABC company";
        System.out.println(ABC);
    }
}
