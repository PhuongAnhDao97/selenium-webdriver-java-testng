package javaTester.javaOOP;

public class Student {
    private int studentId;
    private String studentName;
    private float theoreticalPoint;
    private float practicePoint;

    public Student(int studentId, String studentName, float theoreticalPoint, float practicePoint) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.theoreticalPoint = theoreticalPoint;
        this.practicePoint = practicePoint;
    }

    protected int getStudentId() {
        return studentId;
    }

    protected void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    protected String getStudentName() {
        return studentName;
    }

    protected void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    protected float getTheoreticalPoint() {
        return theoreticalPoint;
    }

    protected void setTheoreticalPoint(float theoreticalPoint) {
        this.theoreticalPoint = theoreticalPoint;
    }

    protected float getPracticePoint() {
        return practicePoint;
    }

    protected void setPracticePoint(float practicePoint) {
        this.practicePoint = practicePoint;
    }

    protected float getAveragePoint() {
        return (getTheoreticalPoint() + getPracticePoint()*2)/3;
    }

    protected void showStudentInfo() {
        System.out.println("Ma hoc sinh la: "+ getStudentId());
        System.out.println("Ho va Ten hoc sinh la: "+ getStudentName());
        System.out.println("Diem trung binh cua hoc sinh la: " + getAveragePoint() );
    }
}
