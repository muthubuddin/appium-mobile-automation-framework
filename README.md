# SwagLabs Appium Automation (Maven + TestNG + Page Object Model)

Appium automation framework for the **SwagLabs** Android app (`com.swaglabsmobileapp`).

## Project Structure

```
swaglabs-appium/
├── pom.xml
├── testng.xml
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BaseTest.java      # Driver setup/teardown + desired capabilities
│   │   └── pages/
│   │       └── LandingPage.java   # Page Object for the login/landing screen
│   └── test/java/
│       └── tests/
│           └── LoginTest.java     # Sample test using LandingPage
```

## Prerequisites

1. **Java JDK 11+** installed and on PATH
2. **Maven** installed (`mvn -v` to confirm)
3. **Appium server** running:
   ```cmd
   appium
   ```
4. **Android emulator** running (with SwagLabs app installed) and visible via:
   ```cmd
   adb devices
   ```

## Desired Capabilities (already set in `base/BaseTest.java`)

| Capability      | Value                                     |
|-----------------|--------------------------------------------|
| platformName    | Android                                    |
| automationName  | UiAutomator2                               |
| deviceName      | emulator-5554                              |
| udid            | emulator-5554                              |
| appPackage      | com.swaglabsmobileapp                      |
| appActivity     | com.swaglabsmobileapp.SplashActivity       |
| noReset         | true                                       |

If your emulator has a different device ID (check via `adb devices`), update the
`setDeviceName` / `setUdid` values in `BaseTest.java` accordingly.

## LandingPage locators

| Field         | XPath                                                                 |
|---------------|-------------------------------------------------------------------------|
| Username      | `//android.widget.EditText[@content-desc="test-Username"]`             |
| Password      | `//android.widget.EditText[@content-desc="test-Password"]`             |
| LOGIN button  | `//android.widget.TextView[@text="LOGIN"]`                             |

## Running the tests

From the project root:

```cmd
mvn clean test
```

This runs `testng.xml`, which executes `LoginTest`, filling in:
- Username: `standard_user`
- Password: `secret_sauce`

## Next steps

- Add a **ProductsPage** Page Object for post-login assertions (e.g. "PRODUCTS" title visible)
- Add TestNG assertions in `LoginTest` to verify successful login
- Add more test data cases (e.g. `locked_out_user`, `problem_user`) as separate `@Test` methods or via a `@DataProvider`
- For `locked_out_user`, add a locator for the error message banner and assert its text
