package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * BaseTest sets up and tears down the AndroidDriver session before/after every test.
 * All test classes should extend this class to get access to the shared `driver`.
 */
public class BaseTest {

    protected AndroidDriver driver;

    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        // ---- Desired Capabilities ----
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");
        options.setUdid("emulator-5554");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.SplashActivity");
        options.setNoReset(true);

        // Extra stability capabilities (helpful if the app is slow to launch)
        options.setCapability("appium:appWaitActivity", "*");
        options.setCapability("appium:androidInstallTimeout", 90000);
        options.setCapability("appium:adbExecTimeout", 60000);

        driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
