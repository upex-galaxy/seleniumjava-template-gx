package e2e.steps.Product;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;
import e2e.pages.ProductListPage;
import io.qameta.allure.*;

@Epic("ProductDetailsPage")
@Feature("Cart")
@Story("GX3-2: User can add products to the Cart")
public class ElyProductDetailsTest extends TestBase {

    @BeforeEach
    @DisplayName("User must be logged in")
    public void precondition() {
        LoginPage loginPage = new LoginPage(web, get, Do);
        web.get(BASE_URL);
        loginPage.Login();
        then.shouldContain(web.getCurrentUrl(), "inventory.html");
    }

    @Test
    @Tag("Smoke")
    @Issue("https://upexgalaxy26.atlassian.net/browse/GX3-253")
    @DisplayName("TC1: Validar agregar producto al SCP")
    public void addToCart(TestInfo testInfo) {
        ProductListPage PLP = new ProductListPage(web, get);
        Integer givenProduct = 4;

        Allure.step("Step#1: Obtener el precio del Producto", (step) -> {
            String priceValue = PLP.getProductPrice(givenProduct);
            System.out.println(priceValue);
            Do.screenshot(testInfo);
        });
        Allure.step("Step#2: Agregar el producto al carrito de compras", (step) -> {
            PLP.addProductToCart(givenProduct);
            Do.screenshot(testInfo);
        });
        Allure.step("Step#3: Ir al PDP del producto", (step) -> {
            WebElement givenItem = PLP.getProductItem(givenProduct);
            PLP.gotoProductDetails(givenItem);
        });
    }
}
