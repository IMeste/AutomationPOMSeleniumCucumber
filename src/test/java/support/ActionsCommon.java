package support;

import org.openqa.selenium.WebDriver;

public class ActionsCommon {

    private final WebDriver driver;

    public ActionsCommon(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
