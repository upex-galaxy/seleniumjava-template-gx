package e2e.fixtures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    public WebDriver setChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        String headlessValue = System.getProperty("headless");
        if (headlessValue != null && "true".equalsIgnoreCase(headlessValue)) {
            options.addArguments("--headless");
        }
        return WebDriverManager.chromedriver().capabilities(options).create();
    }

    public WebDriver setFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        String headlessValue = System.getProperty("headless");
        if (headlessValue != null && "true".equalsIgnoreCase(headlessValue)) {
            options.addArguments("--headless");
        }
        return WebDriverManager.firefoxdriver().capabilities(options).create();
    }

    public WebDriver setEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        String headlessValue = System.getProperty("headless");
        if (headlessValue != null && "true".equalsIgnoreCase(headlessValue)) {
            options.addArguments("--headless");
        }
        return WebDriverManager.edgedriver().capabilities(options).create();
    }
    // todo: If another Browser Driver Setup is needed, create another one here.
}
