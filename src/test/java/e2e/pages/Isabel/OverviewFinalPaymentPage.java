package e2e.pages.Isabel;

import java.util.function.Supplier;
import org.openqa.selenium.WebElement;
import e2e.utils.Action;
import e2e.utils.Locator;

public class OverviewFinalPaymentPage {
    Locator get;
    Action Do;

    private Supplier<WebElement> cancelButton;
    private Supplier<WebElement> finishButton;
    private Supplier<WebElement> confirmationMessage;

    public OverviewFinalPaymentPage(Locator locator, Action action) {
        this.get = locator;
        this.Do = action;
        this.cancelButton = () -> this.get.Selector("[data-test=cancel]");
        this.finishButton = () -> this.get.Selector("[data-test=finish]");
        this.confirmationMessage = () -> this.get.Selector("[class=complete-header]");

        // this.confirmationMessage = () -> this.get.ByClass("complete-header");
    }

    public void cancelOrder() {
        this.Do.click(this.cancelButton.get());
    }

    public void finishOrder() {
        this.Do.click(this.finishButton.get());
    }

    public WebElement getConfirmationCompletionMessage() {
        this.Do.click(this.finishButton.get());
        return this.confirmationMessage.get();
    }
}
