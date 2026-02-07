package hooks;

import config.ConfigReader;
import config.EnvironmentManager;
import drivers.DriverFactory;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import support.ScreenshotHelper;

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

        // Asocia el test a un navegador, el cual se visualizara en el nombre en el reporte de Allure
        Allure.getLifecycle().updateTestCase(tc ->
                tc.setName(tc.getName() + " [" + DriverFactory.getBrowser() + "]")
        );
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
