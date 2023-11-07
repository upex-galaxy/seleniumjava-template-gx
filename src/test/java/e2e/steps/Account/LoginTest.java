package e2e.steps.Account;

import org.junit.jupiter.api.*;

import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;

//* Tech Debt: GX3-253 = https://upexgalaxy26.atlassian.net/browse/GX3-253
public class LoginTest extends TestBase {

    // private LoginPage loginPage;

    @BeforeEach
    public void precondition() {
        web.get(BASE_URL);
    }

    @Test
    @DisplayName("TC1: Validar Login exitoso")
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.submitLogin();
        then.shouldContain(web.getCurrentUrl(), "inventory.html");
    }
}
