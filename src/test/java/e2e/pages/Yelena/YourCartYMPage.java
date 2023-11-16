package e2e.pages.Yelena;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Locator;

public class YourCartYMPage {

    WebDriver web;
    Locator get;
    Action Do;
    private Supplier<WebElement> cart;

    public YourCartYMPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;

        this.cart = () -> driver.findElement(By.cssSelector("[class$='shopping_cart_link']"));
    }

    public void ClickCart() {

        this.Do.click(this.cart.get());

    }

}
