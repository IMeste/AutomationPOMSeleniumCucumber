package pages.cart;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

public class ActionsCart {

    private final WebDriver driver;
    private final ElementsCart elementsCart;

    public ActionsCart() {
        driver = DriverFactory.getDriver();
        elementsCart = new ElementsCart();
    }

    public void clickCheckout(){
        elementsCart.buttonCheckout.click();
    }
}
