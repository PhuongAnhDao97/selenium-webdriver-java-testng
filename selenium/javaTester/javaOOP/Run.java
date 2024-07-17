package javaTester.javaOOP;

public class Run {

    public static void main(String[] args) {

        Student student1 = new Student(001, "Nguyen Van Khanh", 10, 10);
        Student student2 = new Student(002, "Huynh My", 8, 4);
        Student student3 = new Student(003, "Nguyen Van Khanh", 9, 10);

        student1.showStudentInfo();
        student2.showStudentInfo();
        student3.showStudentInfo();

    }
}
