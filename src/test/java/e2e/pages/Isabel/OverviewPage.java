package e2e.pages.Isabel;

import java.util.function.Supplier;
import org.openqa.selenium.WebElement;
import e2e.utils.Action;
import e2e.utils.Locator;

public class OverviewPage {
    Locator get;
    Action Do;

    private Supplier<WebElement> cancelButton;
    private Supplier<WebElement> finishButton;

    public OverviewPage(Locator locator, Action action) {
        this.get = locator;
        this.Do = action;
        this.cancelButton = () -> this.get.Selector("[data-test=cancel]");
        this.finishButton = () -> this.get.Selector("[data-test=finish]");
    }

    public void cancelOrder() {
        this.Do.click(this.cancelButton.get());
    }

    public void finishOrder() {
        this.Do.click(this.finishButton.get());
    }
}
