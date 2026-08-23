package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * LandingPage represents the Login / Landing screen of the SwagLabs app.
 * Contains locators and reusable actions (Page Object Model).
 */
public class LandingPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    // ---- Locators ----
    private final By userNameField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    private final By passwordField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private final By loginButton = AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]");

    public LandingPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ---- Actions ----

    /**
     * Enters the given username into the Username field.
     */
    public LandingPage enterUserName(String userName) {
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        userNameElement.clear();
        userNameElement.sendKeys(userName);
        return this;
    }

    /**
     * Enters the given password into the Password field.
     */
    public LandingPage enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        return this;
    }

    /**
     * Taps the LOGIN button.
     */
    public void clickLoginButton() {
        WebElement loginElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginElement.click();
    }

    /**
     * Convenience method to enter both username and password in one call.
     */
    public LandingPage enterCredentials(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        return this;
    }

    /**
     * Full login flow: enters credentials and taps LOGIN.
     */
    public void login(String userName, String password) {
        enterCredentials(userName, password);
        clickLoginButton();
    }
}
