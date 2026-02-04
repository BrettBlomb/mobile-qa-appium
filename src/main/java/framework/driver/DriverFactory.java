package framework.driver;

import framework.config.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {

    // Creates an AppiumDriver based on the "platformName" system property.
    public static AppiumDriver create() {
        try {
            String platformName = Config.get("platformName", "ANDROID").toUpperCase();
            String deviceName = Config.get("deviceName", "Android Emulator");
            String appiumUrl = Config.get("appiumUrl", "http://127.0.0.1:4723");
            String appPath = Config.get("appPath", "apps/android-debug.apk");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", platformName);
            caps.setCapability("deviceName", deviceName);
            caps.setCapability("app", appPath);

            // Keeps sessions more stable in CI.
            caps.setCapability("newCommandTimeout", 120);

            if (platformName.equals("ANDROID")) {
                // Android-specific capabilities.
                caps.setCapability("automationName", "UIAutomator2");
                caps.setCapability("appWaitActivity", "*");
                return new AndroidDriver(new URL(appiumUrl), caps);
            }

            if (platformName.equals("IOS")) {
                // iOS-specific capabilities.
                caps.setCapability("automationName", "XCUITest");
                // Example: for simulators you typically also set platformVersion, udid, etc. later.
                return new IOSDriver(new URL(appiumUrl), caps);
            }

            throw new IllegalArgumentException("Unsupported platformName: " + platformName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Appium driver", e);
        }
    }
}
