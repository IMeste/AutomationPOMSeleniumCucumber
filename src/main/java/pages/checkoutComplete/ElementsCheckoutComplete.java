package pages.checkoutComplete;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsCheckoutComplete {

    @FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']") public WebElement h2PaymentComplete;

    public ElementsCheckoutComplete(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
