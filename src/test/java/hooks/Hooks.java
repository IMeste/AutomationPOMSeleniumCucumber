package hooks;

import config.ConfigReader;
import config.EnvironmentManager;
import drivers.DriverFactory;
import io.cucumber.java.*;

import support.ScreenshotHelper;

public class Hooks {

    @Before(order = 0)
    public void loadEnvironment() {
        // Carga environment desde system property (Maven) o default
        EnvironmentManager.initFromSystem();
    }

    @Before(order = 1)
    public void loadConfig() {
        // Carga el archivo properties correcto
        ConfigReader.init();
    }

    @Before(order = 2)
    public void createDriver() {
        DriverFactory.createDriver();
    }

    @Before(order = 3)
    public void overrideEnvironmentWithTag(Scenario scenario) {
        String tagEnv = EnvironmentManager.getEnvironmentFromTag(scenario);
        if (tagEnv != null) {
            System.setProperty("environment", tagEnv);
            ConfigReader.init(); // recarga el properties
        }
    }

    @Before
    public void setUp() {
        DriverFactory.createDriver();
    }

    @Before("@SetCookies")
    public void setCookies() {
        // lógica si aplica
    }

    @After("@Test")
    public void afterTestTag() {
        System.out.println("This is the after hook for the @Test tag");
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
