package e2e.fixtures;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import e2e.utils.Locator;
import e2e.utils.Action;
import e2e.utils.Assertion;

public class TestBase {
    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php";
    private static final DriverManager MANAGER = new DriverManager();
    public WebDriver web;
    public Locator get;
    public Assertion then;
    public Action Do;

    @BeforeEach
    public void setup() {
        web = MANAGER.setChromeDriver();
        get = new Locator(web);
        then = new Assertion();
        Do = new Action(web);
        web.manage().window().maximize();
        web.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
