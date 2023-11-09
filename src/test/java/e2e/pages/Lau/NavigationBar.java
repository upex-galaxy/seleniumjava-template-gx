package e2e.pages.Lau;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import e2e.utils.Action;
import e2e.utils.Locator;

public class NavigationBar {
    // ?get selectors of burguer menu and SC icons ,also for the options of the
    // burguer menu
    private Locator get;
    private Driver web;
    private Action Do;
    private Supplier<WebElement> burguerMenuIcon;
    private Supplier<WebElement> ShoppinCartIcon;
    private Supplier<List<WebElement>> burguerMenuOptions;
    private Supplier<WebElement> SCProducts;

    public NavigationBar(Driver driver, Locator locator, Action action) {
        this.get = locator;
        this.web = driver;
        this.Do = action;
        // Inicialice selectors
        this.burguerMenuIcon = () -> this.get.ById("menu_button_container");
        this.ShoppinCartIcon = () -> this.get.ById("shopping_cart_container");
        this.burguerMenuOptions = () -> this.get.Selectors(".bm-item");
        this.SCProducts = () -> this.get.ByClass("shopping_cart_badge");
    }

    // ?methods: click on burguer menu and SC icons, and select burguer menu option
    public void clickSCIcon() {
        this.Do.click(this.ShoppinCartIcon.get());
    }

    public String getQtyItemsSC() {
        return this.SCProducts.get().getText();
    }

    public void clickMenuIcon() {
        this.Do.click(this.burguerMenuIcon.get());
    }

    public void selectMenuOption(Integer indexOption) {
        WebElement option = this.burguerMenuOptions.get().get(indexOption);
        this.Do.click(option);
    }
}
