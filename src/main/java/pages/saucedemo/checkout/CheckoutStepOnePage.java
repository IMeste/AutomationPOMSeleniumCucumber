package pages.saucedemo.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutStepOnePage extends BasePage {

    private final By inputFirstName = By.id("first-name");
    private final By inputLastName = By.id("last-name");
    private final By inputPostalCode = By.id("postal-code");
    private final By buttonContinue = By.id("continue");
    private final By titulo = By.cssSelector(".title");

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTituloDisplayed() {
        return isElementVisible(titulo);
    }

    public By getTitulo(){
        return titulo;
    }

    public void sendFirstName(String firstName){
        type(inputFirstName, firstName, "Input First Name");
    }

    public void sendLastName(String lastName){
        type(inputLastName, lastName, "Input Last Name");
    }

    public void sendPostalCode(String postalCode){
        type(inputPostalCode, postalCode, "Input Postal Code");
    }

    public void clickContinue(){
        click(buttonContinue, "Button Continue");
    }
}
