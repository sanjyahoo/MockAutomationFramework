package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String captureScreenshot(String testName) {
        WebDriver driver = DriverFactory.getDriver();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = "test-output/screenshots/" + testName + ".png";

        try {
            Files.createDirectories(Paths.get("test-output/screenshots/"));
            Files.copy(srcFile.toPath(), Paths.get(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destPath;
    }
}
