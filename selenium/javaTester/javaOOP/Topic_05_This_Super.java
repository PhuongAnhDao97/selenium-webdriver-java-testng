package javaTester.javaOOP;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Topic_05_This_Super extends Topic_00_Demo {

    private WebDriver driver;
    private int firstNumber;
    private int secondNumber;
    private long shortTimeout = 15;
    private long longTimeout = 45;

    public Topic_05_This_Super(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void sumNumber() {
        System.out.println(firstNumber+secondNumber);
    }

    public void setImplicitWait(){
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(super.longTimeout));
    }

    public static void main(String[] args) {
        Topic_05_This_Super topic = new Topic_05_This_Super(15, 7);



    }
}
