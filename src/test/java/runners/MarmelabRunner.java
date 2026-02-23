package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/marmelab",
        glue = {"steps.marmelab", "hooks", "support"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/marmelab.html",
                "json:target/cucumber-reports/marmelab.json",
                "junit:target/cucumber-reports/marmelab.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class MarmelabRunner {
}

