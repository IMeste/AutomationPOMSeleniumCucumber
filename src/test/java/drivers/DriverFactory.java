package drivers;

import config.ConfigReader;
import enums.BrowserType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
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
    private static final String APP_LOCALE = "es-CL";
    private static final String APP_TZ = "America/Santiago";

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
                case CHROME -> driver = createChromeDriver(headless);
                case FIREFOX -> driver = createFirefoxDriver(headless);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));

            Object intl = ((JavascriptExecutor) driver).executeScript(
                    "return JSON.stringify({" +
                            "  intl: Intl.DateTimeFormat().resolvedOptions().locale," +
                            "  navLang: navigator.language," +
                            "  sample: new Date(2026,6,15).toLocaleDateString()" +
                            "});");
            log.info("Contexto de formato del navegador: {}", intl);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            log.info("Cerrando WebDriver | browser={}", getBrowser());
            driver.quit();
            driver = null;
        }
    }

    // Metodo para ajustar la zona horario
    private static WebDriver createChromeDriver(boolean headless) {
        ChromeDriver chrome = new ChromeDriver(buildChromeOptions(headless));
        chrome.executeCdpCommand("Emulation.setLocaleOverride", Map.of("locale", APP_LOCALE));
        chrome.executeCdpCommand("Emulation.setTimezoneOverride", Map.of("timezoneId", APP_TZ));
        return chrome;
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

    // Metodo para ajustar la zona horario
    private static WebDriver createFirefoxDriver(boolean headless) {
        GeckoDriverService service = new GeckoDriverService.Builder()
                .withEnvironment(Map.of(
                        "TZ", APP_TZ,
                        "LANG", "es_CL.UTF-8",
                        "LC_ALL", "es_CL.UTF-8"))
                .build();
        return new FirefoxDriver(service, buildFirefoxOptions(headless));
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

        // Fuerza a Gecko a usar el locale de la app, no la config regional del SO
        firefoxOptions.addPreference("intl.regional_prefs.use_os_locales", true);
        // Complementario: navigator.language / Accept-Language
        firefoxOptions.addPreference("intl.accept_languages", "es-CL,es");

        return firefoxOptions;
    }

    public static String getBrowser() {
        return browser.name().toLowerCase();
    }
}
