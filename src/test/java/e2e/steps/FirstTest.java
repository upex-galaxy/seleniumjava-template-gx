package e2e.steps;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebElement;
import e2e.fixtures.TestBase;

@RunWith(JUnit4.class)
public class FirstTest extends TestBase {
    @Test
    public void TC1_submitMessageTest() throws InterruptedException {
        String title = web.getTitle();
        then.shouldBeEqual(title, "Web form");

        WebElement textBox = get.ByName("my-text");
        WebElement submitButton = get.ByTag("button");

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = get.ById("message");
        String value = message.getText();
        then.shouldBeEqual(value, "Received!");
        Thread.sleep(1000); // todo: Esperamos 1 segundo para poder ver con nuestros ojos el assertion.
    }
}