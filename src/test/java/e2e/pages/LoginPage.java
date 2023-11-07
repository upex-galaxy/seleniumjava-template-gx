package e2e.pages;

import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Locator;

//*  Tech Debt: GX3-253 = https://upexgalaxy26.atlassian.net/browse/GX3-253
public class LoginPage {
    // SE DIVIDE EN 3 SECTORES PRINCIPALES:

    WebDriver web;
    Locator get;
    Action Do;
    private Supplier<WebElement> usernameInput;
    private Supplier<WebElement> passwordInput;
    private Supplier<WebElement> loginSubmitButton;

    // * ARMAR EL CONSTRUCTOR con WebDriver (para usar los selectores/Locators)
    public LoginPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        // * LOCATORS DE PAGE => dentro del Constructor (requiere tipado Suppiler<>)
        this.usernameInput = () -> this.get.ByTestId("username");
        this.passwordInput = () -> this.get.ByTestId("password");
        this.loginSubmitButton = () -> this.get.ByTestId("login-button");
    }

    // * MÉTODOS CON LOS SELECTORES => métodos public void/String/WebElement/Numbers
    public void enterUsername(String value) {
        this.Do.enterValue(this.usernameInput.get(), value);
    }

    // * MÉTODOS CON LOS SELECTORES => métodos public void/String/WebElement/Numbers
    public void enterPassword(String value) {
        this.Do.enterValue(this.passwordInput.get(), value);
    }

    // * MÉTODOS CON LOS SELECTORES => métodos public void/String/WebElement/Numbers
    public void submitLogin() {
        this.Do.click(this.loginSubmitButton.get());
    }

    public void Login() {
        this.enterUsername("standard_user");
        this.enterPassword("secret_sauce");
        this.submitLogin();
    }
}
