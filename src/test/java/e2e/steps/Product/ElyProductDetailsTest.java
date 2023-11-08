package e2e.steps.Product;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;
import e2e.pages.ProductListPage;

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
    @DisplayName("TC1: Validar agregar producto al SCP")
    public void addToCart() {
        ProductListPage PLP = new ProductListPage(web, get);

        Integer givenProduct = 4;

        String priceValue = PLP.getProductPrice(givenProduct);
        System.out.println(priceValue);

        PLP.addProductToCart(givenProduct);

        WebElement givenItem = PLP.getProductItem(givenProduct);

        PLP.gotoProductDetails(givenItem);

    }
}
