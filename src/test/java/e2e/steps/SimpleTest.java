package e2e.steps;

import java.time.Duration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import e2e.utils.Assertion;
import e2e.utils.Locator;
import io.github.bonigarcia.wdm.WebDriverManager;

// ! Este Test Suite es de Ejemplo. Aquí no se usa el Test Base, pero se aprecia el beforeEach. Se recomienda el uso del TestBase.
public class SimpleTest {

    Locator get;
    WebDriver web;
    Assertion then;

    @BeforeEach
    public void setUp() {
        web = WebDriverManager.chromedriver().create();
        get = new Locator(web);
        then = new Assertion();
        web.get("https://demoqa.com/text-box");
        web.manage().window().maximize();
        web.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void testSimple() throws InterruptedException {
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

    @AfterEach
    public void tearDown() {
        try {
            web.quit();
        } catch (Exception log) {
            System.out.println("Error while closing browser: " + log.getMessage());
        }
    }
}
