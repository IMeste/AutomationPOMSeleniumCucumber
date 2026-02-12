package pages.cart;

import org.openqa.selenium.WebDriver;

public class ActionsCart {

    private final ElementsCart elementsCart;

    public ActionsCart(WebDriver driver) {
        elementsCart = new ElementsCart(driver);
    }

    public void clickCheckout(){
        elementsCart.buttonCheckout.click();
    }
}
