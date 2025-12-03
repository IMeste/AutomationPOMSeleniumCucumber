package pages.checkoutStepTwo;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

public class ActionsCheckoutStepTwo {
    private final WebDriver driver;
    private final ElementsCheckoutStepTwo elementsCheckoutStepTwo;

    public ActionsCheckoutStepTwo() {
        driver = DriverFactory.getDriver();
        elementsCheckoutStepTwo = new ElementsCheckoutStepTwo();
    }

    public void clickFinish(){
        elementsCheckoutStepTwo.buttonFinish.click();
    }
}
