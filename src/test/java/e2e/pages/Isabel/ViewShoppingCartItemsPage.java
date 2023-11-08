package e2e.pages.Isabel;

import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import e2e.utils.Action;
import e2e.utils.Locator;

public class ViewShoppingCartItemsPage {
    WebDriver web;
    Locator get;
    Action Do;

    private Supplier<WebElement> cancelButton;
    private Supplier<WebElement> finishButton;

    public ViewShoppingCartItemsPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        this.cancelButton = () -> this.get.ByTestId("cancel");
        this.finishButton = () -> this.get.ByTestId("finish");
    }

    public void cancelOrder() {
        this.Do.click(this.cancelButton.get());
    }

    public void finishOrder() {
        this.Do.click(this.finishButton.get());
    }
}
