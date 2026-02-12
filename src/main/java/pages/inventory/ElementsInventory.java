package pages.inventory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsInventory {
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") public WebElement buttonAddSauceLabsBackpack;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") public WebElement buttonAddSauceLabsBikeLight;
    @FindBy(xpath = "//a[@class='shopping_cart_link']") public WebElement aLinkShoppingCart;

    public ElementsInventory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
