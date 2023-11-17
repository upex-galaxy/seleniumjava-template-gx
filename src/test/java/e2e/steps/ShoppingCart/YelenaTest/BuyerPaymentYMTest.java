package e2e.steps.ShoppingCart.YelenaTest;

import java.io.IOException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.qameta.allure.*;
import static io.qameta.allure.SeverityLevel.*;
import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;
import e2e.pages.ProductListPage;
import e2e.pages.Yelena.CheckoutYMPage;
import e2e.pages.Yelena.YourCartYMPage;
import e2e.pages.Yelena.FormInformationYMPage;

@Epic("Checkout Info Component")
@Feature("Insert Information Features")
@Story("GX3-346: SwagLabs | Checkout Info | Insertar información del comprador")

public class BuyerPaymentYMTest extends TestBase {
    @BeforeEach
    public void precondition() {
        LoginPage loginPage = new LoginPage(web, get, Do);
        ProductListPage producto = new ProductListPage(web, get);
        YourCartYMPage iconcart = new YourCartYMPage(web, get, Do);
        CheckoutYMPage checkout = new CheckoutYMPage(web, get, Do);
        web.get(BASE_URL);
        loginPage.Login();
        producto.addProductToCart(4);
        iconcart.ClickCart();
        checkout.ClickCheckout();

    }

    @Test
    @Severity(BLOCKER)
    @Issue("https://upexgalaxy30.atlassian.net/browse/GX3-346")
    @DisplayName("TC1: Validar poder insertar información del comprador en el formulario Checkout: Your Information")
    @Description("Este caso de prueba va a validar que el usuario ingresa la información el formulario de Checkout: Your Information de forma exitosamente")
    public void ValidarInsertarInfo(TestInfo testInfo) throws InterruptedException, IOException {
        FormInformationYMPage insertdata = new FormInformationYMPage(web, get, Do);
        Allure.step("Step 1: Ingresa la información al formulario", (step) -> {
            insertdata.IngresarDatosValidos();
        });
        Allure.step("Resultado Esperado: Debería redirigirse a la página de Checkout: Overview", (step) -> {
            then.shouldContain(web.getCurrentUrl(), "checkout-step-two.html");
            Do.screenshot(testInfo);
        });
    }

    @Test
    @Severity(BLOCKER)
    @Issue("https://upexgalaxy30.atlassian.net/browse/GX3-346")
    @DisplayName("TC2: Validar NO dejar campos nulos del formulario Checkout: Your Information")
    @Description("Este caso de prueba va a validar que el sistema lanza un error al usuario al no ingresar información al formulario de Checkout: Your Information")
    public void ValidarCamposNulos(TestInfo testInfo) throws InterruptedException, IOException {
        FormInformationYMPage datos = new FormInformationYMPage(web, get, Do);
        Allure.step("Step 1: Se deja el formulario con los campos vacíos", (step) -> {
            datos.CamposNulos();
        });
        WebElement title = web.findElement(By.cssSelector("[role=img]"));
        Allure.step("Resultado Esperado: Debería mostrarse el mensaje de error Error: First Name is required",
                (step) -> {
                    then.shouldBeTrue(title.isDisplayed());
                    Do.screenshot(testInfo);
                });
        Thread.sleep(2000);

    }

    @Test
    @Severity(BLOCKER)
    @Issue("https://upexgalaxy30.atlassian.net/browse/GX3-346")
    @DisplayName("TC3: Validar firstName campo nulo")
    @Description("Este caso de prueba va a validar que el sistema lanza un error al usuario no ingresar información en el campo firstName del formulario de Checkout: Your Information")
    public void ValidarNombreNulo(TestInfo testInfo) throws InterruptedException, IOException {
        FormInformationYMPage datos = new FormInformationYMPage(web, get, Do);
        Allure.step("Step 1: Se deja el formulario con el campo firstName vacío", (step) -> {
            datos.CampoFirstNameNulo();
        });
        WebElement title = web.findElement(By.cssSelector("[role=img]"));
        Allure.step("Resultado Esperado: Debería mostrarse el mensaje de error Error: First Name is required",
                (step) -> {
                    then.shouldBeTrue(title.isDisplayed());
                    Do.screenshot(testInfo);
                });
        Thread.sleep(2000);

    }

    @Test
    @Severity(BLOCKER)
    @Issue("https://upexgalaxy30.atlassian.net/browse/GX3-346")
    @DisplayName("TC4: Validar Last Name campo nulo")
    @Description("Este caso de prueba va a validar que el sistema lanza un error al usuario no ingresar información en el campo Last Name del formulario de Checkout: Your Information")
    public void ValidarApellidoNulo(TestInfo testInfo) throws InterruptedException, IOException {
        FormInformationYMPage datos = new FormInformationYMPage(web, get, Do);
        Allure.step("Step 1: Se deja el formulario con el campo lastName vacío", (step) -> {
            datos.CampoLastNameNulo();
        });
        WebElement title = web.findElement(By.cssSelector("[role=img]"));
        Allure.step("Resultado Esperado: Debería mostrarse el mensaje de error Error: Last Name is required",
                (step) -> {
                    then.shouldBeTrue(title.isDisplayed());
                    Do.screenshot(testInfo);
                });
        Thread.sleep(2000);

    }

    @Test
    @Severity(BLOCKER)
    @Issue("https://upexgalaxy30.atlassian.net/browse/GX3-346")
    @DisplayName("TC5: Validar Código Postal campo nulo")
    @Description("Este caso de prueba va a validar que el sistema lanza un error al usuario no ingresar información en el campo Postal Code del formulario de Checkout: Your Information")
    public void ValidarCodePostalNulo(TestInfo testInfo) throws InterruptedException, IOException {
        FormInformationYMPage datos = new FormInformationYMPage(web, get, Do);
        Allure.step("Step 1: Se deja el formulario con el campo Postal Code vacío", (step) -> {
            datos.CampoCodePostalNulo();
        });
        WebElement title = web.findElement(By.cssSelector("[role=img]"));
        Allure.step("Resultado Esperado: Debería mostrarse el mensaje de error Error: Postal Code is required",
                (step) -> {
                    then.shouldBeTrue(title.isDisplayed());
                    Do.screenshot(testInfo);
                });
        Thread.sleep(1000);

    }

    @Test
    @Severity(BLOCKER)
    @Issue("https://upexgalaxy30.atlassian.net/browse/GX3-346")
    @DisplayName("TC6: Validar poder dar Cancel en el formulario Checkout: Your Information")
    @Description("Este caso de prueba va a validar que el usuario da click en el botón Cancel del formulario de Checkout: Your Information de forma exitosamente")
    public void ValidarCancel(TestInfo testInfo) throws InterruptedException, IOException {
        FormInformationYMPage dat = new FormInformationYMPage(web, get, Do);
        Allure.step("Step 1: Ingresa la información al formulario y da click en el botón Cancel", (step) -> {
            dat.buttonCancel();
        });
        Allure.step("Resultado Esperado: Debería regresar a la sección de SCP", (step) -> {
            then.shouldContain(web.getCurrentUrl(), "cart.html");
            Do.screenshot(testInfo);
        });
        Thread.sleep(2000);
    }

}
