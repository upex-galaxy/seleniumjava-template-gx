package e2e.pages.Yelena;

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
    private Supplier<WebElement> cancelButton;

    public FormInformationYMPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        this.firstnameInput = () -> driver.findElement(By.cssSelector("[data-test$='firstName']"));
        this.lastnameInput = () -> driver.findElement(By.cssSelector("[data-test$='lastName']"));
        this.postalcodeInput = () -> driver.findElement(By.cssSelector("[data-test$='postalCode']"));
        this.continueButton = () -> driver.findElement(By.cssSelector("[class$='btn_action']"));
        this.cancelButton = () -> driver.findElement(By.cssSelector("[data-test$='cancel']"));
    }

    public void IngresarNombre(String textValue) {
        this.Do.enterValue(this.firstnameInput.get(), textValue);
    }

    public void IngresarApellido(String textValue) {
        this.Do.enterValue(this.lastnameInput.get(), textValue);
    }

    public void IngresarCodePostal(String textValue) {
        this.Do.enterValue(this.postalcodeInput.get(), textValue);
    }

    public void buttonContinue() throws InterruptedException, IOException {
        this.Do.click(this.continueButton.get());
    }

    public void buttonCancel() throws InterruptedException, IOException {
        this.Do.click(this.cancelButton.get());
    }

    public void IngresarDatosValidos() throws InterruptedException, IOException {
        this.IngresarNombre("Rosa");
        this.IngresarApellido("Ruiz");
        this.IngresarCodePostal("11200");
        this.buttonContinue();
    }

    public void CamposNulos() throws InterruptedException, IOException {
        this.IngresarNombre("");
        this.IngresarApellido("");
        this.IngresarCodePostal("");
        this.buttonContinue();
    }

    public void CampoFirstNameNulo() throws InterruptedException, IOException {
        this.IngresarNombre("");
        this.IngresarApellido("Rosales");
        this.IngresarCodePostal("M4800");
        this.buttonContinue();
    }

    public void CampoLastNameNulo() throws InterruptedException, IOException {
        this.IngresarNombre("Marcos");
        this.IngresarApellido("");
        this.IngresarCodePostal("45200");
        this.buttonContinue();
    }

    public void CampoCodePostalNulo() throws InterruptedException, IOException {
        this.IngresarNombre("Isabel");
        this.IngresarApellido("Santos");
        this.IngresarCodePostal("");
        this.buttonContinue();
    }

    public void Cancelar() throws InterruptedException, IOException {
        this.IngresarNombre("Roberto");
        this.IngresarApellido("Flores");
        this.IngresarCodePostal("NY1200");
        this.buttonCancel();
    }
}