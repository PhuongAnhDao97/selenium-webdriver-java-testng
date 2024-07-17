package javaTester.javaOOP;

public class Person {
    private String personName;
    // nested class , inner class
    public class Pupil{
        String name = "";

    }

    public static void main(String[] args) {
        Person person = new Person();
        // Person la class
        // person la instance. object
        person.personName = "";

        Person.Pupil pupil = person.new Pupil();
        pupil.name = "";

    }
}
