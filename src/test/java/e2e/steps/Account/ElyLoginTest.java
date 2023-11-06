package e2e.steps.Account;

import org.junit.jupiter.api.*;

import e2e.fixtures.TestBase;
import e2e.pages.Ely.LoginPage;

//* Tech Debt: GX3-253 = https://upexgalaxy26.atlassian.net/browse/GX3-253
public class ElyLoginTest extends TestBase {

    // private LoginPage loginPage;

    @BeforeEach
    public void precondition() {
        web.get("https://www.saucedemo.com");
    }

    @Test
    @DisplayName("TC1: ....")
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.submitLogin();
        Thread.sleep(5000);
    }
}
