package pages.checkoutStepOne;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsCheckoutStepOne {
    public WebDriver driver;
    @FindBy(xpath = "//input[@id='first-name']") public WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='last-name']") public WebElement inputLastName;
    @FindBy(xpath = "//input[@id='postal-code']") public WebElement inputPostalCode;
    @FindBy(xpath = "//input[@id='continue']") public WebElement buttonContinue;

    public ElementsCheckoutStepOne() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
}
