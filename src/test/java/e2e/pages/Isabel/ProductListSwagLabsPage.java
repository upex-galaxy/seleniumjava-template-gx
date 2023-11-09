package e2e.pages.Isabel;

import java.util.List;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import e2e.utils.Locator;

public class ProductListSwagLabsPage {
    private Locator get;
    private Supplier<List<WebElement>> productItems;
    private Supplier<List<WebElement>> productPrices;
    private Supplier<List<WebElement>> addToCartButton;
    private Supplier<List<WebElement>> removeButton;

    public ProductListSwagLabsPage(WebDriver driver, Locator locator) {
        this.get = locator;
        this.productItems = () -> this.get.ByClasses("inventory_item");
        this.productPrices = () -> this.get.ByClasses("inventory_item_price");
        this.addToCartButton = () -> this.get.Selectors("[data-test*=add-to-cart]");
        this.removeButton = () -> this.get.Selectors("[data-test*=remove]");
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

    // ----------- Navigators ---------------------------------------------
    public void gotoProductDetails(WebElement givenProduct) {
        WebElement item = this.get.WithinElement(givenProduct, "img");
        item.click();
    }

    // seleccionarProducto(){ obtener el elemento del producto}
}
