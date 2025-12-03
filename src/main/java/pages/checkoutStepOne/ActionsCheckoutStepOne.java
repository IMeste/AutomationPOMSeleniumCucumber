package pages.checkoutStepOne;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

public class ActionsCheckoutStepOne {
    private final WebDriver driver;
    private final ElementsCheckoutStepOne elementsCheckoutStepOne;

    public ActionsCheckoutStepOne() {
        driver = DriverFactory.getDriver();
        elementsCheckoutStepOne = new ElementsCheckoutStepOne();
    }

    public void sendFirstName(String firstName){
        elementsCheckoutStepOne.inputFirstName.sendKeys(firstName);
    }

    public void sendLastName(String lastName){
        elementsCheckoutStepOne.inputLastName.sendKeys(lastName);
    }

    public void sendPostalCode(String postalCode){
        elementsCheckoutStepOne.inputPostalCode.sendKeys(postalCode);
    }

    public void clickContinue(){
        elementsCheckoutStepOne.buttonContinue.click();
    }
}
