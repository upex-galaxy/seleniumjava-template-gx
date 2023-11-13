package e2e.pages.Lau;

import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Action;
import e2e.utils.Locator;

public class LoginPage {

    private WebDriver web;
    private Locator get;
    private Action Do;
    private Supplier<WebElement> usernameInput;
    private Supplier<WebElement> passwordInput;
    private Supplier<WebElement> submitButton;

    // ?Constructor
    public LoginPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        // ?Selectors
        this.usernameInput = () -> this.get.Selector("[data-test=username]");
        this.passwordInput = () -> this.get.Selector("[data-test=password]");
        this.submitButton = () -> this.get.Selector("[data-test=login-button]");
    }

    // ?Metods
    public void enterUsername(String value) {
        this.Do.enterValue(this.usernameInput.get(), value);
    }

    public void enterPassword(String value) {
        this.Do.enterValue(this.passwordInput.get(), value);
    }

    public void submitLogin() {
        this.Do.click(this.submitButton.get());
    }

    public void Login(String user, String pwd) {
        this.enterUsername(user);
        this.enterPassword(pwd);
        this.submitLogin();
    }
}
