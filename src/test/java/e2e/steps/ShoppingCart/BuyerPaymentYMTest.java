package e2e.steps.ShoppingCart;

import java.io.IOException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;
import e2e.pages.ProductListPage;
import e2e.pages.YelenaPages.CheckoutYMPage;
import e2e.pages.YelenaPages.YourCartYMPage;
import io.cucumber.java.eo.Do;
import io.qameta.allure.Allure;
import io.qameta.allure.Issue;

public class BuyerPaymentYMTest extends TestBase {
    @BeforeEach
    @DisplayName("PRC1: El usuario se encuentra logueado")
    public void precondition() {
        LoginPage loginPage = new LoginPage(web, get, Do);
        ProductListPage producto = new ProductListPage(web, get);
        web.get(BASE_URL);
        loginPage.Login();
        producto.addProductToCart(4);

    }

    @BeforeEach
    @Test
    @DisplayName("PRC2: Tiene uno o varios productos añadidos al carrito")
    public void AccessCart() throws InterruptedException, IOException {
        YourCartYMPage iconcart = new YourCartYMPage(web, get, Do);
        iconcart.ClickCart();
        then.shouldContain(web.getCurrentUrl(), "cart.html");
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("PRC3: Se sitúa en el checkout-step-one")
    public void InformacionComprador() throws InterruptedException, IOException {
        CheckoutYMPage checkout = new CheckoutYMPage(web, get, Do);
        checkout.ClickCheckout();
        then.shouldContain(web.getCurrentUrl(), "checkout-step-one.html");
        Thread.sleep(2000);
    }

}
