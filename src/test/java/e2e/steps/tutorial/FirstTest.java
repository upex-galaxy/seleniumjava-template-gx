package e2e.steps.tutorial;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import e2e.fixtures.TestBase;

public class FirstTest extends TestBase {

    @BeforeEach
    @DisplayName("Given user is in TextBox Page")
    public void precondition() {
        web.get("https://demoqa.com/text-box");
    }

    @Test
    @DisplayName("TC1: Should submit message")
    public void TestCase_1() throws InterruptedException {

        WebElement fullNameInput = get.ById("userName");
        WebElement emailInput = get.ById("userEmail");
        WebElement currentAddressInput = get.ById("currentAddress");
        WebElement permanentAddressInput = get.ById("permanentAddress");
        WebElement submitButton = get.ById("submit");

        Do.enterValue(fullNameInput, "UPEX Galaxy");
        emailInput.sendKeys("upexgalaxy@upex.com");
        currentAddressInput.sendKeys("Chicago");
        permanentAddressInput.sendKeys("U.S.A");
        submitButton.click();

        WebElement output = get.Selector("#output p");
        String value = output.getText();
        then.shouldBeEqual(value, "Name:UPEX Galaxy");
        Thread.sleep(1000); // todo: Esperamos 1 segundo para poder ver con nuestros ojos el assertion.
    }
}