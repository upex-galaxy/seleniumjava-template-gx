package e2e.steps.ShoppingCart;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import e2e.fixtures.TestBase;
import e2e.pages.Isabel.LoginSwagLabsPage;
import e2e.pages.Isabel.ProductListSwagLabsPage;
import e2e.pages.Isabel.UserInformationPage;
import e2e.pages.Isabel.DescriptopnProductPage;
import e2e.pages.Isabel.OverviewFinalPaymentPage;

public class ViewShoppingCartItemsTest extends TestBase {
    @BeforeEach
    @DisplayName("Preconditions: The user is logged in; has added products to the cart; has completed the Checkout-Step-One by clicking the Continue button")
    public void preconditions() {
        // 1. The user is logged in
        LoginSwagLabsPage loginPage = new LoginSwagLabsPage(web, get, Do);
        web.get(BASE_URL);
        loginPage.Login();
        then.shouldContain(web.getCurrentUrl(), "inventory.html");

        // 2. The user has added products to the cart
        ProductListSwagLabsPage PLP = new ProductListSwagLabsPage(web, get, Do);
        PLP.addProductToCart(0);
        PLP.addProductToCart(2);
        PLP.addProductToCart(3);
        PLP.navegateToChoppingCart();

        // The user has completed the "Checkout-Step-One" by clicking the "Continue"
        // button.
        DescriptopnProductPage detailProduct = new DescriptopnProductPage(get, Do);
        detailProduct.selectCheckoutButton();

        // 3. The user has entered their personal data.
        UserInformationPage userInformation = new UserInformationPage(get, Do);
        userInformation.enterUserInformation();
    }

    @Test
    @DisplayName("TC01: The user should be able to complete the purchase")
    public void checkoutCompleted() {
        OverviewFinalPaymentPage overview = new OverviewFinalPaymentPage(get, Do);
        overview.finishOrder();
        then.shouldContain(web.getCurrentUrl(), "checkout-complete.html");
    }

    @Test
    @DisplayName("TC02: A friendly message should appear confirming the completion of the purchase")
    public void showConfirmationCompletionMessage() {
        OverviewFinalPaymentPage overview = new OverviewFinalPaymentPage(get, Do);
        WebElement confirmationMessageElement = overview.getConfirmationCompletionMessage();
        then.shouldBeVisible(confirmationMessageElement);
    }

    @Test
    @DisplayName("TC03: The user should not complete the purchase when the Cancel button is selected")
    public void checkoutCanceled() {
        OverviewFinalPaymentPage overview = new OverviewFinalPaymentPage(get, Do);
        overview.cancelOrder();
        then.shouldContain(web.getCurrentUrl(), "inventory.html");
    }

    @Test
    @DisplayName("TC04: All details related to the purchase should be included")
    public void checkDetailsPurchase() {
        OverviewFinalPaymentPage overview = new OverviewFinalPaymentPage(get, Do);
        ProductListSwagLabsPage PLP = new ProductListSwagLabsPage(web, get, Do);
        String valuePriceProductOverview = overview.getProductPrice();
        String valuePriceProductPLP = PLP.getProductPrice(0);
        then.shouldBeEqual(valuePriceProductPLP, valuePriceProductOverview);
    }

}