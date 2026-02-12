package pages.checkoutStepTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsCheckoutStepTwo {

    @FindBy(xpath = "//button[@id='finish']") public WebElement buttonFinish;

    public ElementsCheckoutStepTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
