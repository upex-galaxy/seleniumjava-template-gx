package e2e.pages.Eri;

import java.util.List;
import java.util.function.Supplier;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Assertion;
import e2e.utils.Locator;

//* Tech Debt: GX3-248 =https://upexgalaxy26.atlassian.net/browse/GX3-248 */
public class ProductDetailsPage {

    // Login
    private WebDriver web;
    private Locator get;
    private Action Do;
    private Assertion validate;
    private Supplier<WebElement> usernameInput;
    private Supplier<WebElement> passwordInput;
    private Supplier<WebElement> loginSubmitButton;
    // PLP
    List<WebElement> productImages;
    public Supplier<List<WebElement>> productTitle;
    public Supplier<List<WebElement>> productName;
    public Supplier<List<WebElement>> productDescription;
    public Supplier<List<WebElement>> productImage;
    public Supplier<List<WebElement>> productPrice;
    public Supplier<List<WebElement>> addToCartButton;
    public Supplier<List<WebElement>> backButton;
    private Supplier<WebElement> yourCart;
    public Supplier<List<WebElement>> removeButton;

    // * #1 ARMAR EL CONSTRUCTOR con WebDriver (para usar los selectores/Locators)
    public ProductDetailsPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        this.validate = new Assertion();

        // * #2 LOCATORS DE PAGE => dentro del Constructor (requiere tipado Suppiler<>)
        // login
        this.usernameInput = () -> this.get.ByTestId("username");
        this.passwordInput = () -> this.get.ByTestId("password");
        this.loginSubmitButton = () -> this.get.ByTestId("login-button");

        // PLP
        this.productImages = get.ByClasses(".inventory_item_img");
        this.productTitle = () -> get.ByClasses(".inventory_item_name");
        this.productName = () -> this.get.ByClasses(".inventory_details_name.large_size>div");
        this.productDescription = () -> this.get.ByClasses(".inventory_details_desc.large_size");
        this.productImage = () -> this.get.ByClasses(".inventory_details_img");
        this.productPrice = () -> this.get.ByClasses(".inventory_details_price");
        this.addToCartButton = () -> this.get.ByClasses("data-test*=add-to-cart");
        this.backButton = () -> this.get.ByClasses("data-test*=back-to-products");
        this.yourCart = () -> this.get.ById("shopping_cart_container");
        this.removeButton = () -> this.get.ByClasses("data-test*=remove");

    }

    // * #3 MÉTODOS CON LOS SELECTORES => métodos public

    // * _____ LOGIN _____ */
    public void enterUsername(String value) {
        this.Do.enterValue(this.usernameInput.get(), value);
    }

    public void enterPassword(String value) {
        this.Do.enterValue(this.passwordInput.get(), value);
    }

    public void submitLogin() {
        this.Do.click(this.loginSubmitButton.get());
    }

    // * _____ SELECT PRODUCT _____ */
    public void goToProductDetailsImage(Integer ProductIndex) {
        WebElement imagen = this.productImages.get(0);
        imagen.click();
    }

    public void goToProductDetailsTitle(Integer ProductIndex) {
        WebElement Title = this.productTitle.get().get(0);
        Title.click();
    }

    // * _____ VALIDATION _____ */
    public String validateProductName(Integer productIndex) {
        WebElement Name = this.productName.get().get(0);
        String productName = Name.getText();
        return productName;
    }

    public String validateProductDescription(Integer productIndex) {
        WebElement Descripcion = this.productDescription.get().get(0);
        String productDescription = Descripcion.getText();
        return productDescription;
    }

    public String validateProductPrice(Integer productIndex) {
        WebElement Price = this.productPrice.get().get(productIndex);
        String productPrice = Price.getText();
        return productPrice;
    }

    public void validateProductImage(Integer productIndex) {
        WebElement image = this.productImage.get().get(productIndex);
        validate.shouldBeVisible(image);
    }

    // * _____ MAIN ACTIONS _____ */
    public void selectAddToCartButton(Integer productIndex) {
        List<WebElement> buttons = this.addToCartButton.get();
        if (buttons.size() > productIndex) {
            WebElement button = buttons.get(productIndex);
            button.click();
        }
    }

    public void selectBackButton(Integer productIndex) {
        List<WebElement> buttons = this.backButton.get();
        if (buttons.size() > productIndex) {
            WebElement button = buttons.get(productIndex);
            button.click();
        }
    }

    public void goToYourCart(WebElement givenProduct) {
        WebElement button = this.yourCart.get();
        button.click();
    }

    public void selectRemoveButton(Integer productIndex) {
        List<WebElement> buttons = this.removeButton.get();
        if (buttons.size() > productIndex) {
            WebElement button = buttons.get(productIndex);
            button.click();
        }
    }

    // * Shortcut:
    public void Login() {
        this.enterUsername("standard_user");
        this.enterPassword("secret_sauce");
        this.submitLogin();
        this.validate.shouldContain(web.getCurrentUrl(), "inventory.html");
    }

    public void selectProductImage() {
    }

    public void selectAddToCartButton() {
    }

    public void selectBackButton() {
    }
}
