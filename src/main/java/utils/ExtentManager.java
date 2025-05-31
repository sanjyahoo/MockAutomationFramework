package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private ExtentManager() {}

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            synchronized (ExtentManager.class) {
                if (extent == null) {
                    extent = new ExtentReports();
                    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
                    sparkReporter.config().setReportName("Automation Test Results");
                    sparkReporter.config().setDocumentTitle("Test Execution Report");

                    extent.attachReporter(sparkReporter);
                }
            }
        }
        return extent;
    }
}
