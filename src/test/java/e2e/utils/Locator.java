package e2e.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Locator {

    private WebDriver selenium;

    // *Constructor:
    public Locator(final WebDriver driver) {
        this.selenium = driver;
    }

    public WebElement Selector(String css_selector) {
        return this.selenium.findElement(By.cssSelector(css_selector));
    }

    public WebElement Xpath(String xpath_selector) {
        return this.selenium.findElement(By.xpath(xpath_selector));
    }

    public WebElement ByTestId(String testid_name) {
        String data_test_id = String.format("[data-testid=%s]", testid_name);
        return this.selenium.findElement(By.cssSelector(data_test_id));
    }

    public WebElement ById(String id) {
        return this.selenium.findElement(By.id(id));
    }

    public WebElement ByName(String name) {
        return this.selenium.findElement(By.name(name));
    }

    public WebElement ByTag(String tag) {
        return this.selenium.findElement(By.tagName(tag));
    }

    public WebElement ByClass(String class_name) {
        return this.selenium.findElement(By.className(class_name));
    }

    public WebElement BySpecClass(String class_selection) {
        String selector = String.format("[class*=%s]", class_selection);
        return this.selenium.findElement(By.cssSelector(selector)); // Specific Class selector
    }

    public WebElement EqualText(String text) {
        return this.selenium.findElement(By.linkText(text));
    }

    public WebElement ContainText(String text) {
        return this.selenium.findElement(By.partialLinkText(text));
    }
}
