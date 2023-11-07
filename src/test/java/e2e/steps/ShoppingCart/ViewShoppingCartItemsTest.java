package e2e.steps.ShoppingCart;

import org.junit.jupiter.api.*;
import e2e.fixtures.TestBase;
import e2e.pages.Isabel.ViewShoppingCartItemsPage;

public class ViewShoppingCartItemsTest extends TestBase {
    private ViewShoppingCartItemsPage viewShoppingCartItems;

    @BeforeEach
    public void preconditions() {
        viewShoppingCartItems = new ViewShoppingCartItemsPage(web, get, Do);
        web.get("https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    @DisplayName("TC01: Finish the order")
    public void finishTheOrder() {
        viewShoppingCartItems.finishOrder();
    }

    @Test
    @DisplayName("TC02: Cancel the order")
    public void cancelTheOrder() {
        viewShoppingCartItems.cancelOrder();
    }
}
