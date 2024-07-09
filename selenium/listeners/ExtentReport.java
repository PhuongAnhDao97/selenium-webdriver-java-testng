package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReport implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Attach message to report");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("take screenshot and attach to report");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Attach skip message to report");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Action before class");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Action after class");
    }
}
