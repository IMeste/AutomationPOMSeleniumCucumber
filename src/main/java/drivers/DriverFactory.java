package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void createDriver() {
        ArrayList<String> optionList = new ArrayList<>();
        ChromeOptions options = new ChromeOptions();
        optionList.add("--headless");
        optionList.add("--start-maximized");
        optionList.add("--incognito");
        options.addArguments(optionList);

        driver = new ChromeDriver(options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
