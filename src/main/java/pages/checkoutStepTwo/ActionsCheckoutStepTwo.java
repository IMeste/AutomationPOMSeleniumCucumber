package pages.checkoutStepTwo;

import org.openqa.selenium.WebDriver;

public class ActionsCheckoutStepTwo {

    private final ElementsCheckoutStepTwo elementsCheckoutStepTwo;

    public ActionsCheckoutStepTwo(WebDriver driver) {
        elementsCheckoutStepTwo = new ElementsCheckoutStepTwo(driver);
    }

    public void clickFinish(){
        elementsCheckoutStepTwo.buttonFinish.click();
    }
}
