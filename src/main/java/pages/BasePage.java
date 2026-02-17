package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean isElementVisible(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    protected void click(By locator, String elementName) {
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            throw new AssertionError(
                    String.format(
                            "[ACTION FAILED] Element: %s | Locator: %s | Action: click | Error: %s",
                            elementName,
                            locator,
                            e.getClass().getSimpleName()
                    )
            );
        }
    }

    protected void type(By locator, String text, String elementName) {
        try {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new AssertionError(String.format(
                    "[ACTION FAILED] Element: %s | Locator: %s | Action: type | Error: %s",
                    elementName,
                    locator,
                    e.getClass().getSimpleName()
            ), e);
        }
    }

    protected String getText(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.isEmpty()){
            return null;
        }else {
            return elements.get(0).getText();
        }
    }
}