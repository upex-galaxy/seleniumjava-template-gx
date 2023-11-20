package e2e.steps.Product;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;
import e2e.pages.LoginPage;
import e2e.pages.LuisRicardo.ProductDetailsPage;

//* Tech Debt: GX3-321 = https://upexgalaxy26.atlassian.net/browse/GX3-321
public class LuisRicardoPDPTest extends TestBase {

    // private LoginPage loginPage;

    @BeforeEach
    public void precondition() {
        web.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.submitLogin();
        then.shouldContain(web.getCurrentUrl(), "inventory.html");
    }

    @Test
    @DisplayName("TC1: Add to Cart Two Products")
    public void addToCart() throws InterruptedException {

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(get, Do);
        productDetailsPage.buttonAddToCartSauceLabsBackpack();

        Thread.sleep(1000);

        WebElement output = get.Selector("#remove-sauce-labs-backpack");
        String value = output.getText();
        then.shouldBeEqual(value, "Removes");

        Thread.sleep(1000);
        productDetailsPage.buttonAddToCartSauceLabsBikeLight();

        Thread.sleep(5000);
    }
}
