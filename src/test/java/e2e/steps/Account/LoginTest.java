package e2e.steps.Account;

import org.junit.jupiter.api.*;
import io.qameta.allure.*;
import static io.qameta.allure.SeverityLevel.*;

import java.io.IOException;

import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;

//* Tech Debt: GX3-253 = https://upexgalaxy26.atlassian.net/browse/GX3-253
@Epic("Account Component")
@Feature("Login Features")
@Story("GX3-367: SwagLabs | Account | Iniciar sesión y BR de Accesos")
public class LoginTest extends TestBase {

    @BeforeEach
    public void precondition() {
        web.get(BASE_URL);
    }

    @Test
    @Severity(BLOCKER)
    @Issue("https://upexgalaxy26.atlassian.net/browse/GX3-367")
    @DisplayName("TC1: Validar Login exitoso")
    @Description("Este caso de prueba va a validar que el usuario pueda iniciar sesión exitosamente")
    public void login(TestInfo testInfo) throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(web, get, Do);

        Allure.step("Step 1: Ingresar valor válido Username", (step) -> {
            loginPage.enterUsername("standard_user");
        });
        Allure.step("Step 2: Ingresar valor válido Password", (step) -> {
            loginPage.enterPassword("secret_sauce");
        });
        Allure.step("Step 3: Hacer click en el botón en Login", (step) -> {
            loginPage.submitLogin();
        });
        Allure.step("Resultado Esperado: Debería iniciar sesión exitosamente y redirigirse al PLP", (step) -> {
            then.shouldContain(web.getCurrentUrl(), "inventory.html");
            Do.screenshot(testInfo);
        });
    }
}
