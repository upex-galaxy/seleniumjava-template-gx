package e2e.pages.YelenaPages;

import java.io.IOException;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Locator;

public class FormInformationYMPage {
    WebDriver web;
    Locator get;
    Action Do;
    private Supplier<WebElement> firstnameInput;
    private Supplier<WebElement> lastnameInput;
    private Supplier<WebElement> postalcodeInput;
    private Supplier<WebElement> continueButton;

    public FormInformationYMPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        this.firstnameInput = () -> driver.findElement(By.cssSelector("[data-test$='firstName']"));
        this.lastnameInput = () -> driver.findElement(By.cssSelector("[data-test$='lastName']"));
        this.postalcodeInput = () -> driver.findElement(By.cssSelector("[data-test$='postalCode']"));
        this.continueButton = () -> driver.findElement(By.cssSelector("[class$='btn_action']"));
    }

    public void firstName(String textValue) {
        this.Do.enterValue(this.firstnameInput.get(), textValue);
    }

    public void lastName(String textValue) {
        this.Do.enterValue(this.lastnameInput.get(), textValue);
    }

    public void postalCode(String textValue) {
        this.Do.enterValue(this.postalcodeInput.get(), textValue);
    }

    public void submitContinue() throws InterruptedException, IOException {
        this.Do.click(this.continueButton.get());
    }

    public void IngresarDatos() throws InterruptedException, IOException {
        this.firstName("Rosa");
        this.lastName("Ruiz");
        this.postalCode("11200");
        this.submitContinue();
    }

}