package javaTester.javaOOP;

public class Topic_06_Getter_Setter {
    private String personName;
    private int personAge;
    private int personPhone;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        if (personName != null && !personName.isEmpty() && !personName.isBlank()) {
            this.personName = personName;
        } else {
            throw new IllegalStateException("invalid person name");
        }

    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        if (personAge > 0 && personAge < 120) {
            this.personAge = personAge;
        } else {
            throw new IllegalStateException("invalid person age");
        }
    }

    public int getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(int personPhone) {
        this.personPhone = personPhone;
    }

    public void showPersonInfo() {
        System.out.println(getPersonName());
        System.out.println(getPersonAge());
        System.out.println(getPersonPhone());
    }

    public static void main(String[] args) {

    }
}
