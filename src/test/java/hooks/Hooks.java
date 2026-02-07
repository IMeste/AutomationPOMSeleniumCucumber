package hooks;

import config.ConfigReader;
import config.EnvironmentManager;
import drivers.DriverFactory;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Parameter;
import support.ScreenshotHelper;

import java.util.ArrayList;
import java.util.List;

public class Hooks {

    private boolean injected = false;

    @Before(order = 0)
    public void loadEnvironment(Scenario scenario) {
        EnvironmentManager.init(scenario);
        ConfigReader.init();
        DriverFactory.createDriver();
    }

    @BeforeStep(order = 0)
    public void addBrowserOnce() {
        if (injected) return;
        injected = true;

        Allure.getLifecycle().updateTestCase(tr -> {
            List<Parameter> params = new ArrayList<>(tr.getParameters());
            params.add(new Parameter().setName("browser").setValue(DriverFactory.getBrowser()));
            tr.setParameters(params);
        });
    }

    @Before("@SetCookies")
    public void setCookies() {
        // lógica si aplica
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        String mode = ConfigReader.get("take.screenshot");
        ScreenshotHelper.takeScreenshot(scenario, mode);
    }

    @After
    public void tearDown() {
        ScreenshotHelper.resetCounter();
        DriverFactory.quitDriver();
    }
}
