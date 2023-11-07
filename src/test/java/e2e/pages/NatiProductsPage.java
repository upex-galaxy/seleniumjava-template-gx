package e2e.pages;

import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Assertion;
import e2e.utils.Locator;

//* TECH DEB: GX3-296 https://upexgalaxy26.atlassian.net/browse/GX3-296

public class NatiProductsPage {
    private WebDriver web;
    private Locator get;
    private Action Do;
    private Assertion validate;
    private Supplier<WebElement> removeBackpackButton;
    private Supplier<WebElement> addBackpackButton;
    private Supplier<WebElement> removeBikeLightButton;
    private Supplier<WebElement> addBikeLightButton;
    private Supplier<WebElement> shoppingCart;

    public NatiProductsPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        this.validate = new Assertion();

        this.removeBackpackButton = () -> this.get.ByTestId("remove-sauce-labs-backpack");
        this.addBackpackButton = () -> this.get.ByTestId("add-to-cart-sauce-labs-backpack");
        this.removeBikeLightButton = () -> this.get.ByTestId("remove-sauce-labs-bike-light");
        this.addBikeLightButton = () -> this.get.ByTestId("add-to-cart-sauce-labs-bike-light");
        this.shoppingCart = () -> this.get.ByClass("shopping_cart_badge");
    }

    public Integer getItemsCount() {
        String result = shoppingCart.get().getAttribute("innerText");
        return Integer.parseInt(result);
    }

    public void addBackpack() { // agrega accesorio con este nombre
        this.Do.click(this.addBackpackButton.get());
    }

    public void addBikeLight() { // agrega accesorio con este nombre
        this.Do.click(this.addBikeLightButton.get());
    }

    public void removeBackpack() {
        this.Do.click(this.removeBackpackButton.get());
    }

}
