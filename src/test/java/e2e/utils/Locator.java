package e2e.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
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

    public WebElement ReactTool(String property_name) {
        String locator = String.format("[data-react-toolbox=\"%s\"]", property_name);
        return this.selenium.findElement(By.cssSelector(locator));
    }

    public List<WebElement> Selectors(String css_selector) {
        return this.selenium.findElements(By.cssSelector(css_selector));
    }

    public WebElement Xpath(String xpath_selector) {
        return this.selenium.findElement(By.xpath(xpath_selector));
    }

    public List<WebElement> Xpaths(String xpath_selector) {
        return this.selenium.findElements(By.xpath(xpath_selector));
    }

    public WebElement ByTestId(String testid_name) {
        String data_test_id = String.format("[data-test=%s]", testid_name);
        return this.selenium.findElement(By.cssSelector(data_test_id));
    }

    public List<WebElement> ByTestIds(String testid_name) {
        String data_test_id = String.format("[data-test=%s]", testid_name);
        return this.selenium.findElements(By.cssSelector(data_test_id));
    }

    public WebElement ById(String id) {
        return this.selenium.findElement(By.id(id));
    }

    public List<WebElement> ByIds(String id) {
        return this.selenium.findElements(By.id(id));
    }

    public WebElement ByRole(String role) {
        String roleAttr = String.format("[role=\"%s\"]", role);
        return this.selenium.findElement(By.cssSelector(roleAttr));
    }

    public List<WebElement> ByRoles(String role) {
        String roleAttr = String.format("[role=\"%s\"]", role);
        return this.selenium.findElements(By.cssSelector(roleAttr));
    }

    public WebElement ByName(String name) {
        return this.selenium.findElement(By.name(name));
    }

    public List<WebElement> ByNames(String name) {
        return this.selenium.findElements(By.name(name));
    }

    public WebElement ByTag(String tag) {
        return this.selenium.findElement(By.tagName(tag));
    }

    public List<WebElement> ByTags(String tag) {
        return this.selenium.findElements(By.tagName(tag));
    }

    public WebElement ByClass(String class_name) {
        return this.selenium.findElement(By.className(class_name));
    }

    public List<WebElement> ByClasses(String class_name) {
        return this.selenium.findElements(By.className(class_name));
    }

    public WebElement BySpecClass(String class_selection) {
        String selector = String.format("[class*=%s]", class_selection);
        return this.selenium.findElement(By.cssSelector(selector)); // Specific Class selector
    }

    public List<WebElement> BySpecClasses(String class_selection) {
        String selector = String.format("[class*=%s]", class_selection);
        return this.selenium.findElements(By.cssSelector(selector)); // Specific Class selector
    }

    public WebElement ByEqualText(String text) {
        String elementToFind = String.format("//*[text()=\"%s\"]", text);
        return this.selenium.findElement(By.xpath(elementToFind));
    }

    public List<WebElement> ByEqualTexts(String text) {
        String elementToFind = String.format("//*[text()=\"%s\"]", text);
        return this.selenium.findElements(By.xpath(elementToFind));
    }

    public WebElement ByContainText(String text) {
        String elementToFind = String.format("//*[contains(text(),\"%s\")]", text);
        return this.selenium.findElement(By.xpath(elementToFind));
    }

    public List<WebElement> ByContainTexts(String text) {
        String elementToFind = String.format("//*[contains(text(),\"%s\")]", text);
        return this.selenium.findElements(By.xpath(elementToFind));
    }

    public List<WebElement> WithinElements(WebElement parent, String target_selector) {
        return parent.findElements(By.cssSelector(target_selector));
    }

    public WebElement WithinElement(WebElement parent, String target_selector) {
        return parent.findElement(By.cssSelector(target_selector));
    }

    public WebElement WithinTextElement(String parent_attr, String target_text) {
        String parentElement = String.format("//*[@%s]", parent_attr);
        String targetElement = String.format("//*[contains(text(),\"%s\")]", target_text);
        String locator = parentElement.concat(targetElement);
        return this.selenium.findElement(By.xpath(locator));
    }

    public WebElement WithinExactTextElement(String parent_attr, String target_text) {
        String parentElement = String.format("//*[@%s]", parent_attr);
        String targetElement = String.format("//*[text()=\"%s\")]", target_text);
        String locator = parentElement.concat(targetElement);
        return this.selenium.findElement(By.xpath(locator));
    }

    public WebElement FilterByText(String filter_text, Integer parent_target) {
        String index = Integer.toString(parent_target);
        String locator = String.format("//*[text()=\"%s\"]/ancestor::*[%s]", filter_text, index);
        return this.selenium.findElement(By.xpath(locator));
    }

    public List<WebElement> FilterByElement(String target_selector, String filter_selector) {
        String locator = String.format("%s:has(%s)", target_selector, filter_selector);
        return this.selenium.findElements(By.cssSelector(locator));
    }

    public List<WebElement> FilterByNotElement(String target_selector, String filter_selector) {
        String locator = String.format("%s:not(%s)", target_selector, filter_selector);
        return this.selenium.findElements(By.cssSelector(locator));
    }

    // * other Locators for specific cases */
    public Select Dropdown(WebElement dropdownSelectBox) {
        Select dropdown = new Select(dropdownSelectBox);
        return dropdown;
    }
}
