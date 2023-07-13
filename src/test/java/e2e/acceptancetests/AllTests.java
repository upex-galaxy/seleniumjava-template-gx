package e2e.acceptancetests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "e2e" }, features = "/src/test/resources/features", format = { "pretty",
        "json:target/cucumber-reports/cucumber.json" }, tags = { "@complete"
        })

public class AllTests {
}