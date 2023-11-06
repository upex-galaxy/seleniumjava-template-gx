package e2e.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Action {
    private Actions action;
    private WebDriver web;

    // *Constructor:
    public Action(final WebDriver driver) {
        this.web = driver;
        this.action = new Actions(this.web);
    }

    public void enterValue(WebElement locator, String value) {
        action.sendKeys(locator, value).perform();
    }

    public void click(WebElement locator) {
        action.click(locator).perform();
    }

    public void dbClick(WebElement locator) {
        action.doubleClick(locator).perform();
    }

    public void rightClick(WebElement locator) {
        action.contextClick(locator).perform();
    }

    // *---- KEYBOARD ---- */
    public void pressKeyDown() throws IOException {
        action.keyDown(Keys.ARROW_DOWN).perform();
        action.keyUp(Keys.ARROW_DOWN).perform();
    }

    public void pressEnter() throws IOException {
        action.keyDown(Keys.ENTER).perform();
        action.keyUp(Keys.ENTER).perform();
    }

    // *---- SCREENSHOTS---- */

    public void screenshot() throws IOException {
        File scrFile = ((TakesScreenshot) this.web).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/test/java/e2e/screenshots/testEvidence.png"));
    }

    // * ---- Waiters ---- (No USAR AÚN)
    public void waitForElement(WebElement element) throws InterruptedException {
        // Declare and initialise a fluent wait
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(this.web);
        // Specify the timout of the wait
        wait.wait(5000);
        // Specify polling time
        wait.pollingEvery(Duration.ofMillis(5000));
        // This is how we specify the condition to wait on.
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}