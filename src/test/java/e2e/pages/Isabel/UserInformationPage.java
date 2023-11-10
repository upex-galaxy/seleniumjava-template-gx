package e2e.pages.Isabel;

import java.util.function.Supplier;
import org.openqa.selenium.WebElement;
import e2e.utils.Action;
import e2e.utils.Locator;

public class UserInformationPage {
    Locator get;
    Action Do;
    private Supplier<WebElement> firstName;
    private Supplier<WebElement> lastName;
    private Supplier<WebElement> zip;
    private Supplier<WebElement> continueButton;

    public UserInformationPage(Locator locator, Action action) {
        this.get = locator;
        this.Do = action;
        this.firstName = () -> this.get.Selector("[data-test=firstName]");
        this.lastName = () -> this.get.Selector("[data-test=lastName]");
        this.zip = () -> this.get.Selector("[data-test=postalCode]");
        this.continueButton = () -> this.get.Selector("[data-test=continue]");
    }

    public void enterFirstName(String value) {
        this.Do.enterValue(this.firstName.get(), value);
    }

    public void enterLastName(String value) {
        this.Do.enterValue(this.lastName.get(), value);
    }

    public void enterZipCode(String value) {
        this.Do.enterValue(this.zip.get(), value);
    }

    public void continueToOverview() {
        this.Do.click(this.continueButton.get());
    }

    public void enterUserInformation() {
        this.enterFirstName("Emily");
        this.enterLastName("Perez");
        this.enterZipCode("98052");
        this.continueToOverview();
    }
}
