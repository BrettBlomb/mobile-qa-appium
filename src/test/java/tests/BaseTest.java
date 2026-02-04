package tests;

import framework.driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        // Create a fresh session per test for reliability in CI.
        driver = DriverFactory.create();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // Always quit to avoid leaking sessions on failures.
        if (driver != null) {
            driver.quit();
        }
    }
}
