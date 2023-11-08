package e2e.pages;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Locator;

//*----- PAGE OBJECT MODEL ---- */
public class ProductListPage {

    private WebDriver web;
    private Locator get;
    private Supplier<WebElement> inventoryList;
    private Supplier<List<WebElement>> productItems;
    private Supplier<List<WebElement>> productPrices;
    private Supplier<List<WebElement>> productDescs;
    private Supplier<List<WebElement>> productTitles;
    private Supplier<List<WebElement>> addToCartButton;
    private Supplier<List<WebElement>> removeButton;

    // * */ 3 PARTES DEL POM:
    // ? INSTANCIAR EL LOCATOR DE ELEMENTS [selenium y otros] (CONSTRUCTOR):
    public ProductListPage(WebDriver driver, Locator locator) {
        this.web = driver;
        this.get = locator;
        // ? SELECTORES/PROPIEDADES (dentro Constructor):
        this.inventoryList = () -> this.get.ById("inventory_container");
        this.productItems = () -> this.get.ByClasses("inventory_item");
        this.productPrices = () -> this.get.ByClasses("inventory_item_price");
        this.productDescs = () -> this.get.ByClasses("inventory_item_desc");
        this.productTitles = () -> this.get.ByClasses("inventory_item_name ");
        this.addToCartButton = () -> this.get.Selectors("[data-test*=add-to-cart]");
        this.removeButton = () -> this.get.Selectors("[data-test*=remove]");
        // this.addToCartButton
        // this.sortingDropdown
        // this.burgerMenu
    }

    // ? CREAR MÉTODOS QUE HACE EL USUARIO EN EL COMPONENTE (u otras métodos)

    // *---- GETTERS ---- */
    public WebElement getProductItem(Integer productIndex) {
        WebElement item = this.productItems.get().get(productIndex);
        return item;
    }

    public String getProductPrice(Integer productIndex) {
        WebElement price = this.productPrices.get().get(productIndex);
        String priceValue = price.getText();
        return priceValue;
    }

    // *---- MAIN ACTIONS ---- */
    public void addProductToCart(Integer productIndex) {
        WebElement button = this.addToCartButton.get().get(productIndex);
        button.click();
    }

    public void removeProductFromCart(Integer productIndex) {
        WebElement button = this.removeButton.get().get(productIndex);
        button.click();
    }

    // *---- Navigators ---- */
    public void gotoProductDetails(WebElement givenProduct) {
        WebElement item = this.get.WithinElement(givenProduct, "img");
        item.click();
    }

    // seleccionarProducto(){ obtener el elemento del producto}
}
