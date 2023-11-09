package e2e.pages.Lau;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Locator;

public class ProductListPage {
    private Locator get;
    private Action Do;
    private Supplier<List<WebElement>> addProductBtns;
    Random random = new Random();

    public ProductListPage(Locator locator, Action action) {
        this.get = locator;
        this.Do = action;
        this.addProductBtns = () -> this.get.Selectors("[data-test*=add-to-cart]");
    }

    public void AddProducts(Integer indexProduct) {
        this.Do.click(this.addProductBtns.get().get(indexProduct));
    }

    public void AddRandomProducts() {
        Integer size = this.addProductBtns.get().size();
        Integer Qty = random.nextInt(size);
        for (int i = 0; i < Qty; i++) {
            Integer actualSize = this.addProductBtns.get().size();
            this.AddProducts(random.nextInt(actualSize));
        }
    }
}
