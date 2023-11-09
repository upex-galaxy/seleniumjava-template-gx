package e2e.pages.Eri;

import java.util.List;
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
    List<WebElement> selectProductImages;
    public Supplier<List<WebElement>> selectProductTitle;
    public Supplier<WebElement> productTitle;
    public Supplier<WebElement> productDescription;
    public Supplier<WebElement> productImage;
    public Supplier<WebElement> productPrice;
    public Supplier<WebElement> selectBackButton;
    public Supplier<WebElement> selectAddToCartButton;

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
        this.selectProductImages = get.ByClasses("inventory_item_img");
        this.selectProductTitle = () -> get.ByClasses(".inventory_item_name");
        this.productTitle = () -> this.get.ByClass("div.inventory_details_name.large_size>div");
        this.productDescription = () -> this.get.ByClass("div.inventory_details_desc.large_size");
        this.productImage = () -> this.get.ByClass("div.inventory_details_img");
        this.productPrice = () -> this.get.ByClass(".inventory_details_price");
        this.selectBackButton = () -> this.get.ByTestId("#remove-sauce-labs-backpack");
        this.selectAddToCartButton = () -> this.get.ByTestId("#add-to-cart-sauce-labs-backpack");
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
        if (!selectProductImages.isEmpty()) {
            this.Do.click(selectProductImages.get(0)); // Selecciona el primer elemento si existe
        }
    }

    public void selectProductTitle() {
        this.Do.click(this.selectProductTitle.get().get(0));
    }

    public void validateProductTitle() {
        this.validate.shouldBeVisible(this.productTitle.get());
    }

    public void validateProductDescription() {
        this.validate.shouldBeVisible(this.productDescription.get());
    }

    public void validateProductPrice() {
        this.validate.shouldBeVisible(this.productPrice.get());
    }

    public void validateProductImage() {
        this.validate.shouldBeVisible(this.productImage.get());
    }

    public void selectBackButton() {
        this.Do.click(this.selectBackButton.get());
    }

    public void selectAddToCartButton() {
        this.Do.click(this.selectAddToCartButton.get());
    }

    // * Shortcut:
    public void addProductToCart() {
        this.enterUsername("standard_user");
        this.enterPassword("secret_sauce");
        this.submitLogin();
        this.validate.shouldContain(web.getCurrentUrl(), "inventory.html");
        this.selectProductImage();
        this.selectProductTitle();
        this.validateProductTitle();
        this.validateProductDescription();
        this.validateProductImage();
        this.validateProductPrice();
        this.selectAddToCartButton();
        this.selectBackButton();

    }
}
