package e2e.pages.Isabel;

import java.util.List;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import e2e.utils.Locator;
import e2e.utils.Action;

public class ProductListSwagLabsPage {
    WebDriver web;
    Locator get;
    Action Do;

    private Supplier<List<WebElement>> productItems;
    private Supplier<List<WebElement>> productPrices;
    private Supplier<List<WebElement>> addToCartButton;
    private Supplier<List<WebElement>> removeButton;
    private Supplier<WebElement> goToShoppingCart;

    public ProductListSwagLabsPage(WebDriver driver, Locator locator, Action action) {
        this.get = locator;
        this.web = driver;
        this.Do = action;
        this.productItems = () -> this.get.ByClasses("inventory_item");
        this.productPrices = () -> this.get.ByClasses("inventory_item_price");
        this.addToCartButton = () -> this.get.Selectors("[data-test*=add-to-cart]");
        this.removeButton = () -> this.get.Selectors("[data-test*=remove]");
        this.goToShoppingCart = () -> this.get.ByClass("shopping_cart_link");
    }

    // ----------- GETTERS ---------------------------------------------
    public WebElement getProductItem(Integer productIndex) {
        WebElement item = this.productItems.get().get(productIndex);
        return item;
    }

    public String getProductPrice(Integer productIndex) {
        WebElement price = this.productPrices.get().get(productIndex);
        String priceValue = price.getText();
        return priceValue;
    }

    // ----------- MAIN ACTIONS ---------------------------------------------
    public void addProductToCart(Integer productIndex) {
        WebElement button = this.addToCartButton.get().get(productIndex);
        button.click();
    }

    public void removeProductFromCart(Integer productIndex) {
        WebElement button = this.removeButton.get().get(productIndex);
        button.click();
    }

    // Added
    public void navegateToChoppingCart() {
        this.Do.click(this.goToShoppingCart.get());
    }

    // seleccionarProducto(){ obtener el elemento del producto}
}
