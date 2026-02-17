package pages.saucedemo.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutCompletePage extends BasePage {

    private final By paymentHeaderLabel = By.cssSelector(".complete-header");
    private final By paymentCompleteLabel = By.cssSelector(".complete-text");
    private final By buttonBackHome = By.id("back-to-products");
    private final By titulo = By.cssSelector(".title");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTituloDisplayed() {
        return isElementVisible(titulo);
    }

    public By getTitulo(){
        return titulo;
    }

    public String getTextCheckoutHeader(){
        return getText(paymentHeaderLabel);
    }

    public By getByPaymentHeaderLabel() {
        return paymentHeaderLabel;
    }

    public String getTextCheckoutComplete(){
        return getText(paymentCompleteLabel);
    }

    public By getByCheckoutComplete() {
        return paymentCompleteLabel;
    }

    public void clickBackHome(){
        click(buttonBackHome, "Button Back Home");
    }
}
