package hooks;

import config.ConfigReader;
import config.EnvironmentManager;
import drivers.DriverFactory;
import io.cucumber.java.*;

import support.ScreenshotHelper;

public class Hooks {

    @Before(order = 0)
    public void initEnvironment(Scenario scenario) {
        EnvironmentManager.init(scenario);
        ConfigReader.init();
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
