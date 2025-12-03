package pages.checkoutStepTwo;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsCheckoutStepTwo {
    public WebDriver driver;
    @FindBy(xpath = "//button[@id='finish']") public WebElement buttonFinish;

    public ElementsCheckoutStepTwo() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
}
