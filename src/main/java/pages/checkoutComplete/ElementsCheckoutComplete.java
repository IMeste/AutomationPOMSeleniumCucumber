package pages.checkoutComplete;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsCheckoutComplete {
    public WebDriver driver;
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']") public WebElement h2PaymentComplete;

    public ElementsCheckoutComplete() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
}
