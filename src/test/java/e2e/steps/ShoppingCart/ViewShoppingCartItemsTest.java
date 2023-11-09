package e2e.steps.ShoppingCart;

import org.junit.jupiter.api.*;
import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;
import e2e.pages.Isabel.LoginSwagLabsPage;
import e2e.pages.Isabel.ProductListSwagLabsPage;
import e2e.pages.Isabel.ViewShoppingCartItemsPage;

public class ViewShoppingCartItemsTest extends TestBase {
    @BeforeEach
    public void preconditions() {
        // * The user is logged in
        LoginSwagLabsPage loginPage = new LoginSwagLabsPage(web, get, Do);
        web.get(BASE_URL);
        loginPage.Login();
        then.shouldContain(web.getCurrentUrl(), "inventory.html");

        // * The user has added products to the cart
        ProductListSwagLabsPage PLP = new ProductListSwagLabsPage(web, get);
        PLP.addProductToCart(0);
        PLP.addProductToCart(2);
        PLP.addProductToCart(3);
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

    // @Test
    // @DisplayName("TC01: Finish the order")
    // public void finishTheOrder() {
    // viewShoppingCartItems.finishOrder();
    // }

    // @Test
    // @DisplayName("TC02: Cancel the order")
    // public void cancelTheOrder() {
    // viewShoppingCartItems.cancelOrder();
    // }
}