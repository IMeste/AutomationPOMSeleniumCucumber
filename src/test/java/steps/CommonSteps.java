package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import utils.ConfigReader;
import java.util.ArrayList;

public class CommonSteps {
    private static WebDriver driver;
    private static int stepCounter = 0;

    @After
    public void resetCounter() {
        stepCounter = 0;
    }

    @Before
    public void setUp() {
        ArrayList<String> optionList = new ArrayList<>();
        ChromeOptions options = new ChromeOptions();
        optionList.add("--headless");
        optionList.add("--start-maximized");
        optionList.add("--incognito");
        options.addArguments(optionList);
        driver = new ChromeDriver(options);
    }

    @Before("@SetCookies")
    public void setCookies() {
    }

    @After("@Test")
    public void testAfterHook() {
        System.out.println("This is the after hook for the @Test tag");
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        String modo = ConfigReader.get("take.screenshot");
        boolean shouldTake = modo != null && (
                modo.equalsIgnoreCase("all") ||
                        (modo.equalsIgnoreCase("failed") && scenario.isFailed())
        );
        if (shouldTake) {
            stepCounter++;
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // Guarda imagen localmente
                Path folder = Paths.get("target", "screenshots/"+scenario.getName().replaceAll(" ", "_"));
                Files.createDirectories(folder);
                Path filePath = folder.resolve(stepCounter + ".png");
                Files.write(filePath, screenshot);

                // Adjunta al reporte de Allure
                io.qameta.allure.Allure.addAttachment("Screenshot", "image/png",
                        new java.io.ByteArrayInputStream(screenshot), "png");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
