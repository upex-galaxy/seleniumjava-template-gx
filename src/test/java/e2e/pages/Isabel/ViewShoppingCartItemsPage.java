package e2e.pages.Isabel;

import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import e2e.utils.Action;
import e2e.utils.Assertion;
import e2e.utils.Locator;

public class ViewShoppingCartItemsPage {
    WebDriver web;
    Locator get;
    Action Do;
    Assertion validate;
    private Supplier<WebElement> cancelButton;
    private Supplier<WebElement> finishButton;

    // 1. ARMAR EL CONSTRUCTOR con WebDriver (para usar los selectores/Locators)
    public ViewShoppingCartItemsPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        this.validate = new Assertion();

        // 2. LOCATORS DE PAGE => dentro del Constructor (requiere tipado Suppiler<>)
        this.cancelButton = () -> this.get.ByTestId("cancel");
        this.finishButton = () -> this.get.ByTestId("finish");
    }

    // 3. MÉTODOS CON LOS SELECTORES => métodos public
    public void cancelOrder() {
        this.Do.click(this.cancelButton.get());
    }

    public void finishOrder() {
        this.Do.click(this.finishButton.get());
    }
}
