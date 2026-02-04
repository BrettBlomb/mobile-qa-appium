package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void login_happyPath() {
        // Example UI flow; swap for your app’s real assertions.
        LoginPage login = new LoginPage(driver);
        login.typeUsername("demo")
             .typePassword("demo123");
        login.tapLogin();

        // TODO: Add assertion for post-login state (home screen element visible, etc.)
    }
}
