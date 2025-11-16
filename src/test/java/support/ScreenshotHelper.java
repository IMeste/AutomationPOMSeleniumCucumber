package support;

import drivers.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotHelper {

    private static int stepCounter = 0;

    public static void resetCounter() {
        stepCounter = 0;
    }

    public static void takeScreenshot(Scenario scenario, String mode) {
        boolean shouldTake = mode != null && (
                mode.equalsIgnoreCase("all") ||
                        (mode.equalsIgnoreCase("failed") && scenario.isFailed())
        );

        if (!shouldTake) return;

        stepCounter++;

        try {
            byte[] screenshot =
                    ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);

            Path folder = Paths.get("target", "screenshots/" +
                    scenario.getName().replaceAll(" ", "_"));
            Files.createDirectories(folder);

            Path filePath = folder.resolve(stepCounter + ".png");
            Files.write(filePath, screenshot);

            io.qameta.allure.Allure.addAttachment(
                    "Screenshot",
                    "image/png",
                    new java.io.ByteArrayInputStream(screenshot),
                    "png"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
