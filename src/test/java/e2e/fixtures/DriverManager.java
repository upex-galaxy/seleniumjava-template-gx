package e2e.fixtures;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    public WebDriver setChromeDriver() {
        return WebDriverManager.chromedriver().create();
    }

    public WebDriver setFirefoxDriver() {
        return WebDriverManager.firefoxdriver().create();
    }

    public WebDriver setEdgeDriver() {
        return WebDriverManager.edgedriver().create();
    }
    // todo: If another Browser Driver Setup is needed, create another one here.
}
