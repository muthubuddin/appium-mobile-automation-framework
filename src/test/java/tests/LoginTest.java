package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LandingPage;

/**
 * LoginTest verifies the Landing (login) page fields can be filled in
 * with the standard SwagLabs test credentials.
 */
public class LoginTest extends BaseTest {

    @Test
    public void testStandardUserLogin() {
        LandingPage landingPage = new LandingPage(driver);

        // Enters username + password, then taps LOGIN
        landingPage.login("standard_user", "secret_sauce");

        // TODO: add assertions here once you have a ProductsPage object,
        // e.g. verifying the products list / "PRODUCTS" title is visible.
    }
}
