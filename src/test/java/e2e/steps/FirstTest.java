package e2e.steps;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import e2e.fixtures.TestBase;

public class FirstTest extends TestBase {

    @BeforeEach
    public void precondition() {
        String endpoint = BASE_URL + "/text-box";
        web.get(endpoint);
    }

    @Test
    public void TC1_submitMessageTest() throws InterruptedException {

        WebElement fullNameInput = get.ById("userName");
        WebElement emailInput = get.ById("userEmail");
        WebElement currentAddressInput = get.ById("currentAddress");
        WebElement permanentAddressInput = get.ById("permanentAddress");
        WebElement submitButton = get.ById("submit");

        fullNameInput.sendKeys("UPEX Galaxy");
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