package e2e.hooks;

import javax.inject.Inject;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private final WebDriver driver;

    @Inject
    public Hooks(final WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void openWebSite() {
        driver.navigate().to("http://www.google.co.uk");
    }

    @After
    public void closeSession() {
        driver.close();
    }
}
