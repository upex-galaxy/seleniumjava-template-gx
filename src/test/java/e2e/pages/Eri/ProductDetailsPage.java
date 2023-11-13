package e2e.pages.Eri;

//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
import java.util.List;
import java.util.function.Supplier;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.fixtures.Eri.TestBase;
import e2e.pages.Eri.ProductDetailsPage;
import e2e.utils.Action;
import e2e.utils.Assertion;
import e2e.utils.Locator;

//* Tech Debt: GX3-248 =https://upexgalaxy26.atlassian.net/browse/GX3-248 */
public class ProductDetailsPage extends TestBase {

    private Locator get;
    private Action Do;
    private Assertion validate;
    // PLP
    public Supplier<List<WebElement>> productImages;
    public Supplier<List<WebElement>> productTitle;
    public Supplier<List<WebElement>> productName;
    public Supplier<List<WebElement>> productDescription;
    public Supplier<List<WebElement>> productImage;
    public Supplier<List<WebElement>> productPrice;
    public Supplier<List<WebElement>> addToCartButton;
    public Supplier<WebElement> backButton;
    private Supplier<WebElement> yourCart;
    public Supplier<WebElement> removeButton;

    // * #1 ARMAR EL CONSTRUCTOR con WebDriver (para usar los selectores/Locators)
    public ProductDetailsPage(WebDriver driver, Locator locator, Action action) {
        this.get = locator;
        this.Do = action;
        this.validate = new Assertion();

        // * #2 LOCATORS DE PAGE => dentro del Constructor (requiere tipado Suppiler<>)

        // PLP
        this.productImages = () -> get.ByClasses(".inventory_item_img");
        this.productTitle = () -> get.ByClasses(".inventory_item_name");
        this.productName = () -> this.get.ByClasses(".inventory_details_name.large_size>div");
        this.productDescription = () -> this.get.ByClasses(".inventory_details_desc");
        this.productImage = () -> this.get.ByClasses(".inventory_details_img");
        this.productPrice = () -> this.get.ByClasses(".inventory_details_price");
        this.addToCartButton = () -> this.get.ByClasses("[data-test=\"add-to-cart-sauce-labs-backpack\"]");
        this.backButton = () -> this.get.ByClass("[data-test=\"back-to-products\"]");
        this.yourCart = () -> this.get.ByClass(".shopping_cart_badge");
        this.removeButton = () -> this.get.ByClass("[data-test=\"remove-sauce-labs-backpack\"]");

    }

    // * #3 MÉTODOS CON LOS SELECTORES => métodos public

    // * _____ SELECT PRODUCT _____ */
    public void goToProductDetailsImage(Integer ProductIndex) {
        WebElement imagen = this.productImages.get().get(1);
        imagen.click();
    }

    public void goToProductDetailsTitle(Integer ProductIndex) {
        WebElement Title = this.productTitle.get().get(0);
        Title.click();
    }

    // * _____ GET_____ */
    public String getProductName(Integer productIndex) {
        WebElement Name = this.productName.get().get(0);
        String productName = Name.getText();
        return productName;
    }

    public String getProductDescription(Integer productIndex) {
        WebElement Descripcion = this.productDescription.get().get(0);
        String productDescription = Descripcion.getText();
        return productDescription;
    }

    public String getProductPrice(Integer productIndex) {
        WebElement Price = this.productPrice.get().get(productIndex);
        String productPrice = Price.getText();
        return productPrice;
    }

    public void getProductImage(Integer productIndex) {
        WebElement image = this.productImage.get().get(productIndex);
        validate.shouldBeVisible(image);
    }

    // * _____ MAIN ACTIONS _____ */
    public void selectAddToCartButton(Integer productIndex) {
        this.Do.click(this.addToCartButton.get().get(productIndex));
    }

    public void goBackToProducts() {
        this.Do.click(this.backButton.get());
    }

    public void goToYourCart(WebElement givenProduct) {
        WebElement button = this.yourCart.get();
        button.click();
    }

    public void selectRemoveButton(Integer productIndex) {
        this.Do.click(this.removeButton.get());
    }
}
