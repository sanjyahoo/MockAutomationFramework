package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal();

    public static WebDriver initDriver(String browser) {
        if (driver.get() != null) {
            return driver.get();
        }

        if ("chrome".equals(browser.toLowerCase())) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if ("edge".equals(browser.toLowerCase())) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        } else {
            System.out.println("Browser not recognized. Defaulting to Chrome.");
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }

        driver.get().manage().window().maximize();
        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
