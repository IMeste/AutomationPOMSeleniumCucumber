package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsCart {

    @FindBy(xpath = "//button[@id='checkout']") public WebElement buttonCheckout;

    public ElementsCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
