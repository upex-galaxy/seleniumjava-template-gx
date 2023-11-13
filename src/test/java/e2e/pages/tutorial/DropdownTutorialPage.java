package e2e.pages.tutorial;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import e2e.utils.Locator;

public class DropdownTutorialPage {

    private Locator get;
    private Supplier<WebElement> productSort;
    private Supplier<Select> itemDropdown;

    public DropdownTutorialPage(Locator locator) {

        this.get = locator;
        this.productSort = () -> this.get.ByTestId("product_sort_container");
        this.itemDropdown = () -> new Select(this.productSort.get());
    }

    public void sortItemsByNameASC() {
        this.itemDropdown.get().selectByValue("az");
    }
    // ?.... también puedes añadir más como:
    // ? "sortItemsByPriceDESC" o "sortItemsByPriceASC"

    // ? También puedes usar métodos que pases por parámetro el valor.
    public void selectSortByIndex(Integer option) {
        this.itemDropdown.get().selectByIndex(option);
    }

    public void selectSortByValue(String option) {
        this.itemDropdown.get().selectByValue(option);
    }
    // ? Sin embargo, estos últimos pueden bien ser creados en Locator.java */
}
