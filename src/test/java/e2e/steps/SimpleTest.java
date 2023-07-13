package e2e.steps;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.utils.Locator;

import io.github.bonigarcia.wdm.WebDriverManager;

// ! Este Test Suite es de Ejemplo. Aquí no se usa el Test Base, pero se aprecia el beforeEach. Se recomienda el uso del TestBase.
@RunWith(JUnit4.class)
public class SimpleTest {

    Locator get;

    WebDriver web;

    @BeforeEach
    public void setUp() {
        web = WebDriverManager.chromedriver().create();
        get = new Locator(web);
        web.manage().window().maximize();
    }

    @Test
    public void testSimple() throws InterruptedException {
        web.get("https://google.com");

        WebElement searchBar = get.ByName("q");

        searchBar.sendKeys("UPEX");
        searchBar.sendKeys(Keys.ENTER);

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
