package base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.ExtentManager;

public class BaseTest {

    protected ExtentReports extent;
    protected ExtentTest test;
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browserName) {
        driver = DriverFactory.initDriver(browserName);
    }


    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getExtentReports();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        DriverFactory.initDriver(browser);
        test = extent.createTest("Default Test Name");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
