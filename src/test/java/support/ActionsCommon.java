package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;

public class ActionsCommon {

    private final WebDriver driver;
    private DriverFactory commonSteps;

    public ActionsCommon() {
        this.driver = DriverFactory.getDriver();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void clickLinkByText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void quitWebDriver() {
        driver.quit();
    }
}
