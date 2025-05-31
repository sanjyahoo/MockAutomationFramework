package Listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.ScreenshotUtils;

public class TestNGListener implements ITestListener {

        private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
        private static ExtentReports extent;

        public void onStart(ITestContext context) {
            extent = ExtentManager.getExtentReports();
        }

        public void onTestStart(ITestResult result) {
            ExtentTest test = extent.createTest(result.getMethod().getMethodName());
            extentTest.set(test);
        }

        public void onTestSuccess(ITestResult result) {
            extentTest.get().log(Status.PASS, "Test passed");
        }

        public void onTestFailure(ITestResult result) {
            extentTest.get().log(Status.FAIL, "Test failed: " + result.getThrowable());

            String screenshotPath = ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());
            extentTest.get().addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
        }

        public void onTestSkipped(ITestResult result) {
            extentTest.get().log(Status.SKIP, "Test skipped");
        }

        public void onFinish(ITestContext context) {
            extent.flush();
        }
}
