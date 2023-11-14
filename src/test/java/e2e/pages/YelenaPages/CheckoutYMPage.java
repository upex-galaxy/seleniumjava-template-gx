
package e2e.pages.YelenaPages;

import java.io.IOException;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Locator;

public class CheckoutYMPage {
    WebDriver web;
    Locator get;
    Action Do;
    private Supplier<WebElement> buttoncheck;

    public CheckoutYMPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;

        this.buttoncheck = () -> driver.findElement(By.cssSelector("[data-test$='checkout']"));

    }

    public void ClickCheckout() {

        this.Do.click(this.buttoncheck.get());
        // Thread.sleep(5000);
    }

}
