package e2e.steps.ShoppingCart;

import java.io.IOException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import io.cucumber.java.eo.Do;

import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;
import e2e.pages.ProductListPage;
import e2e.pages.YelenaPages.CheckoutYMPage;
import e2e.pages.YelenaPages.YourCartYMPage;
import e2e.pages.YelenaPages.FormInformationYMPage;

public class BuyerPaymentYMTest extends TestBase {
    @BeforeEach
    @DisplayName("PRC1: El usuario se encuentra logueado")
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
    @DisplayName("TC1: Validar poder insertar información del comprador en el formulario Checkout: Your Information")
    public void IngresarInfo() throws InterruptedException, IOException {
        FormInformationYMPage insertdata = new FormInformationYMPage(web, get, Do);
        insertdata.firstName("Rosa");
        insertdata.lastName("Ruiz");
        insertdata.postalCode("11200");
        insertdata.IngresarDatos();
        then.shouldContain(web.getCurrentUrl(), "checkout-step-two.html");
        Thread.sleep(5000);

    }

}
