package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/saucedemo",
        glue = {"steps.saucedemo", "hooks", "support"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/saucedemo.html",
                "json:target/cucumber-reports/saucedemo.json",
                "junit:target/cucumber-reports/saucedemo.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class SauceDemoRunner {
}
