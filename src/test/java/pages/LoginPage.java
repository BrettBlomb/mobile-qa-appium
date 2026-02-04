package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private final AppiumDriver driver;

    // Locators are centralized here for maintainability.
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login");

    public LoginPage(AppiumDriver driver) {
        // Page Objects make tests reusable and easier to scale.
        this.driver = driver;
    }

    public LoginPage typeUsername(String value) {
        // Clear + type reduces flaky state in CI.
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(value);
        return this;
    }

    public LoginPage typePassword(String value) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);
        return this;
    }

    public void tapLogin() {
        // Single-responsibility click action.
        driver.findElement(loginBtn).click();
    }
}
