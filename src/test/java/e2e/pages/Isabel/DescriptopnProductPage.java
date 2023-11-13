package e2e.pages.Isabel;

import java.util.function.Supplier;
import org.openqa.selenium.WebElement;
import e2e.utils.Action;
import e2e.utils.Locator;

public class DescriptopnProductPage {
    Action Do;
    Locator get;
    private Supplier<WebElement> checkoutButton;

    public DescriptopnProductPage(Locator locator, Action action) {
        this.Do = action;
        this.get = locator;
        this.checkoutButton = () -> this.get.Selector("[data-test=checkout]");
    }

    public void selectCheckoutButton() {
        this.Do.click(this.checkoutButton.get());
    }
}
