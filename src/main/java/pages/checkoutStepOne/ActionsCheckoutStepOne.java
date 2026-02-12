package pages.checkoutStepOne;

import org.openqa.selenium.WebDriver;

public class ActionsCheckoutStepOne {

    private final ElementsCheckoutStepOne elementsCheckoutStepOne;

    public ActionsCheckoutStepOne(WebDriver driver) {
        elementsCheckoutStepOne = new ElementsCheckoutStepOne(driver);
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
