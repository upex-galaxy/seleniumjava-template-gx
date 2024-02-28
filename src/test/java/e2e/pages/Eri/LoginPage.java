package e2e.pages.Eri;

//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import java.util.List;
import java.util.function.Supplier;

//import org.openqa.selenium.By;
import org.openqa.selenium.*;

//import e2e.pages.Eri.ProductDetailsPage;
import e2e.utils.*;

//* Tech Debt: GX3-248 =https://upexgalaxy26.atlassian.net/browse/GX3-248 */
public class LoginPage {

    // Login
    WebDriver web;
    Locator get;
    Action Do;
    Assertion validate;
    Supplier<WebElement> usernameInput;
    Supplier<WebElement> passwordInput;
    Supplier<WebElement> loginSubmitButton;

    // * #1 ARMAR EL CONSTRUCTOR con WebDriver (para usar los selectores/Locators)
    public LoginPage(WebDriver driver, Locator locator, Action action) {
        this.web = driver;
        this.get = locator;
        this.Do = action;
        this.validate = new Assertion();

        // * #2 LOCATORS DE PAGE => dentro del Constructor (requiere tipado Suppiler<>)
        // login
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