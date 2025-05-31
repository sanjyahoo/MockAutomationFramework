package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://www.facebook.com/login");

        loginPage.login("invalidUser", "wrongPassword");
        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains("Invalid credentials"), "Error message mismatch");
    }
}
