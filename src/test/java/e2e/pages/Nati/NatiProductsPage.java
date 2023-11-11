package e2e.pages.Nati;

import java.util.List;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Action;
// import e2e.utils.Assertion;
import e2e.utils.Locator;

//* TECH DEB: GX3-296 https://upexgalaxy26.atlassian.net/browse/GX3-296

public class NatiProductsPage {
    // private WebDriver web;
    private Locator get;
    private Action Do;
    // private Assertion validate;
    private Supplier<List<WebElement>> addToCartButton;
    private Supplier<List<WebElement>> removeFromCartButton;
    private Supplier<WebElement> shoppingCart;

    public NatiProductsPage(WebDriver driver, Locator locator, Action action) {
        // this.web = driver;
        this.get = locator;
        this.Do = action;
        // this.validate = new Assertion();

        this.removeFromCartButton = () -> this.get.Selectors("[data-test*=remove]");
        this.addToCartButton = () -> this.get.Selectors("[data-test*=add-to-cart]");

        this.shoppingCart = () -> this.get.ByClass("shopping_cart_badge");
    }

    public Integer getItemsCount() {
        String result = shoppingCart.get().getAttribute("innerText");
        return Integer.parseInt(result);
    }

    public void addItem(Integer articulo) {
        this.Do.click(this.addToCartButton.get().get(articulo));
    }

    public void removeItem(Integer articulo) {
        this.Do.click(this.removeFromCartButton.get().get(articulo));
    }

    public WebElement getAddToCartButton(Integer articulo) {
        return this.addToCartButton.get().get(articulo);
    }

}
