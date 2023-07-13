package e2e.steps;

import javax.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;

import java.util.List;

public class ExampleSteps {

    @Inject
    private WebDriver webDriver;

    @Given("^I search for \"([^\"]*)\"$")
    public void i_search_for(String arg1) {
        webDriver.get("https://www.google.com/");
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");
        searchBox.submit();
    }

    @Then("^google should show me results!$")
    public void should_show_me_results() {
        List<WebElement> results = webDriver.findElement(By.id("rso")).findElements(By.xpath("./*"));
        WebElement option = results.get(0).findElement(By.tagName("link"));
        String link = option.getAttribute("href");
        assertEquals("https://www.selenium.dev/", link);
    }
}