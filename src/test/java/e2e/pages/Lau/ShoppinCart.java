package e2e.pages.Lau;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Locator;

public class ShoppinCart {
    private Locator get;
    private Action Do;
    private Supplier<List<WebElement>> cartItems;
    private Supplier<List<WebElement>> qtyItems;
    private Supplier<List<WebElement>> descriptionItems;

    public ShoppinCart(Locator locator, Action action) {
        this.get = locator;
        this.Do = action;
        this.cartItems = () -> this.get.ByClasses("cart_item");
        this.qtyItems = () -> this.get.ByClasses("cart_quantity");
        this.descriptionItems = () -> this.get.ByClasses("cart_item_label");
    }

    public Integer getQtyProducts() {
        return this.cartItems.get().size();
    }
}
