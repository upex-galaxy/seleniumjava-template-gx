package e2e.pages.LuisRicardo;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import e2e.utils.Action;
//import e2e.utils.Assertion;
import e2e.utils.Locator;

//*  Tech Debt: GX3-321 = https://upexgalaxy26.atlassian.net/browse/GX3-321

public class ProductDetailsPage {
    // EL PAGE OBJECT MODEL SE DIVIDE EN 3 SECTORES PRINCIPALES:

    private Locator get;
    private Action Do;
    // private Assertion validate;
    private Supplier<WebElement> addToCartSauceLabsBackpack;
    private Supplier<WebElement> addToCartSauceLabsBikeLight;

    // * #1 ARMAR EL CONSTRUCTOR con WebDriver (para usar los selectores/Locators)
    public ProductDetailsPage(Locator locator, Action action) {
        this.get = locator;
        this.Do = action;
        // this.validate = new Assertion();
        // * #2 LOCATORS DE PAGE => dentro del Constructor (requiere tipado Suppiler<>)
        this.addToCartSauceLabsBackpack = () -> this.get.ByTestId("add-to-cart-sauce-labs-backpack");
        this.addToCartSauceLabsBikeLight = () -> this.get.ByTestId("add-to-cart-sauce-labs-bike-light");

    }

    // * #3 MÉTODOS CON LOS SELECTORES => métodos public
    // void/String/WebElement/Numbers
    public void buttonAddToCartSauceLabsBackpack() {
        this.Do.click(this.addToCartSauceLabsBackpack.get());
    }

    public void buttonAddToCartSauceLabsBikeLight() {
        this.Do.click(this.addToCartSauceLabsBikeLight.get());
    }

    // * Shortcut:
    public void addToCart() {
        this.buttonAddToCartSauceLabsBackpack();
        this.buttonAddToCartSauceLabsBikeLight();
    }

}