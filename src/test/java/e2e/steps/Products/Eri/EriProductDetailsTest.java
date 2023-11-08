package e2e.steps.Products.Eri;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.fixtures.Eri.TestBase;
import e2e.pages.Eri.ProductDetailsPage;
import e2e.utils.Assertion;
import e2e.utils.Action;
import e2e.utils.Locator;

//* Tech Debt: GX3-248 =https://upexgalaxy26.atlassian.net/browse/GX3-248 */
public class EriProductDetailsTest extends TestBase {
    ProductDetailsPage productDetailsPage;
    Assertion assertion;

    // el usuario esta LOGEADO y situarse en el PLP.
    @BeforeEach
    public void precondition() throws InterruptedException {
        web.get("https://www.saucedemo.com/");
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(web, get, Do);
        productDetailsPage.enterUsername("standard_user");
        productDetailsPage.enterPassword("secret_sauce");
        productDetailsPage.submitLogin();
        Assertion assertion = new Assertion();
        assertion.shouldContain(web.getCurrentUrl(), "inventory.html");
    }

    @Test
    @DisplayName("TC1: Validar poder seleccionar un producto sin añadir al carrito desde la imagen")
    public void testProductWithoutAdding() throws InterruptedException {

        // Clic en la imagen del primer producto de la lista
        productDetailsPage.selectProductImage();

        // Aserciones para verificar que se visualizan los elementos requeridos.
        assertion.shouldBeVisible(productDetailsPage.productNameLabel);
        assertion.shouldBeVisible(productDetailsPage.productDescription);
        assertion.shouldBeVisible(productDetailsPage.productImage);
        assertion.shouldBeVisible(productDetailsPage.productPrice);

        productDetailsPage.addToCartButton();
        productDetailsPage.backButton();

    }

    @DisplayName("TC1: Validar poder seleccionar un producto sin añadir al carrito desde el titulo")
    public void ProductDetailsPage() throws InterruptedException {

    }

    {

    }
}
