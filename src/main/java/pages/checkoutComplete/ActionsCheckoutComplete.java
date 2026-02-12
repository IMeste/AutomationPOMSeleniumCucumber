package pages.checkoutComplete;

import org.openqa.selenium.WebDriver;

public class ActionsCheckoutComplete {

    private final ElementsCheckoutComplete elementsCheckoutComplete;

    public ActionsCheckoutComplete(WebDriver driver) {
        elementsCheckoutComplete = new ElementsCheckoutComplete(driver);
    }

    public String getTextCheckoutComplete(){
        return elementsCheckoutComplete.h2PaymentComplete.getText();
    }
}
