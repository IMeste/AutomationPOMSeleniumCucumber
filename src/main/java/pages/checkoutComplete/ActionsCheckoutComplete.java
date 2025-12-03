package pages.checkoutComplete;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

public class ActionsCheckoutComplete {
    private final WebDriver driver;
    private final ElementsCheckoutComplete elementsCheckoutComplete;

    public ActionsCheckoutComplete() {
        driver = DriverFactory.getDriver();
        elementsCheckoutComplete = new ElementsCheckoutComplete();
    }

    public String getTextCheckoutComplete(){
        return elementsCheckoutComplete.h2PaymentComplete.getText();
    }
}
