package drivers;

import config.ConfigReader;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;
    private static BrowserType browser;
    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void createDriver() {
        if (driver == null) {
            boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
            int timeout = Integer.parseInt(ConfigReader.get("timeout"));
            browser = BrowserType.from(System.getProperty("browser", ConfigReader.get("browser")));

            log.info("Inicializando WebDriver | browser={} | headless={} | timeout={}s",
                    browser.name().toLowerCase(), headless, timeout);

            switch (browser) {
                case CHROME -> driver = new ChromeDriver(buildChromeOptions(headless));
                case FIREFOX -> driver = new FirefoxDriver(buildFirefoxOptions(headless));
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            log.info("Cerrando WebDriver | browser={}", getBrowser());
            driver.quit();
            driver = null;
        }
    }

    public static ChromeOptions buildChromeOptions(boolean headless){
        ArrayList<String> optionListChrome = new ArrayList<>();
        ChromeOptions optionsChrome = new ChromeOptions();
        if (headless) {
            optionListChrome.add("--headless=new");
            optionListChrome.add("--no-sandbox");
            optionListChrome.add("--disable-dev-shm-usage");
            optionListChrome.add("--window-size=1920,1080");
        } else {
            optionListChrome.add("--start-maximized");
        }
        optionListChrome.add("--incognito");
        optionListChrome.add("--lang=es-CL");
        optionsChrome.addArguments(optionListChrome);

        // Fuerza también el idioma/formato a nivel de preferencias internas de Chrome
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "es-CL,es");
        optionsChrome.setExperimentalOption("prefs", prefs);

        return optionsChrome;
    }

    public static FirefoxOptions buildFirefoxOptions(boolean headless){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (headless) {
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--width=1920");
            firefoxOptions.addArguments("--height=1080");
        } else {
            firefoxOptions.addArguments("--start-maximized");
        }

        // Preferencias para estabilidad
        firefoxOptions.addPreference("dom.webnotifications.enabled", false); // bloquea popups de notificaciones
        firefoxOptions.addPreference("geo.enabled", false);                  // bloquea popups de geolocalización
        firefoxOptions.addPreference("media.volume_scale", "0.0");           // silencia audio

        // Locale real usado por la API Intl (esto es lo que faltaba)
        firefoxOptions.addPreference("intl.locale.requested", "es-CL");
        // Complementario: navigator.language / Accept-Language
        firefoxOptions.addPreference("intl.accept_languages", "es-CL,es");

        return firefoxOptions;
    }

    public static String getBrowser() {
        return browser.name().toLowerCase();
    }
}
