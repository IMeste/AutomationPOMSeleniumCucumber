package drivers;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
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
        if (driver == null) {
            String browser = System.getProperty("browser") != null
                    ? System.getProperty("browser")
                    : ConfigReader.get("browser");
            boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
            int timeout = Integer.parseInt(ConfigReader.get("timeout"));

            switch (browser) {
                case "chromium":
                    ArrayList<String> optionListChromium = new ArrayList<>();
                    ChromeOptions optionsChromium = new ChromeOptions();
                    if (headless) {
                        optionListChromium.add("--headless=new");
                        optionListChromium.add("--no-sandbox");
                        optionListChromium.add("--disable-dev-shm-usage");
                    }
                    optionListChromium.add("--start-maximized");
                    optionListChromium.add("--incognito");
                    optionsChromium.addArguments(optionListChromium);
                    driver = new ChromeDriver(optionsChromium);
                    break;

                case "chrome":
                    ArrayList<String> optionListChrome = new ArrayList<>();
                    ChromeOptions optionsChrome = new ChromeOptions();
                    if (headless) {
                        optionListChrome.add("--headless=new");
                        optionListChrome.add("--no-sandbox");
                        optionListChrome.add("--disable-dev-shm-usage");
                    }
                    optionListChrome.add("--start-maximized");
                    optionListChrome.add("--incognito");
                    optionsChrome.addArguments(optionListChrome);
                    driver = new ChromeDriver(optionsChrome);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless) firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    throw new RuntimeException("Navegador no soportado: " + browser);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
