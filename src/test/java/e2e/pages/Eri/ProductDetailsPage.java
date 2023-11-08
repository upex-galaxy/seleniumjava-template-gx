package e2e.pages.Eri;

import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Assertion;
import e2e.utils.Locator;

//* Tech Debt: GX3-248 =https://upexgalaxy26.atlassian.net/browse/GX3-248 */
public class ProductDetailsPage {

    private WebDriver web;
    private Locator get;
    private Action Do;
    private Assertion validate;
    private Supplier<WebElement> usernameInput;
    private Supplier<WebElement> passwordInput;
    private Supplier<WebElement> loginSubmitButton;
    private Supplier<WebElement> productImage;
    private Supplier<WebElement> productTitle;
    private Supplier<WebElement> productNameLabel;
    private Supplier<WebElement> productDescription;
    private Supplier<WebElement> productPrice;
    private Supplier<WebElement> backButton;
    private Supplier<WebElement> addToCartButton;

    // * #1 ARMAR EL CONSTRUCTOR con WebDriver (para usar los selectores/Locators)
    public ProductDetailsPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        this.validate = new Assertion();

        // * #2 LOCATORS DE PAGE => dentro del Constructor (requiere tipado Suppiler<>)
        this.usernameInput = () -> this.get.ByTestId("username");
        this.passwordInput = () -> this.get.ByTestId("password");
        this.loginSubmitButton = () -> this.get.ByTestId("login-button");
        this.productImage = () -> this.get.Selector("div.inventory_item_img");
        this.productTitle = () -> this.get.ByClass("div.inventory_item_name");
        this.productNameLabel = () -> this.get.ByClass("div.inventory_details_name.large_size");
        this.productDescription = () -> this.get.ByClass("div.inventory_details_desc.large_size");
        this.productPrice = () -> this.get.ByClass(".inventory_details_price");
        this.backButton = () -> this.get.ByTestId("#remove-sauce-labs-backpack");
        this.addToCartButton = () -> this.get.ByTestId("#add-to-cart-sauce-labs-backpack");
    }

    // * #3 MÉTODOS CON LOS SELECTORES => métodos public
    public void enterUsername(String value) {
        this.Do.enterValue(this.usernameInput.get(), value);
    }

    public void enterPassword(String value) {
        this.Do.enterValue(this.passwordInput.get(), value);
    }

    public void submitLogin() {
        this.Do.click(this.loginSubmitButton.get());
    }

    public void selectProductImage() {
        this.Do.click(this.productImage.get());
    }

    public void selectProductTitle() {
        this.Do.click(this.productTitle.get());
    }

    public void selectProductNameLabel() {
        this.Do.click(this.productNameLabel.get());
    }

    public void selectProductDescription() {
        this.Do.click(this.productDescription.get());
    }

    public void selectProductPrice() {
        this.Do.click(this.productPrice.get());
    }

    public void selectBackButton() {
        this.Do.click(this.backButton.get());
    }

    public void selectAddToCartButton() {
        this.Do.click(this.addToCartButton.get());
    }

    // * Shortcut:
    public void productDetailsPage() {
        this.enterUsername("standard_user");
        this.enterPassword("secret_sauce");
        this.submitLogin();
        this.validate.shouldContain(web.getCurrentUrl(), "inventory.html");
        this.selectProductImage();
        this.selectProductTitle();
        this.selectProductNameLabel();
        this.selectProductDescription();
        this.selectProductPrice();
        this.selectBackButton();
        this.selectAddToCartButton();
    }
}
