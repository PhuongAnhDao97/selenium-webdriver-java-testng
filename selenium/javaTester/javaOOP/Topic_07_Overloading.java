package javaTester.javaOOP;

public class Topic_07_Overloading {

    private int firstNumber;
    private int secondNumber;

    public  void sumNumber(){
        System.out.println(this.firstNumber + this.secondNumber);
    }

    public  void sumNumber(int firstNumber , int secondNumber){
        System.out.println(this.firstNumber + this.secondNumber);
    }

    public  void sumNumber(float firstNumber , float secondNumber){
        System.out.println(this.firstNumber + this.secondNumber);
    }

    public  void sumNumber(int firstNumber , float secondNumber){
        System.out.println(this.firstNumber + this.secondNumber);
    }

    public static void main(String[] args) {

        Topic_07_Overloading topic = new Topic_07_Overloading();
        topic.sumNumber(6,7);
    }
}
