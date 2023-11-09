package e2e.steps.ShoppingCart.Nati;

import java.io.IOException;

import org.junit.jupiter.api.*;
import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;
import e2e.pages.Nati.NatiProductsPage;

//* TECH DEB: GX3-296 https://upexgalaxy26.atlassian.net/browse/GX3-296

public class NatiRemoveProductTest extends TestBase {

    private NatiProductsPage productsPage;

    @BeforeEach
    @DisplayName("Preconditions: Usuario dentro de la página | Uno o más productos agregados al SCP")
    public void preconditions() throws InterruptedException, IOException {

        productsPage = new NatiProductsPage(web, get, Do);
        web.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(web, get, Do);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.submitLogin();

        productsPage.addItem(0);
        productsPage.addItem(1);
    }

    @Test
    @DisplayName("GX3-296 | TC1: Validar que remueve un producto del carrito")
    public void removeItemSucessfully() throws InterruptedException {
        productsPage.removeItem(0);
        then.shouldBeTrue(productsPage.getItemsCount() == 1);
        then.shouldBeVisible(productsPage.getAddToCartButton(0));
        Thread.sleep(2000);
    }

}
